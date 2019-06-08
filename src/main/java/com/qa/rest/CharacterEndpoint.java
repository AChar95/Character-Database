package com.qa.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.qa.characterRepo.CharacterRepository;
import com.qa.profiles.CharacterProfile;

@Path("/")
public class CharacterEndpoint {
	
	@Inject
	private CharacterRepository charRepo;
	
	@GET
	@Path("/characters")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<CharacterProfile> charList = charRepo.readAll();
		if (charList.size() == 0) {
			return Response.noContent().build();
		}
		return Response.ok(charList).build();
	}
	@GET
	@Path("/characters/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneChar(@PathParam("id") int id) {
		CharacterProfile charId = charRepo.readChar(id);
		return Response.ok(charId).build();
	}
	@GET
	@Path("/characters/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCharByName(@PathParam("name") String fName) {
		List<CharacterProfile> charNameList = charRepo.readName(fName);
		if (charNameList.size() == 0) {
			return Response.noContent().build();
		}
		return Response.ok(charNameList).build();
	}

}
