package com.jerseydemo.JerseyDemo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/post")
public class BloggerPostController {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String get() {
		return "Get ok";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String add(UserDetails user) {
		BloggerPostService service = new BloggerPostService();
		service.add(user);
		return "Added";
	}
}
