package com.qa.rest;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.qa.characterRepo.ProfileUserRepository;
import com.qa.profiles.CharacterProfile;
import com.qa.profiles.Users;

@Path("/")
public class UserEndpoint {
	@Inject
	private ProfileUserRepository profileUser;

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {
		List<Users> userList = profileUser.readAllUsers();
		if (userList.size() == 0) {
			return Response.noContent().build();
		}
		return Response.ok(userList).build();
	}

	@GET
	@Path("/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneUser(@PathParam("id") int id) {
		Users userId = profileUser.readUser(id);
		if (profileUser.readUser(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(userId).build();
	}

	@POST
	@Consumes({ "application/json" })
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/users")
	public Response createUser(Users user, @Context UriInfo uriInfo) {
		user = profileUser.createUser(user);
		URI createdURI = uriInfo.getBaseUriBuilder().path("" + user.getId()).build();
		return Response.ok(createdURI.toString()).status(Status.CREATED).build();
	}
	@PUT
	@Consumes({"application/json"})
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/users/{id}")
	public Response updateUser(Users user, @PathParam("id") int id) {
		if (profileUser.readUser(id).equals(null)){
			return Response.status(Status.NOT_FOUND).build();
		}
		Users userUpdate = profileUser.update(id, user);
		return Response.ok(userUpdate).build();
	}

	@DELETE
	@Path("/users/{id}")
	public Response deleteUser(@PathParam("id") int id) {
		if (profileUser.readUser(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		profileUser.deleteUser(id);
		return Response.noContent().build();
	}
}
