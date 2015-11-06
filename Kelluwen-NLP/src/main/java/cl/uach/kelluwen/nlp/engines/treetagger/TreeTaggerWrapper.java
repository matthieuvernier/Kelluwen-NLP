package cl.uach.kelluwen.nlp.engines.treetagger;

import java.util.ArrayList;
import java.util.List;

import org.annolab.tt4j.TokenAdapter;
import org.annolab.tt4j.TokenHandler;
import org.annolab.tt4j.TreeTaggerException;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceAccessException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Level;

import cl.uach.kelluwen.nlp.engines.treetagger.TreeTaggerParameter;

public class TreeTaggerWrapper extends JCasAnnotator_ImplBase {

	private void setTreeTaggerHomeDirectory(String home) {
		 System.setProperty("treetagger.home", home);
	}
	
	private TreeTaggerParameter parameter;
	
	private void setParameter(TreeTaggerParameter parameter) {
		this.parameter = parameter;
	}
	
	private TreeTaggerParameter getParameter() {
		return this.parameter;
	}
	
	private Handler handler;
	
	private void setHandler() {
		this.handler = new Handler();
	}
	
	private Handler getHandler() {
		return this.handler;
	}
	
	private Adapter adapter;
	
	private void setAdapter() {
		this.adapter = new Adapter();
	}
	
	private Adapter getAdapter() {
		return this.adapter;
	}
	
	private org.annolab.tt4j.TreeTaggerWrapper<Annotation> wrapper;	
	
	private void setWrapper() throws Exception {
		this.wrapper = new org.annolab.tt4j.TreeTaggerWrapper<Annotation>();
		this.wrapper.setHandler(this.getHandler());
		this.wrapper.setAdapter(this.getAdapter());
		this.wrapper.setModel(this.getParameter().getModel());	
	}
	
	private org.annolab.tt4j.TreeTaggerWrapper<Annotation> getWrapper() {
		return this.wrapper;
	}
	
	private String annotationType;
	
	private void setAnnotationType(String type) {
		this.annotationType = type;
	}
	
	private Type getAnnotationType(JCas cas) {
		return cas.getTypeSystem().getType(this.annotationType);
	}
	
	private String tagType;
	private String tagFeature;
	
	private void setTagFeature(String feature) {
		String[] path = feature.split(":");
		if (path.length == 2) {
			this.tagType = path[0];
			this.tagFeature = path[1];
		} else {
			this.tagFeature = feature;
		}
	}
	
	private Type getTagAnnotationType(JCas cas) {
		return cas.getTypeSystem().getType(this.tagType);
	}
	
	private Feature getTagFeature(JCas cas,Type type,boolean update) {
		if (update) {
			return type.getFeatureByBaseName(this.tagFeature);
		} else {
			Type tagType = this.getTagAnnotationType(cas);
			return tagType.getFeatureByBaseName(this.tagFeature);
		}
	}
	
	private String lemmaType;
	private String lemmaFeature;
	
	private void setLemmaFeature(String feature) {
		String[] path = feature.split(":");
		if (path.length == 2) {
			this.lemmaType = path[0];
			this.lemmaFeature = path[1];
		} else {
			this.lemmaFeature = feature;
		}
	}
	
	private Type getLemmaAnnotationType(JCas cas) {
		return cas.getTypeSystem().getType(this.lemmaType);
	}
	
	private Feature getLemmaFeature(JCas cas,Type type,boolean update) {
		if (update) {
			return type.getFeatureByBaseName(this.lemmaFeature);
		} else {
			Type lemmaType = this.getLemmaAnnotationType(cas);
			return lemmaType.getFeatureByBaseName(this.lemmaFeature);
		}
	}
	
	private boolean updatingRequired;
	
	private void requireUpdate(boolean required) {
		this.updatingRequired = required;
		this.getHandler().enableUpodate(required);
	}
	
	private boolean isUpdateRequired() {
		return this.updatingRequired;
	}
	
