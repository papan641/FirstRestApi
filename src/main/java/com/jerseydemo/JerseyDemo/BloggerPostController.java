package com.jerseydemo.JerseyDemo;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/post")
public class BloggerPostController {

	BloggerPostService service = new BloggerPostService();

	@GET()
	@Path("/{postId}")
	@Produces(MediaType.APPLICATION_JSON)
	public PostDetails get(@PathParam("postId") int postId) {
		return service.getPost(postId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PostDetails add(PostDetails user) {
		return service.addPost(user);
	}

	@PUT
	@Path("/{postId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PostDetails edit(PostDetails user, @PathParam("postId") int postId) {
		return service.editPost(user, postId);
	}
}
