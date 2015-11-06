package uima.sandbox.mapper.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.uima.resource.DataResource;
import org.apache.uima.resource.ResourceInitializationException;

import uima.sandbox.mapper.models.MappingFactory;

public class MappingResource implements Mapping {

	private Map<String, String> map;
	
	private void compile() {
		this.map = new HashMap<String, String>();
		if (this.model != null) {
			for (uima.sandbox.mapper.models.Map map : this.model.getMap()) {
				String key = map.getKey();
				String value = map.getValue();
				this.map.put(key, value);
			}
		}
	}
	
	public String get(String key) {
		if (this.map == null) {
			return null;
		} else if (key == null) {
			return null;
		} else {
			return this.map.get(key);
		}
	}
		
	public void load(DataResource data) throws ResourceInitializationException {
		try {
			this.load(data.getInputStream());
		} catch (Exception e) {
			throw new ResourceInitializationException(e);
		}
	}
	
	private uima.sandbox.mapper.models.Mapping model;
	
	public void load(InputStream inputStream) throws IOException {
		try {
			JAXBContext context = JAXBContext.newInstance(uima.sandbox.mapper.models.Mapping.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			StreamSource source = new StreamSource(inputStream);
			JAXBElement<uima.sandbox.mapper.models.Mapping> root = unmarshaller.unmarshal(source, uima.sandbox.mapper.models.Mapping.class);
			this.model = root.getValue();
			this.compile();
		} catch (JAXBException e) {
			throw new IOException(e);
		}
	}

	public void store(OutputStream outputStream) throws IOException {
		if (this.model != null) {
			try {
				MappingFactory factory = new MappingFactory();
				JAXBContext context = JAXBContext.newInstance(uima.sandbox.mapper.models.Mapping.class);
				JAXBElement<uima.sandbox.mapper.models.Mapping> element = factory.createMapping(this.model);
				Marshaller marshaller = context.createMarshaller();
				marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
				marshaller.marshal(element, outputStream);
			} catch (JAXBException e) {
				throw new IOException(e);
			}
		}
	}

}
