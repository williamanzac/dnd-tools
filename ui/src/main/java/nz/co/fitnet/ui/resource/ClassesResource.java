package nz.co.fitnet.ui.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.fitnet.characterGenerator.api.CharacterClass;
import nz.co.fitnet.characterGenerator.data.Classes;

@Path("/classes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClassesResource {
	@GET
	public List<CharacterClass> list() {
		return Classes.classList;
	}
}
