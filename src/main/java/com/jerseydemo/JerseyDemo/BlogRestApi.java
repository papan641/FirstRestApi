package com.jerseydemo.JerseyDemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/blog")
public class BlogRestApi {
	@GET
	public String getBlock() {
		return "yes";
	}

}
