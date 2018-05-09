package nz.co.fitnet.characterGenerator.core;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.data.Races;

public class DiceFormatTest {

	@Test
	public void verifyHalflingWieghtModifier() {
		final Race race = Races.LIGHTFOOT;
		final Measurement weight = race.getWeight();
		final DiceFormat diceFormat = DiceFormat.parse(weight.getModifier());
		Assert.assertThat(diceFormat.getTimes(), Matchers.equalTo(0));
		Assert.assertThat(diceFormat.getDie(), Matchers.equalTo(0));
		Assert.assertThat(diceFormat.getModifier(), Matchers.equalTo(1));
	}

	@Test
	public void verifyHalfElfWieghtModifier() {
		final Race race = Races.HALF_ELF;
		final Measurement weight = race.getWeight();
		final DiceFormat diceFormat = DiceFormat.parse(weight.getModifier());
		Assert.assertThat(diceFormat.getTimes(), Matchers.equalTo(2));
		Assert.assertThat(diceFormat.getDie(), Matchers.equalTo(4));
		Assert.assertThat(diceFormat.getModifier(), Matchers.equalTo(0));
	}
}