	@Override
	public void initialize(UimaContext context) throws ResourceInitializationException {
		super.initialize(context);
		try {
			String home = (String) context.getConfigParameterValue("TreeTaggerHomeDirectory");
			this.setTreeTaggerHomeDirectory(home);
			TreeTaggerParameter configuration = (TreeTaggerParameter) context.getResourceObject("TreeTaggerParameter");
			this.setParameter(configuration);
			String parameter = (String) context.getConfigParameterValue("TreeTaggerParameterFile");
			configuration.override(parameter);
			this.setHandler();
			this.setAdapter();
			this.setWrapper();
			String type = (String) context.getConfigParameterValue("AnnotationType");
			this.setAnnotationType(type);	
			String tagFeature = (String) context.getConfigParameterValue("TagFeature");
			this.setTagFeature(tagFeature);
			String lemmaFeature = (String) context.getConfigParameterValue("LemmaFeature");
			this.setLemmaFeature(lemmaFeature);
			Boolean required = (Boolean) context.getConfigParameterValue("UpdateAnnotationFeatures");
			this.requireUpdate(required.booleanValue());
		} catch (ResourceAccessException e) {
			throw new ResourceInitializationException(e);
		} catch (Exception e) {
			throw new ResourceInitializationException(e);
		}
	}
	
	@Override
	public void process(JCas cas) throws AnalysisEngineProcessException {
		try {
			this.getWrapper().setModel(this.getParameter().getModel());
			Type type = this.getAnnotationType(cas);
			Feature tagFeature = this.getTagFeature(cas,type,this.isUpdateRequired());
			Feature lemmaFeature = this.getLemmaFeature(cas,type,this.isUpdateRequired());
			this.getHandler().setTagFeature(tagFeature);
			this.getHandler().setLemmaFeature(lemmaFeature);
			AnnotationIndex<Annotation> index = cas.getAnnotationIndex(type);
			FSIterator<Annotation> iter = index.iterator();
			List<Annotation> tokens = new ArrayList<Annotation>();
			while (iter.hasNext()) {
				Annotation token = iter.next();
				tokens.add(token);
			}
			this.getWrapper().process(tokens);
		} catch (TreeTaggerException e) {
			Throwable c = e.getCause();
			if (c == null) {
				this.getContext().getLogger().log(Level.WARNING,e.getMessage());
			} else {
				this.getContext().getLogger().log(Level.WARNING,c.getMessage());				
			}
		} catch (Exception e) {
			throw new AnalysisEngineProcessException(e);
		}
	}
	
	private class Handler implements TokenHandler<Annotation> {	
	
		private Feature tagFeature;
		
		public void setTagFeature(Feature feature) {
			this.tagFeature = feature;
		}
		
		private Feature lemmaFeature;
		
		public void setLemmaFeature(Feature feature) {
			this.lemmaFeature = feature;
		}
		
		private boolean update;
		
		public void enableUpodate(boolean enabled) {
			this.update = enabled;
		}
		
		public void token(Annotation annotation, String tag, String lemma) {
			CAS cas = annotation.getCAS();
			int begin = annotation.getBegin();
			int end = annotation.getEnd();
			String picked = null;
			if (lemma == null) {
				picked = annotation.getCoveredText(); // "unknown"
			} else {
				String lemmata[] = lemma.split("\\|");
				if (lemmata.length == 0) {
					picked = lemma;
				} else {
					picked = lemmata[lemmata.length - 1];
				}						
			}
			if (picked.endsWith("?")) {
				picked = picked.substring(0, picked.length() - 1);
			}
			assert (picked != null);
			if (this.update) {
				this.update(cas, annotation, this.tagFeature, tag);
				this.update(cas, annotation, this.lemmaFeature, picked);
			} else {
				this.annotate(cas, this.tagFeature, begin, end, tag);
				this.annotate(cas, this.lemmaFeature, begin, end, picked);
			}
		}

		private void update(CAS cas, Annotation annotation, Feature feature, String value) {
			annotation.setStringValue(feature,value);
		}
		
		private void annotate(CAS cas, Feature feature, int begin, int end, String value) {
			Type type = feature.getDomain();
			AnnotationFS annotation = cas.createAnnotation(type, begin, end);
			annotation.setStringValue(feature,value);
			cas.addFsToIndexes(annotation);
		}

	}
	
	private class Adapter implements TokenAdapter<Annotation> {

		public String getText(Annotation annotation) {
			synchronized (annotation.getCAS()) {
				return annotation.getCoveredText().toLowerCase();		
			}
		}
		
	}
	
}
