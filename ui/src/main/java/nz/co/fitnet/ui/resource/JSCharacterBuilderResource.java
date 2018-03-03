package nz.co.fitnet.ui.resource;

import java.io.InputStream;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.io.IOUtils;

import nz.co.fitnet.ui.core.CharacterBuilder;
import nz.co.fitnet.ui.core.CharacterBuilderModel;
import nz.co.fitnet.ui.core.MyCharacters;
import nz.co.fitnet.wizard.WizardStep;

@Path("/js/characters/{uuid}/builder")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public class JSCharacterBuilderResource {

	private Response getResource(final String path) {
		final InputStream in = getClass().getResourceAsStream(path);
		final StreamingOutput stream = output -> {
			try {
				IOUtils.copy(in, output);
			} catch (final Exception e) {
				throw new WebApplicationException(e);
			}
		};

		return Response.ok(stream).header("content-disposition", "attachment; filename = " + path).build();
	}

	@GET
	@Path("/main.js")
	public Response builderView(final @PathParam("uuid") UUID uuid) {
		return getResource("/character/builder/main.js");
	}

	@GET
	@Path("/overview.js")
	public Response overviewView(final @PathParam("uuid") UUID uuid) {
		return getResource("/character/builder/overview.js");
	}

	@GET
	@Path("/active.js")
	public Response stepView(final @PathParam("uuid") UUID uuid) {
		final WizardStep<CharacterBuilderModel> activeStep = getModel(uuid).getActiveStep();
		final String view = activeStep.getView();
		return getResource("/character/builder/steps/" + view + ".js");
	}

	private CharacterBuilderModel getModel(final UUID uuid) {
		return getBuilder(uuid).getModel();
	}

	private CharacterBuilder getBuilder(final UUID uuid) {
		return MyCharacters.readBuilder(uuid);
	}
}
