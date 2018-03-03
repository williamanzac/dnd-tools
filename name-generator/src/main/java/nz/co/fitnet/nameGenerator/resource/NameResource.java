package nz.co.fitnet.nameGenerator.resource;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.fitnet.nameGenerator.api.NameService;
import nz.co.fitnet.nameGenerator.api.Type;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/generate")
public class NameResource implements NameService {

	private final NameService nameService;

	@Inject
	public NameResource(final NameService nameService) {
		this.nameService = nameService;
	}

	@POST
	@Path("/{type}/{name}")
	@Override
	public String generateName(final @PathParam("type") Type type, final @PathParam("name") String name,
			final Map<String, String> parameters) {
		return nameService.generateName(type, name, parameters);
	}

	@POST
	@Path("/{type}/{name}/{numOf}")
	@Override
	public List<String> nameList(final @PathParam("type") Type type, final @PathParam("name") String name,
			final Map<String, String> parameters, final @PathParam("numOf") int numOf) {
		return nameService.nameList(type, name, parameters, numOf);
	}
}
