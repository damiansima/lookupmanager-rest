package com.mulesoft.lookup.rest.resource;

import org.restlet.resource.Delete;

public class DeleteLookUpTableResource extends AbstractLookUpTableResource {
	private static final String KEY_ATTRIBUTE = "key";

	/**
	 * It's the REST operation to delete information for a Lookup Table
	 * 
	 * @return
	 */
	@Delete
	public String deleteData() {

		String key = lutRequest.getAttributes().get(KEY_ATTRIBUTE)
				.toString();

		StringBuilder builder = new StringBuilder();
		builder.append("Partner: ").append(partner).append("|");
		builder.append("Client: ").append(client).append("|");
		builder.append("LookUp Table: ").append(lookuptable).append("|");
		builder.append("Key: ").append(key).append("|");
		
		return builder.toString();
	}

}
