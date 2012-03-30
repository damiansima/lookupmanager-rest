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
 * {@link AdminLookUpTableResource} will be returning the information requested
 * correctly whit out having to deploy it.
 * 
 * @author damiansima
 * 
 */
public class AdminLookUpTableResourceTest {

	/**
	 * Validate that the createEntity actually creates an entity for the LookUp
	 * Table specified.
	 * 
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void createEntityTest() throws SecurityException,
			NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Map<String, Object> fakeMap = new HashMap<String, Object>();
		fakeMap.put("keyfields", "locidVal,pmVal");
		fakeMap.put("valuefields", "afieldValue,aSecondFieldValue");

		Request requestMock = EasyMock.createMock(Request.class);
		EasyMock.expect(requestMock.getAttributes()).andReturn(fakeMap).anyTimes();

		EasyMock.replay(requestMock);

		AdminLookUpTableResource adminResource = new AdminLookUpTableResource();

		Field requestField = AdminLookUpTableResource.class.getSuperclass()
				.getDeclaredField("lutRequest");
		requestField.setAccessible(true);
		requestField.set(adminResource, requestMock);

		String response = adminResource.createEntity();

		Assert.assertNotNull("The response shouldn't be null.", response);
		Assert
				.assertTrue(
						"The response should contain the value of the key Fields indicating they're being evaluated",
						response.contains("locidVal,pmVal"));
		Assert
				.assertTrue(
						"The response should contain the value of the value Fields indicating they're being evaluated",
						response.contains("afieldValue,aSecondFieldValue"));
		System.out.println(response);

		EasyMock.verify(requestMock);
	}

	/**
	 * Validate that the dropEntity actually drops/deletes an entity representing
	 * a LookUp Table specified.
	 * 
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void dropEntityTest() throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {

		AdminLookUpTableResource adminResource = new AdminLookUpTableResource();

		String response = adminResource.dropEntity();

		Assert.assertNotNull("The response shouldn't be null.", response);
		System.out.println(response);

	}

}
