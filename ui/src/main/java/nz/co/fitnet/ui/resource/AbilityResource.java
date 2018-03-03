package nz.co.fitnet.ui.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.numberGenerator.core.NumberGenerator;

@Path("/abilities")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AbilityResource {

	private final NumberGenerator numberService;

	@Inject
	public AbilityResource(final NumberGenerator numberService) {
		this.numberService = numberService;
	}

	@GET
	public List<Ability> list() {
		return Arrays.asList(Ability.values());
	}

	@POST
	@Path("/generateScore")
	public int generateScore() {
		final List<Integer> dice = numberService.rollDice(6, 4);
		return dice.stream().sorted().skip(1).reduce((t, n) -> t + n).get().intValue();
	}

	@POST
	@Path("/generateScores")
	public List<Integer> generateScores() {
		final List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			numbers.add(generateScore());
		}
		return numbers;
	}
}
