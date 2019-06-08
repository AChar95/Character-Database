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

import com.qa.characterRepo.ProfileRepository;
import com.qa.profiles.CharacterProfile;

@Path("/")
public class CharacterEndpoint {

	@Inject
	private ProfileRepository profRepo;

	@GET
	@Path("/characters")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<CharacterProfile> charList = profRepo.readAll();
		if (charList.size() == 0) {
			return Response.noContent().build();
		}
		return Response.ok(charList).build();
	}

	@GET
	@Path("/characters/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneChar(@PathParam("id") int id) {
		CharacterProfile charId = profRepo.readChar(id);
		if (profRepo.readChar(id).equals(null)) {
			return Response.noContent().build();
		}
		return Response.ok(charId).build();
	}

	@GET
	@Path("/characters/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCharByName(@PathParam("name") String fName) {
		List<CharacterProfile> charNameList = profRepo.readName(fName);
		if (charNameList.size() == 0) {
			return Response.noContent().build();
		}
		return Response.ok(charNameList).build();
	}

	@POST
	@Consumes({ "application/json" })
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/characters")
	public Response createCharacter(CharacterProfile character, @Context UriInfo uriInfo) {
		character = profRepo.createChar(character);
		URI createdURI = uriInfo.getBaseUriBuilder().path("" + character.getId()).build();
		return Response.ok(createdURI.toString()).status(Status.CREATED).build();
	}
	@PUT
	@Consumes({"application/json"})
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/characters/{id}")
	public Response updateCharacter(CharacterProfile character, @PathParam("id") int id) {
		if (profRepo.readChar(id).equals(null)){
			return Response.status(Status.NOT_FOUND).build();
		}
		CharacterProfile characterUpdate = profRepo.update(id, character);
		return Response.ok(characterUpdate).build();
	}

	@DELETE
	@Path("/characters/{id}")
	public Response deleteCharacter(@PathParam("id") int id) {
		if (profRepo.readChar(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		profRepo.deleteChar(id);
		return Response.noContent().build();
	}
}
