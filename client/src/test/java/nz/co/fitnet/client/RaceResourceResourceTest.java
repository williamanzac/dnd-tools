package nz.co.fitnet.client;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.data.Races;

public class RaceResourceResourceTest {

	@Test
	public void verifyHillDwarf() {
		final Race race = Races.HILL_DWARF;
		final RaceResourceBundle bundle = RaceResourceBundle.getBundle(race);
		bundle.getKeys();
		final String actual = bundle.getString("Race");
		assertThat(actual, equalTo("HillDwarf"));
	}
}
