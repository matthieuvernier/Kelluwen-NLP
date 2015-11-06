package cl.uach.kelluwen.nlp.engines.treetagger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.uima.UIMAFramework;
import org.apache.uima.resource.DataResource;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.SharedResourceObject;
import org.apache.uima.util.Level;

public class TreeTaggerParameter implements SharedResourceObject {

	private Properties properties;
	
	private void setProperties() {
		this.properties = new Properties();
	}
	
	private Properties getProperties() {
		return this.properties;
	}
	
	private String getFile() throws IOException {
		return this.getProperties().getProperty("file");
	}
	
	private String getEncoding() {
		return this.getProperties().getProperty("encoding");
	}
	
	public String getModel() throws IOException {
		return this.getFile() + ":" + this.getEncoding();
	}
	
	private void doLoad(InputStream inputStream) throws IOException {
		this.getProperties().loadFromXML(inputStream);
	}
	
	public TreeTaggerParameter() {
		this.setProperties();
	}
	
	public void load(DataResource data) throws ResourceInitializationException {
		try {
			this.doLoad(data.getInputStream());
		} catch (Exception e) {
			throw new ResourceInitializationException(e);
		}
	}

	public void override(String parameter) throws IOException {
		if (parameter != null) {
			InputStream inputStream = new FileInputStream(parameter);
			UIMAFramework.getLogger().log(Level.INFO, "Loading " + parameter);
			this.doLoad(inputStream);			
		}
	}
			
}
