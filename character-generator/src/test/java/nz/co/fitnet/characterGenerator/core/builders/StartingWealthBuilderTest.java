package nz.co.fitnet.characterGenerator.core.builders;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import nz.co.fitnet.characterGenerator.api.equipment.Money;
import nz.co.fitnet.characterGenerator.api.equipment.StartingWealth;
import nz.co.fitnet.numberGenerator.core.NumberGenerator;

public class StartingWealthBuilderTest {
	private StartingWealthBuilder startingWealthBuilder;
	private NumberGenerator numberService;

	@Before
	public void setup() {
		numberService = new NumberGenerator();

		startingWealthBuilder = new StartingWealthBuilder(numberService);
	}

	@Test
	public void verifyWithTimes() {
		final Money actual = startingWealthBuilder.withStartingWealth(new StartingWealth(1, 6, 10)).build();
		assertThat(actual.getGold(), allOf(greaterThanOrEqualTo(10), lessThanOrEqualTo(60)));
	}

	@Test
	public void verifyWithoutTimes() {
		final Money actual = startingWealthBuilder.withStartingWealth(new StartingWealth(1, 10, "sp")).build();
		assertThat(actual.getSilver(), allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(10)));
	}
}
