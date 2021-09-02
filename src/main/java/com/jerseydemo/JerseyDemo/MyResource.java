
package com.jerseydemo.JerseyDemo;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path(JerseyConstants.url)
public class MyResource {

	/**
	 * Method processing HTTP GET requests, producing "text/plain" MIME media type.
	 *     
	 * @return String that will be send back as a response of type "text/plain".
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Hi there! i'm get";
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String postIt(UserDetails us) {
		return "Record created First name " + us.getFirstName() + " , last name " + us.getFirstName();
	}
	
	
	@PUT
	public String putItxyz(UserDetails us) {
		return "Record edited "+us.getFirstName();
	}
	@DELETE
	public String abc(UserDetails us) {
		return "Record Delete" + us.getFirstName();
	}
	
}
