package nz.co.fitnet.ui.resource;

import java.util.HashMap;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.fitnet.characterGenerator.api.Age;
import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.api.equipment.Money;
import nz.co.fitnet.characterGenerator.api.equipment.StartingWealth;
import nz.co.fitnet.characterGenerator.core.builders.AgeBuilder;
import nz.co.fitnet.characterGenerator.core.builders.HeightAndWeightBuilder;
import nz.co.fitnet.characterGenerator.core.builders.StartingWealthBuilder;
import nz.co.fitnet.nameGenerator.api.Gender;
import nz.co.fitnet.nameGenerator.api.Type;
import nz.co.fitnet.nameGenerator.core.NameGenerator;
import nz.co.fitnet.numberGenerator.core.NumberGenerator;
import nz.co.fitnet.ui.core.RandomComparator;

@Path("/builder")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BuilderResource {

	private final NumberGenerator numberService;
	private final NameGenerator nameService;

	@Inject
	public BuilderResource(final NumberGenerator numberService, final NameGenerator nameService) {
		this.numberService = numberService;
		this.nameService = nameService;
	}

	@POST
	@Path("/age")
	public Integer generateAge(final Age age) {
		final AgeBuilder builder = new AgeBuilder(numberService);
		return builder.withAge(age).build();
	}

	@POST
	@Path("/height")
	public Integer generateHeight(final Measurement height) {
		final HeightAndWeightBuilder builder = new HeightAndWeightBuilder(numberService);
		return builder.withHeight(height).buildHeight();
	}

	@POST
	@Path("/weight")
	public Integer generateWeight(final Measurement weight) {
		final HeightAndWeightBuilder builder = new HeightAndWeightBuilder(numberService);
		return builder.withWeight(weight).buildWeight();
	}

	@POST
	@Path("/name/{race}")
	public String generateName(final @PathParam("race") String race) {
		final RandomComparator<Gender> randomGenderCompator = new RandomComparator<>(numberService);
		final Gender gender = Stream.of(Gender.values()).sorted(randomGenderCompator).limit(1).findFirst().get();
		return generateName(race, gender);
	}

	@POST
	@Path("/name/{race}/{gender}")
	public String generateName(final @PathParam("race") String race, final @PathParam("gender") Gender gender) {
		final HashMap<String, String> parameters = new HashMap<>();
		parameters.put("gender", gender.name());
		final String name = nameService.generateName(Type.Any, race, parameters);
		return name;
	}

	@POST
	@Path("/startingWealth")
	public Money generateStartingWealth(final StartingWealth startingWealth) {
		final StartingWealthBuilder builder = new StartingWealthBuilder(numberService);
		return builder.withStartingWealth(startingWealth).build();
	}
}
