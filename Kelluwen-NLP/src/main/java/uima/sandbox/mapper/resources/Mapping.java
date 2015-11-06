package uima.sandbox.mapper.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.uima.resource.SharedResourceObject;

public interface Mapping extends SharedResourceObject {

	/**
	 * provides the value associated to the given key.
	 * 
	 * @param key the key
	 * @return the value associated to the key
	 */
	public String get(String key);

	/**
	 * loads the mapping from a given input stream.
	 * 
	 * @param inputStream the input stream from which the mapping is loaded
	 * @throws IOException if something wrong happens while loading the mapping
	 */
	public void load(InputStream inputStream) throws IOException;
	
	/**
	 * stores the mapping from a given output stream.
	 * 
	 * @param outputStream the output stream to which the mapping is stored
	 * @throws IOException if something wrong happens while storing the mapping
	 */
	public void store(OutputStream outputStream) throws IOException;

}