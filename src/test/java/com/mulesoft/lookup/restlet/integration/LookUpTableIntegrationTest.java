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
public class LookUpTableIntegrationTest {
	private static final String BASE_URI = "http://localhost:8080/lookupmanager-rest/lookuptables/faketable";

	public static void main(String[] args) {
		LookUpTableIntegrationTest test = new LookUpTableIntegrationTest();

		try {
			test.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() throws ResourceException, IOException {
		this.testList();
		this.testListWhithKey();
		this.testCreate();
		this.testCreateWhithNoKeyFail();
		this.testCreateWhithNoFieldsFail();
		this.testUpdate();
		this.testUpdateWhithNoKeyFail();
		this.testUpdateWhithNoFieldsFail();
		this.testDelete();
		this.testDeleteWhithKey();
	}

	public void testList() throws ResourceException, IOException {
		String getURI = BASE_URI;

		ClientResource cr = new ClientResource(getURI);

		Representation representation = cr.get();
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	public void testListWhithKey() throws ResourceException, IOException {
		String getURI = BASE_URI + "?keys=fakekey1";

		ClientResource cr = new ClientResource(getURI);

		Representation representation = cr.get();
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	public void testCreate() throws ResourceException, IOException {
		String getURI = BASE_URI
				+ "?keys=fakekey1,fakekey2&fields=fakefield1,fakefield2,fakefield3";

		ClientResource cr = new ClientResource(getURI);

		Representation representation = cr.post("");
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	public void testCreateWhithNoFieldsFail() throws ResourceException,
			IOException {
		String getURI = BASE_URI + "?keys=fakekey1,fakekey2";

		ClientResource cr = new ClientResource(getURI);

		Representation representation = cr.post("");
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	public void testCreateWhithNoKeyFail() throws ResourceException, IOException {
		String getURI = BASE_URI + "?ields=fakefield1,fakefield2,fakefield3";

		ClientResource cr = new ClientResource(getURI);

		Representation representation = cr.post("");
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	public void testUpdate() throws ResourceException, IOException {
		String getURI = BASE_URI
				+ "?keys=fakekey1,fakekey2&fields=fakefield1,fakefield2,fakefield3";

		ClientResource cr = new ClientResource(getURI);

		Representation representation = cr.put("");
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	public void testUpdateWhithNoFieldsFail() throws ResourceException,
			IOException {
		String getURI = BASE_URI + "?keys=fakekey1,fakekey2";

		ClientResource cr = new ClientResource(getURI);

		Representation representation = cr.put("");
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	public void testUpdateWhithNoKeyFail() throws ResourceException, IOException {
		String getURI = BASE_URI + "?ields=fakefield1,fakefield2,fakefield3";

		ClientResource cr = new ClientResource(getURI);

		Representation representation = cr.put("");
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}


	
	public void testDelete() throws ResourceException, IOException {
		String getURI = BASE_URI;

		ClientResource cr = new ClientResource(getURI);

		Representation representation = cr.delete();
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}

	public void testDeleteWhithKey() throws ResourceException, IOException {
		String getURI = BASE_URI + "?keys=fakekey1";

		ClientResource cr = new ClientResource(getURI);

		Representation representation = cr.delete();
		Writer stringWriter = new StringWriter();
		representation.write(stringWriter);

		String response = stringWriter.toString();
		Assert.assertNotNull(response);
		System.out.println(response);
	}


}
