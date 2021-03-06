package cl.uach.kelluwen.nlp.io.csv;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import cl.uach.kelluwen.nlp.types.KelluwenMessage;

/**
 * A collection reader that reads datas from a CSV file representing annotated data from Kelluwen DB.
 * 
 * It can be configured with the following parameters:
 * <ul>
 * <li><code>InputFile</code> the csv file to analyze</li>
 * </ul>
 * 
 * 
 */
public class CsvKelluwenDB_TopicEvaluation_CR extends CollectionReader_ImplBase {

	/**
	 * Name of configuration parameter that must be set to the path of the CSV file.
	 */
	public static final String PARAM_INPUTFILE = "InputFile";

	private File corpus;
	private int mCurrentIndex;
	private StringTokenizer stLines;

	/**
	 * @see org.apache.uima.collection.CollectionReader_ImplBase#initialize()
	 */
	public void initialize() throws ResourceInitializationException {
		corpus= new File(((String) getConfigParameterValue(PARAM_INPUTFILE)).trim());
		mCurrentIndex = 0;

		try {
			String text = FileUtils.file2String(corpus, "UTF-8");
			stLines= new StringTokenizer(text,"\n");
			//skip first line
			//stLines.nextToken();


		} catch (IOException e) {
			throw new ResourceInitializationException(ResourceConfigurationException.RESOURCE_DATA_NOT_VALID,
					new Object[] { PARAM_INPUTFILE, this.getMetaData().getName(), corpus.getPath() });
		}
	}

	public void getNext(CAS aCAS) throws IOException, CollectionException {
		JCas jcas;
		try {
			jcas = aCAS.getJCas();
		} catch (CASException e) {
			throw new CollectionException(e);
		}

		String line = stLines.nextToken();
		String[] elements = line.split(";");
		//! be careful with number of columns...
		if (elements.length>=13){
			KelluwenMessage message = new KelluwenMessage(jcas); 
			message.setMessageType(new Integer(elements[0].replace("\"", "").replace("\n", "")));
			message.setIdMessage(new Integer(elements[1].replace("\"", "")));
			message.setIdSuperMessage(new Integer(elements[2].replace("\"", "")));
			message.setIdUser(new Integer(elements[3].replace("\"", "")));
			message.setName(elements[4].replace("\"", ""));
			message.setUserType(new Integer(elements[5].replace("\"", "")));
			message.setIdExercicePattern(new Integer(elements[6].replace("\"", "")));
			message.setIdExperience(new Integer(elements[7].replace("\"", "")));
			message.setYear(new Integer(elements[8].replace("\"", "")));
			message.setSemester(elements[9].replace("\"", ""));
			message.setNumberOfStudents(new Integer(elements[10].replace("\"", "")));

			message.addToIndexes(jcas);

			String text=elements[12];
			//String text=elements[11];
			
			//message.setTopic(elements[13]);
			
			jcas.setDocumentText(text);
			message.setBegin(0);
			message.setEnd(text.length());

		}
		else {
			System.out.println("pb: "+line);
			jcas.setDocumentText("(no mensaje)");	
		}
		mCurrentIndex=mCurrentIndex+1;
	}

	/**
	 * @see org.apache.uima.collection.base_cpm.BaseCollectionReader#getProgress()
	 */
	public Progress[] getProgress() {
		return new Progress[] { new ProgressImpl(mCurrentIndex, stLines.countTokens(), Progress.ENTITIES) };
	}

	/**
	 * @see org.apache.uima.collection.CollectionReader#hasNext()
	 */
	public boolean hasNext() {
		return stLines.hasMoreTokens();
	}

	public void close() throws IOException {
//		System.out.println("duplicates filtered = "+duplicates);
	}

}
