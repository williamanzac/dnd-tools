package nz.co.fitnet.ui.resource;

import static javax.ws.rs.core.Response.seeOther;
import static javax.ws.rs.core.UriBuilder.fromResource;

import java.util.Set;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nz.co.fitnet.characterGenerator.api.Character;
import nz.co.fitnet.ui.core.MyCharacters;

@Path("characters")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CharactersResource {

	@GET
	public Set<UUID> all() {
		return MyCharacters.all().keySet();
	}

	@POST
	public UUID create(final Character character) {
		return MyCharacters.create(character);
	}

	@PUT
	@Path("{uuid}")
	public void update(final @PathParam("uuid") UUID uuid, final Character character) {
		MyCharacters.update(uuid, character);
	}

	@GET
	@Path("{uuid}")
	public Character read(final @PathParam("uuid") UUID uuid) {
		return MyCharacters.read(uuid);
	}

	@DELETE
	@Path("{uuid}")
	public void delete(final @PathParam("uuid") UUID uuid) {
		MyCharacters.delete(uuid);
	}

	@POST
	@Path("/new")
	public Response createBulder() {
		final UUID uuid = MyCharacters.createNewBuilder();
		return seeOther(fromResource(UICharacterBuilderResource.class).build(uuid)).build();
	}
}
