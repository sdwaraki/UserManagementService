package com.user.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.user.model.User;
import com.user.service.UserService;
import com.user.service.UserServiceImpl;

@Path("/userdetails")
public class UserController {

	@POST
	@Path("/adduser")
	@Consumes("application/x-www-form-urlencoded")
	public Response addUser(@FormParam("id") String id, @FormParam("name") String name,
			@FormParam("date") String date) {
		UserService userService = new UserServiceImpl();
		userService.createUser(id, name, new Date(System.currentTimeMillis()));
		return Response.ok(MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Path("/adduser/{id}/{name}/{date}")
	public Response addUserPost(@PathParam("id") String id, @PathParam("name") String name,
			@PathParam("date") String date) {
		UserService userService = new UserServiceImpl();
		userService.createUser(id, name, new Date(Long.parseLong(date)));
		return Response.ok(MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/userinfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserDetails() {
		UserService userService = new UserServiceImpl();
		return Response.ok(MediaType.APPLICATION_JSON).entity(userService.listUsers()).build();
	}
	
	@DELETE
	@Path("/deleteuser/{id}")
	public Response deleteUser(@PathParam("id") String id) {
		UserService userService = new UserServiceImpl();
		userService.deleteUser(id);
		return Response.ok(MediaType.APPLICATION_JSON).build();
	}
}
