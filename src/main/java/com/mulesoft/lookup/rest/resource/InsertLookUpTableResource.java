package com.mulesoft.lookup.rest.resource;

import org.restlet.resource.Get;

public class InsertLookUpTableResource extends AbstractLookUpTableResource {
	private static final String KEYFIELDS_ATTRIBUTE = "keyfields";
	private static final String VALUEFIELDS_ATTRIBUTE = "valuefields";

	/**
	 * It's the REST operation to save information for a Lookup Table
	 * 
	 * @return
	 */
	@Get
	public String saveData() {

		String keyFields = lutRequest.getAttributes().get(KEYFIELDS_ATTRIBUTE)
				.toString();
		String valueFields = lutRequest.getAttributes()
				.get(VALUEFIELDS_ATTRIBUTE).toString();

		StringBuilder builder = new StringBuilder();
		builder.append("Partner: ").append(partner).append("|");
		builder.append("Client: ").append(client).append("|");
		builder.append("LookUp Table: ").append(lookuptable).append("|");
		builder.append("Key Values: ").append(keyFields).append("|");
		builder.append("Fields Values: ").append(valueFields).append("|");
		
		return builder.toString();
	}

}
