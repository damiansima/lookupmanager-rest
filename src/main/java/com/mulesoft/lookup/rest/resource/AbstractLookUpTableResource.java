package com.mulesoft.lookup.rest.resource;

import org.restlet.Request;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

/**
 * This is the base class for all the {@link ServerResource} in the REST api.
 * 
 * @author damiansima
 * 
 */
public abstract class AbstractLookUpTableResource extends ServerResource {
	private static final String PARTNER_ATTRIBUTE = "partner";
	private static final String CLIENT_ATTRIBUTE = "client";
	private static final String LOOKUPTABLE_ATTRIBUTE = "lookuptable";

	protected String partner = "";
	protected String client = "";
	protected String lookuptable = "";
	
	protected Request lutRequest = null;

	@Override
	protected void doInit() throws ResourceException {

		this.lutRequest = this.getRequest();

		if (lutRequest.getAttributes().get(PARTNER_ATTRIBUTE) != null) {
			partner = lutRequest.getAttributes().get(PARTNER_ATTRIBUTE).toString();
		}

		if (lutRequest.getAttributes().get(CLIENT_ATTRIBUTE) != null) {
			client = lutRequest.getAttributes().get(CLIENT_ATTRIBUTE).toString();
		}

		if (lutRequest.getAttributes().get(LOOKUPTABLE_ATTRIBUTE) != null) {
			lookuptable = lutRequest.getAttributes().get(LOOKUPTABLE_ATTRIBUTE)
					.toString();
		}
	}

}
