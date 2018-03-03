package nz.co.fitnet.ui.core;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import org.jvnet.hk2.annotations.Service;

import nz.co.fitnet.numberGenerator.api.NumberService;

@Service
public class NumberGenerator implements NumberService {
	private static final GenericType<List<Integer>> RESPONSE_TYPE = new GenericType<List<Integer>>() {
	};

	private final WebTarget baseWebTarget;

	@Inject
	public NumberGenerator(final Client client) {
		super();
		baseWebTarget = client.target("http://localhost:8082/");
	}

	@Override
	public int rollDie(final int sides) {
		final WebTarget webTarget = baseWebTarget.path("rollDie").path(String.valueOf(sides));
		final Invocation.Builder invocationBuilder = webTarget.request(APPLICATION_JSON);
		final Integer response = invocationBuilder.post(null, Integer.class);
		return response;
	}

	@Override
	public double rollGaussianNumber(final double max) {
		final WebTarget webTarget = baseWebTarget.path("rollGaussianNumber").path(String.valueOf(max));
		final Invocation.Builder invocationBuilder = webTarget.request(APPLICATION_JSON);
		final Double response = invocationBuilder.post(null, Double.class);
		return response;
	}

	@Override
	public List<Integer> rollDice(final int sides, final int times) {
		final WebTarget webTarget = baseWebTarget.path("rollDice").path(String.valueOf(sides))
				.path(String.valueOf(times));
		final Invocation.Builder invocationBuilder = webTarget.request(APPLICATION_JSON);
		final List<Integer> response = invocationBuilder.post(null, RESPONSE_TYPE);
		return response;
	}

	@Override
	public double numberBetween(final int min, final int max) {
		final WebTarget webTarget = baseWebTarget.path("numberBetween").path(String.valueOf(min))
				.path(String.valueOf(max));
		final Invocation.Builder invocationBuilder = webTarget.request(APPLICATION_JSON);
		final Double response = invocationBuilder.post(null, Double.class);
		return response;
	}

	@Override
	public double gaussianNumberBetween(final double min, final double max) {
		final WebTarget webTarget = baseWebTarget.path("gaussianNumberBetween").path(String.valueOf(min))
				.path(String.valueOf(max));
		final Invocation.Builder invocationBuilder = webTarget.request(APPLICATION_JSON);
		final Double response = invocationBuilder.post(null, Double.class);
		return response;
	}

	@Override
	public double gaussianNumber() {
		final WebTarget webTarget = baseWebTarget.path("gaussianNumber");
		final Invocation.Builder invocationBuilder = webTarget.request(APPLICATION_JSON);
		final Double response = invocationBuilder.post(null, Double.class);
		return response;
	}
}
