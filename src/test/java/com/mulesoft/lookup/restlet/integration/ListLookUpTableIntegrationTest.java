package com.mulesoft.lookup.restlet.integration;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

/**
 * Integration test for the REST API. This class aloud us to send HTTP's
 * methods: GET, PUT, DELETE, etc. against the deployed REST application.
 */
public class ListLookUpTableIntegrationTest {
	private static final String BASE_URI = "http://localhost:8080/lookupmanager-rest/list/";

	public static void main(String[] args) {
		ListLookUpTableIntegrationTest test = new ListLookUpTableIntegrationTest();

		try {
			test.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() throws ResourceException, IOException {
		this.testGet();
		this.testGetWhithKey();
//		this.testPut();
		this.testDelete();
	}

	public void testGet() throws ResourceException, IOException {
		String getURI = BASE_URI
				+ "partner/peopleMatter/client/boloco/lookuptable/fakeTable";

		ClientResource cr = new ClientResource(getURI);

		Representation representation = cr.get();
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}
	
	public void testGetWhithKey() throws ResourceException, IOException {
		String getURI = BASE_URI
				+ "partner/peopleMatter/client/boloco/lookuptable/fakeTable/key/key";

		ClientResource cr = new ClientResource(getURI);

		Representation representation = cr.get();
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}

//	public void testPut() throws IOException {
//		String putURI = BASE_URI
//				+ "partner/peopleMatter/client/boloco/lookuptable/blablablablabla";
//
//		ClientResource cr = new ClientResource(putURI);
//
//		Representation representation = cr.put("");
//		Writer stringWriter = new StringWriter();
//		representation.write(stringWriter);
//
//		String response = stringWriter.toString();
//		Assert.assertNotNull(response);
//		System.out.println(response);
//	}

	public void testDelete() throws IOException {
		String putURI = BASE_URI
				+ "partner/peopleMatter/client/boloco/lookuptable/blablablablabla";

		ClientResource cr = new ClientResource(putURI);

		Representation representation = cr.delete();
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);

	}
}
