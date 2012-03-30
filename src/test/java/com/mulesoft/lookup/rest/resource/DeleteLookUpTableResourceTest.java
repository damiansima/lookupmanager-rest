package com.mulesoft.lookup.rest.resource;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.restlet.Request;
import org.springframework.util.StringUtils;

/**
 * This class intents to validate that the front line class of the REST API
 * {@link DeleteLookUpTableResource} will be returning the information requested
 * correctly whit out having to deploy it.
 * 
 * @author damiansima
 * 
 */
public class DeleteLookUpTableResourceTest {

	/**
	 * Validate that the deleteData actually deletes the information requested in
	 * LookUp Table specified.
	 * 
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void deleteDataTest() throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		Map<String, Object> fakeMap = new HashMap<String, Object>();
		fakeMap.put("key", "locidVal,pmVal");

		Request requestMock = EasyMock.createMock(Request.class);
		EasyMock.expect(requestMock.getAttributes()).andReturn(fakeMap).anyTimes();

		EasyMock.replay(requestMock);

		DeleteLookUpTableResource deleteResource = new DeleteLookUpTableResource();

		Field requestField = DeleteLookUpTableResource.class.getSuperclass()
				.getDeclaredField("lutRequest");
		requestField.setAccessible(true);
		requestField.set(deleteResource, requestMock);

		String response = deleteResource.deleteData();

		Assert.assertNotNull("The response shouldn't be null.", response);
		Assert
				.assertTrue(
						"The response should contain the value of the key indicating they're being evaluated",
						response.contains("locidVal,pmVal"));

		System.out.println(response);

		EasyMock.verify(requestMock);
	}

}
