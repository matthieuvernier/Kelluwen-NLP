package cl.uach.kelluwen.io.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import cl.uach.kelluwen.nlp.types.KelluwenMessage;
import cl.uach.kelluwen.nlp.types.Token;

public class GenerateCsvKelluwenDB extends JCasAnnotator_ImplBase {

	private static String PARAM_FILEPATH    = "FilePath";
	/** Configuration variables */
	private String filePath;

	private ArrayList<String> csvLines;

	@Override
	public void initialize(UimaContext aContext)
			throws ResourceInitializationException {
		// Parent initialization
		super.initialize(aContext);

		// The output file
		filePath        = 
				(String) aContext.getConfigParameterValue(PARAM_FILEPATH);
		
		csvLines = new ArrayList<String>();

	}

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		String csvLine="";

		AnnotationIndex<KelluwenMessage> idxKelluwenMessage = jcas.getAnnotationIndex(KelluwenMessage.type);
		FSIterator<KelluwenMessage> itKelluwenMessage      = idxKelluwenMessage.iterator();
		if (itKelluwenMessage.hasNext()) {
			KelluwenMessage mKelluwenMessage = (KelluwenMessage) itKelluwenMessage.next();
			Integer col1=mKelluwenMessage.getMessageType();
			Integer col2=mKelluwenMessage.getIdMessage();
			Integer col3=mKelluwenMessage.getIdSuperMessage();
			Integer col4=mKelluwenMessage.getIdUser();
			String col5=mKelluwenMessage.getName();
			Integer col6=mKelluwenMessage.getUserType();
			Integer col7=mKelluwenMessage.getIdExercicePattern();
			Integer col8 = mKelluwenMessage.getIdExperience();
			Integer col9=mKelluwenMessage.getYear();
			String col10=mKelluwenMessage.getSemester();
			Integer col11=mKelluwenMessage.getNumberOfStudents();

			AnnotationIndex<Token> idxToken = jcas.getAnnotationIndex(Token.type);
			FSIterator<Token> itToken = idxToken.iterator();
			String col12="";
			while(itToken.hasNext()) {
				Token mToken = (Token) itToken.next();
				if (!mToken.getStopWord()&&mToken.getLemma().length()>1&&mToken.getLemma().length()<=20){
					String lemma = mToken.getLemma();

					if (lemma.startsWith("http://")){
						if (lemma.contains("youtube")){
							lemma="youtube";
						}
						else lemma="http";
					}
					col12=col12+" "+lemma;
				}
			}
			if (col12.isEmpty()){col12="NO_FULL_WORD";}
			String col13 = mKelluwenMessage.getCoveredText().replace("\n", "").replace(";", ",").replace("\"","");

			csvLine="\""+col1+"\""+";"+"\""+col2+"\""+";"+"\""+col3+"\""+";"+"\""+col4+"\""+";"+"\""+col5+"\""+";"+"\""+col6+"\""+";"+"\""+col7+"\""+";"+
					"\""+col8+"\""+";"+"\""+col9+"\""+";"+"\""+col10+"\""+";"+"\""+col11+"\""+";"+"\""+col12+"\""+";"+"\""+col13+"\"";
			
			if (!mKelluwenMessage.getFiltered()){
				csvLines.add(csvLine);
			}			
		}
	}

	@Override
	public void collectionProcessComplete()
			throws AnalysisEngineProcessException {
		// Finally, write down the file
		//System.out.println("ecriture:"+filePath);
		Random rand = new Random(); // constructeur
		
		try {
			BufferedWriter out
			= new BufferedWriter(new FileWriter(filePath+"_ALL.csv"));
			BufferedWriter out2
			= new BufferedWriter(new FileWriter(filePath+"_SAMPLE.csv"));
			for (int i=0;i<csvLines.size();i++){
				out.write(csvLines.get(i)+"\n");
				
				//add random
		        int num = rand.nextInt(100); 
		        
		        if (num<=10){
		        	out2.write(csvLines.get(i)+"\n");
		        }
		       
			}
			out.close();
		} catch (IOException e) {
			throw new AnalysisEngineProcessException(e);
		}
	}
}
