package nz.co.fitnet.characterGenerator.api;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Test;

public class LevelTest {
	@Test
	public void verifyLevelMap() {
		final Map<Integer, Level> actual = Level.levelMap;
		assertThat(actual.size(), equalTo(20));
		assertThat(actual.get(1).getLevel(), equalTo(1));
		assertThat(actual.get(1).getProficiencyBonus(), equalTo(2));
		assertThat(actual.get(5).getLevel(), equalTo(5));
		assertThat(actual.get(5).getProficiencyBonus(), equalTo(3));
	}
}
