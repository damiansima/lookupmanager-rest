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
public class DeleteLookUpTableIntegration {

	private static final String BASE_URI = "http://localhost:8080/lookupmanager-rest/delete/";

	public static void main(String[] args) {
		DeleteLookUpTableIntegration test = new DeleteLookUpTableIntegration();

		try {
			test.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() throws ResourceException, IOException {
		this.testDelete();
	}

	public void testDelete() throws IOException {
		String getURI = BASE_URI
				+ "partner/peopleMatter/client/boloco/lookuptable/faketable/key/locidVal,pmVal";

		ClientResource cr = new ClientResource(getURI);

		Representation representation = cr.delete();
		
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}

}
