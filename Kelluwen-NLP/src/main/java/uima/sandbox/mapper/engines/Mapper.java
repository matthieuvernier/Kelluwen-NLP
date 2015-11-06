package uima.sandbox.mapper.engines;

import java.io.FileInputStream;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.Feature;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Level;

import uima.sandbox.mapper.resources.Mapping;

public class Mapper extends JCasAnnotator_ImplBase {

	private Mapping mapping;
	
	private void setMapping(Mapping conversion) {
		this.mapping = conversion;
	}
	
	private Mapping getMapping() {
		return this.mapping;
	}
		
	private String source;
	
	private void setSource(String feature) {
		this.source = feature;
	}
	
	private String getSource() {
		return this.source;
	}

	private Type sourceType;
	private Feature sourceFeature;
	
	private void setSource(JCas cas) throws AnalysisEngineProcessException {
		try {
		String source = this.getSource();
		String[] items = source.split(":");
		if (items.length == 2) {
			this.sourceType = cas.getRequiredType(items[0].trim());
			this.sourceFeature = cas.getRequiredFeature(this.sourceType, items[1].trim());
		} else {
			this.sourceType = cas.getRequiredType(source);
			this.sourceFeature = null;
		}
		} catch (CASException e) {
			throw new AnalysisEngineProcessException(e);
		}
	}
	
	private Type getSourceType() {
		return this.sourceType;
	}
	
	private Feature getSourceFeature() {
		return this.sourceFeature;
	}
	
	private String target;
	
	private void setTarget(String feature) {
		this.target = feature;
	}
	
	private String getTarget() {
		return this.target;
	}

	private Type targetType;
	private Feature targetFeature;
	
	private void setTarget(JCas cas) throws AnalysisEngineProcessException {
		try {
		String source = this.getTarget();
		String[] items = source.split(":");
		if (items.length == 2) {
			this.targetType = cas.getRequiredType(items[0].trim());
			this.targetFeature = cas.getRequiredFeature(this.targetType, items[1].trim());
		} else {
			this.targetType = cas.getRequiredType(source);
			this.targetFeature = null;
		}
		} catch (CASException e) {
			throw new AnalysisEngineProcessException(e);
		}
	}
	
	private Feature getTargetFeature() {
		return this.targetFeature;
	}
	
	private Boolean update;
	
	private void enableUpdate(Boolean enabled) {
		this.update = enabled;
	}
	
	private Boolean update() {
		return this.update;
	}
		
	@Override
	public void initialize(UimaContext context) throws ResourceInitializationException {
		super.initialize(context);
		try {
			if (this.getMapping() == null) {
				Mapping mapping = (Mapping) context.getResourceObject("Mapping");
				this.setMapping(mapping);				
				String path = (String) context.getConfigParameterValue("File");
	            if (path != null) {
	            	FileInputStream inputStream = new FileInputStream(path);
	        		this.getContext().getLogger().log(Level.INFO, "Loading  " + path);
	        		this.getMapping().load(inputStream);
	            }
			}
			if (this.getSource() == null) {
				String source = (String) context.getConfigParameterValue("Source");
				this.setSource(source);				
			}
			if (this.getTarget() == null) {
				String target = (String) context.getConfigParameterValue("Target");
				this.setTarget(target);				
			}
			if (this.update() == null) {
				Boolean update = (Boolean) context.getConfigParameterValue("Update");
				this.enableUpdate(update == null ? Boolean.TRUE : update);				
			}
		} catch (Exception e) {
            throw new ResourceInitializationException(e);
		}
	}
	
	@Override
	public void process(JCas cas) throws AnalysisEngineProcessException {
		this.setSource(cas);
		this.setTarget(cas);
		AnnotationIndex<Annotation> index = cas.getAnnotationIndex(this.getSourceType());
        FSIterator<Annotation> iter = index.iterator();
        while (iter.hasNext()) {
        	Annotation annotation = iter.next();
        	String source = null;
        	if (this.getSourceFeature() == null) { 
        		source = annotation.getCoveredText();
        	} else {
        		source = annotation.getStringValue(this.getSourceFeature());
        	}
        	if (source != null) { 
        		String target = this.getMapping().get(source);
        		if (target != null) { 
        			if (this.update().booleanValue()) {
    					this.update(cas, annotation, this.getTargetFeature(), target);
    				} else {
    					this.create(cas, this.getTargetFeature(), annotation.getBegin(), annotation.getEnd(), target);
    				}        			
        		}
            }
        }
	}

	private void update(JCas cas, Annotation annotation, Feature feature, String value) {
		annotation.setStringValue(feature,value);
	}
	
	private void create(JCas cas, Feature feature, int begin, int end, String value) {
		Type type = feature.getDomain();
		AnnotationFS annotation = cas.getCas().createAnnotation(type, begin, end);
		annotation.setStringValue(feature,value);
		cas.addFsToIndexes(annotation);
	}
	
}
