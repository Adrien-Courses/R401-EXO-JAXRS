package fr.adriencaubel.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/hello")
public class HelloWorldController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello() {
		return """
				{
					"message": "Hello from JAX-RS!"
				}
				""";
	}
}
