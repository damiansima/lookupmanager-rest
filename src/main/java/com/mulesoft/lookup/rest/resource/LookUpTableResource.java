package com.mulesoft.lookup.rest.resource;

import org.restlet.Request;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class LookUpTableResource extends ServerResource {
	private static final String TABLENAME_ATTRIBUTE = "lookuptables";

	private static final String KEYS_ATTRIBUTE = "keys";
	private static final String FIELDS_ATTRIBUTE = "fields";

	protected String tableName = "";
	private String keys;
	private String fields;

	protected Request lutRequest = null;

	@Override
	protected void doInit() throws ResourceException {

		this.lutRequest = this.getRequest();

		if (lutRequest.getAttributes().get(TABLENAME_ATTRIBUTE) != null) {
			this.tableName = lutRequest.getAttributes().get(TABLENAME_ATTRIBUTE)
					.toString();
		}

		this.keys = this.getQuery().getValues(KEYS_ATTRIBUTE);
		this.fields = this.getQuery().getValues(FIELDS_ATTRIBUTE);

	}

	// POST /lookuptables/table_name?keys=value1,valueN&fields=value1,valueN
	@Post
	public String createData() {
		StringBuilder builder = new StringBuilder();

		if (this.keys == null || this.fields == null) {
			builder.append("400: bad request.");
			return builder.toString();
		}

		builder.append("200 - ");
		builder.append("CREATING... LookUpTable: ").append(this.tableName);
		builder.append("|keys: ").append(this.keys);
		builder.append("|fields: ").append(this.fields);

		return builder.toString();
	}

	// GET /lookuptables/table_name
	// GET /lookuptables/table_name?keys=value1,valueN
	@Get
	public String listData() {
		StringBuilder builder = new StringBuilder();

		if (this.keys == null) {
			builder.append("200 - ");
			builder.append("LISTING... LookUpTable: ").append(this.tableName);
		} else {
			builder.append("200 - ");
			builder.append("LISTING... LookUpTable: ").append(this.tableName);
			builder.append("|keys: ").append(this.keys);
		}

		return builder.toString();
	}

	// PUT /lookuptables/table_name?keys=value1,valueN&fields=value1,valueN
	@Put
	public String updateData() {
		StringBuilder builder = new StringBuilder();

		if (this.keys == null || this.fields == null) {
			builder.append("400: bad request.");
			return builder.toString();
		}
		builder.append("200 - ");
		builder.append("UPDATING... LookUpTable: ").append(this.tableName);
		builder.append("|keys: ").append(this.keys);

		return builder.toString();
	}

	// DELETE /lookuptables/table_name
	// DELETE /lookuptables/table_name?keys=value1,valueN
	@Delete
	public String deleteData() {
		StringBuilder builder = new StringBuilder();

		if (this.keys == null) {
			builder.append("200 - ");
			builder.append("DELETING... LookUpTable: ").append(this.tableName);
		} else {
			builder.append("200 - ");
			builder.append("DELETING... LookUpTable: ").append(this.tableName);
			builder.append("|keys: ").append(this.keys);
		}

		return builder.toString();

	}
}