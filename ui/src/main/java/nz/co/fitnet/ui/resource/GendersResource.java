package nz.co.fitnet.ui.resource;

import static java.util.Arrays.asList;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.fitnet.characterGenerator.api.Gender;

@Path("/genders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GendersResource {
	@GET
	public List<Gender> list() {
		return asList(Gender.values());
	}
}
