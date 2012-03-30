package com.mulesoft.lookup.rest.resource;

import org.restlet.resource.Delete;
import org.restlet.resource.Put;

public class AdminLookUpTableResource extends AbstractLookUpTableResource {
	private static final String KEYFIELDS_ATTRIBUTE = "keyfields";
	private static final String VALUEFIELDS_ATTRIBUTE = "valuefields";

	/**
	 * It's the REST operation to create an entity that represent a Lookup Table
	 * 
	 * @return
	 */
	@Put
	public String createEntity() {

		String keyFields = lutRequest.getAttributes().get(KEYFIELDS_ATTRIBUTE)
				.toString();
		String valueFields = lutRequest.getAttributes().get(VALUEFIELDS_ATTRIBUTE)
				.toString();

		StringBuilder builder = new StringBuilder();
		builder.append("Partner: ").append(partner).append("|");
		builder.append("Client: ").append(client).append("|");
		builder.append("LookUp Table: ").append(lookuptable).append("|");
		builder.append("Key Values: ").append(keyFields).append("|");
		builder.append("Fields Values: ").append(valueFields).append("|");

		return builder.toString();
	}

	/**
	 * It's the REST operation to drop an entity that represent a Lookup Table
	 * 
	 * @return
	 */
	@Delete
	public String dropEntity() {
		StringBuilder builder = new StringBuilder();
		builder.append("Partner: ").append(partner).append("|");
		builder.append("Client: ").append(client).append("|");
		builder.append("LookUp Table: ").append(lookuptable).append("|");

		return builder.toString();
	}

}
