package nz.co.fitnet.ui.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.fitnet.characterGenerator.api.Background;
import nz.co.fitnet.characterGenerator.data.Backgrounds;

@Path("/backgrounds")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BackgroundsResource {
	@GET
	public List<Background> list() {
		return Backgrounds.backgroundList;
	}
}
