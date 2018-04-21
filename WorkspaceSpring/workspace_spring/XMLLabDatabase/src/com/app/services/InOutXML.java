package com.app.services;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class InOutXML<T> {

	/**
	 * Fa il parsing di un file XML e ne restituisce l'oggetto descritto.
	 * 
	 * @param fileXML Il file XML contenente la descrizione dell'oggetto.
	 * @param objectClass La classe dell'oggetto descritto nel file XML.
	 * @return Un oggetto del tipo descritto se l'operazione va a buon fine,
	 *         altrimenti null.
	 */
	public T readXML(File fileXML, Class<T> objectClass) {
		try {
			JAXBContext jc = JAXBContext.newInstance(objectClass);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			return (T) unmarshaller.unmarshal(fileXML);
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Crea un file XML con la descrizione di un oggetto.
	 * 
	 * @param fileXML Il file XML di output.
	 * @param object Oggetto di cui si vuole la descrizione XML
	 * @return true se l'operazione va a buon fine, altrimenti false.
	 */
	public boolean writeXML(File fileXML, T object) {
		try {
			JAXBContext jc = JAXBContext.newInstance(object.getClass());
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(object, fileXML);
			return true;
		} catch (JAXBException e) {
			e.printStackTrace();
			return false;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return false;
		}	
	}

}
