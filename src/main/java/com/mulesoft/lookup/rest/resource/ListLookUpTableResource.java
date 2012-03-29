package com.mulesoft.lookup.rest.resource;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;

public class ListLookUpTableResource extends AbstractLookUpTableResource {
	private static final String KEY_ATTRIBUTE = "key";
	
	@Get
	public String getData() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Partner: ").append(partner).append("|");
		builder.append("Client: ").append(client).append("|");
		builder.append("LookUp Table: ").append(lookuptable).append("|");

		String key = "";
		if (lutRequest.getAttributes().get(KEY_ATTRIBUTE) != null) {
			key = lutRequest.getAttributes().get(KEY_ATTRIBUTE).toString();
			builder.append("Key: ").append(key).append("|");
		}
		
		
		
		return builder.toString();

		// String a = form.getQueryString();
		//
		// String data = "";
		// for (Parameter parameter : form) {
		// data +="|"+"parameter " + parameter.getName();
		// data +="/" + parameter.getValue();
		//
		// System.out.print("parameter " + parameter.getName());
		// System.out.println("/" + parameter.getValue());
		// }
		//
		// return "Hello World!"+a;
	}


	/**
	 * It's the REST operation to delete information from a Lookup Table
	 * 
	 * @return
	 */
	@Delete
	public String deleteData() {
		return "OMG... the data was delete";
	}

	// @Post
}