package com.framework.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.framework.model.User;

@Path("/user")
public class UserRestService {

	@POST
	@Path("{userId}")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public User getUser(@PathParam("userId") Integer userId) {
		return new User("jack","man",15);
	}
	
	
	
}
