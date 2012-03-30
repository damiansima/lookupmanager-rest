package com.mulesoft.lookup.restlet.integration;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Assert;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;


/**
 * Integration test for the REST API. This class aloud us to send HTTP's
 * methods: GET, PUT, DELETE, etc. against the deployed REST application.
 */
public class AdminLookUpTableIntegration {

	private static final String BASE_URI = "http://localhost:8080/lookupmanager-rest/";
	
	public static void main(String[] args) {
		AdminLookUpTableIntegration test = new AdminLookUpTableIntegration();

		try {
			test.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() throws ResourceException, IOException {
		this.testPut();
		this.testDelete();
	}

	public void testPut() throws IOException {
		String putURI = BASE_URI
				+ "create/partner/peopleMatter/client/boloco/lookuptable/faketable/keyfields/locidVal,pmVal/valuefields/afieldValue,aSecondFieldValue";
		
		ClientResource cr = new ClientResource(putURI);

		Representation representation = cr.put("");
		
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}
	
	public void testDelete() throws IOException{
		String deleteURI = BASE_URI
				+ "drop/partner/peopleMatter/client/boloco/lookuptable/faketable";
		
		ClientResource cr = new ClientResource(deleteURI);

		Representation representation = cr.delete();
		
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
		
	}

}
