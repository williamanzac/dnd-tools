package nz.co.fitnet.ui.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.data.Races;

@Path("/races")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RacesResource {
	@GET
	public List<Race> list() {
		return Races.raceList;
	}
}
