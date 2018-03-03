package nz.co.fitnet.ui.resource;

import static javax.ws.rs.core.Response.seeOther;
import static javax.ws.rs.core.UriBuilder.fromMethod;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nz.co.fitnet.ui.core.CharacterBuilder;
import nz.co.fitnet.ui.core.CharacterBuilderModel;
import nz.co.fitnet.ui.core.MyCharacters;
import nz.co.fitnet.wizard.InvalidStateException;
import nz.co.fitnet.wizard.WizardStep;

@Path("/ui/characters/{uuid}/builder")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_HTML)
public class UICharacterBuilderResource {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GET
	@Path("/active")
	public CharacterStepView<WizardStep<CharacterBuilderModel>> stepView(final @PathParam("uuid") UUID uuid) {
		final CharacterBuilderModel model = getModel(uuid);
		return new CharacterStepView(model.getActiveStep(), model);
	}

	private CharacterBuilderModel getModel(final UUID uuid) {
		return getBuilder(uuid).getModel();
	}

	@POST
	@Path("/next")
	public Response nextStep(final @PathParam("uuid") UUID uuid) throws InvalidStateException {
		getBuilder(uuid).nextStep();
		return seeOther(fromMethod(getClass(), "stepView").build(uuid)).build();
	}

	@POST
	@Path("/prev")
	public Response prevStep(final @PathParam("uuid") UUID uuid) throws InvalidStateException {
		getBuilder(uuid).previousStep();
		return seeOther(fromMethod(getClass(), "stepView").build(uuid)).build();
	}

	private CharacterBuilder getBuilder(final UUID uuid) {
		return MyCharacters.readBuilder(uuid);
	}
}
