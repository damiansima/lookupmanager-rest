package com.mulesoft.lookup.rest.resource;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.restlet.Request;

/**
 * This class intents to validate that the front line class of the REST API will
 * be returning the information requested correctly whit out having to deploy
 * it.
 * 
 * @author damiansima
 * 
 */
public class ListLookUpTableResourceTest {

	@Test
	public void dummyTest() {

	}

	/**
	 * Validate that the getData returns a valid JSON representation of the
	 * LookUp Table requested.
	 * 
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void getDataTest() throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		Map<String, Object> fakeMap = new HashMap<String, Object>();

		Request requestMock = EasyMock.createMock(Request.class);
		EasyMock.expect(requestMock.getAttributes()).andReturn(fakeMap)
				.anyTimes();

		EasyMock.replay(requestMock);

		ListLookUpTableResource listResource = new ListLookUpTableResource();

		Field requestField = ListLookUpTableResource.class.getSuperclass()
				.getDeclaredField("lutRequest");
		requestField.setAccessible(true);
		requestField.set(listResource, requestMock);

		String response = listResource.getData();

		Assert.assertNotNull(response);
		Assert.assertNotNull("The response shouldn't be null.", response);

		EasyMock.verify(requestMock);
	}

	/**
	 * Validate that the getData returns a valid JSON representation of the
	 * LookUp Table for the key requested .
	 * 
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void getDataByKeyTest() throws SecurityException,
			NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {
		Map<String, Object> fakeMap = new HashMap<String, Object>();
		fakeMap.put("key", "fakeKey");

		Request requestMock = EasyMock.createMock(Request.class);
		EasyMock.expect(requestMock.getAttributes()).andReturn(fakeMap)
				.anyTimes();

		EasyMock.replay(requestMock);

		ListLookUpTableResource listResource = new ListLookUpTableResource();

		Field requestField = ListLookUpTableResource.class.getSuperclass()
				.getDeclaredField("lutRequest");
		requestField.setAccessible(true);
		requestField.set(listResource, requestMock);

		String response = listResource.getData();

		Assert.assertNotNull("The response shouldn't be null.", response);
		Assert.assertTrue(
				"The response should contain the value of the  key indicating being evaluated",
				response.contains("fakeKey"));
		System.out.println(response);

		EasyMock.verify(requestMock);
	}

}
