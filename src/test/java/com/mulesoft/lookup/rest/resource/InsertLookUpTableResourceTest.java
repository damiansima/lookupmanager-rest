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
 * {@link InsertLookUpTableResource} will be returning the information requested
 * correctly whit out having to deploy it.
 * 
 * @author damiansima
 * 
 */
public class InsertLookUpTableResourceTest {

	/**
	 * Validate that the saveData actually saves the information sent in LookUp
	 * Table specified.
	 * 
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void saveDataTest() throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		Map<String, Object> fakeMap = new HashMap<String, Object>();
		fakeMap.put("keyfields", "locidVal,pmVal");
		fakeMap.put("valuefields", "afieldValue,aSecondFieldValue");

		Request requestMock = EasyMock.createMock(Request.class);
		EasyMock.expect(requestMock.getAttributes()).andReturn(fakeMap)
				.anyTimes();

		EasyMock.replay(requestMock);

		InsertLookUpTableResource insertlistResource = new InsertLookUpTableResource();

		Field requestField = InsertLookUpTableResource.class.getSuperclass()
				.getDeclaredField("lutRequest");
		requestField.setAccessible(true);
		requestField.set(insertlistResource, requestMock);

		String response = insertlistResource.saveData();

		Assert.assertNotNull("The response shouldn't be null.", response);
		Assert.assertTrue(
				"The response should contain the value of the key Fields indicating they're being evaluated",
				response.contains("locidVal,pmVal"));
		Assert.assertTrue(
				"The response should contain the value of the value Fields indicating they're being evaluated",
				response.contains("afieldValue,aSecondFieldValue"));
		System.out.println(response);

		EasyMock.verify(requestMock);
	}

}
