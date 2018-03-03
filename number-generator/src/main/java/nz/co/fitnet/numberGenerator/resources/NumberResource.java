package nz.co.fitnet.numberGenerator.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.co.fitnet.numberGenerator.api.NumberService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/generate")
public class NumberResource implements NumberService {

	private final NumberService numberService;

	@Inject
	public NumberResource(final NumberService numberService) {
		this.numberService = numberService;
	}

	@Override
	@POST
	@Path("/rollDie/{sides}")
	public int rollDie(final @PathParam("sides") int sides) {
		return numberService.rollDie(sides);
	}

	@Override
	@POST
	@Path("/rollGaussianNumber/{max}")
	public double rollGaussianNumber(final @PathParam("max") double max) {
		return numberService.rollGaussianNumber(max);
	}

	@Override
	@POST
	@Path("/rollDice/{sides}/{times}")
	public List<Integer> rollDice(final @PathParam("sides") int sides, final @PathParam("times") int times) {
		return numberService.rollDice(sides, times);
	}

	@Override
	@POST
	@Path("/numberBetween/{min}/{max}")
	public double numberBetween(final @PathParam("min") int min, final @PathParam("max") int max) {
		return numberService.numberBetween(min, max);
	}

	@Override
	@POST
	@Path("/gaussianNumberBetween/{min}/{max}")
	public double gaussianNumberBetween(final @PathParam("min") double min, final @PathParam("max") double max) {
		return numberService.gaussianNumberBetween(min, max);
	}

	@Override
	@POST
	@Path("/gaussianNumber")
	public double gaussianNumber() {
		return numberService.gaussianNumber();
	}
}
