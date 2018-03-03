package nz.co.fitnet.ui.resource;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.fitnet.characterGenerator.api.Language;

@Path("/languages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LanguagesResource {
	@GET
	public List<Language> list() {
		return Arrays.asList(Language.values());
	}
}
