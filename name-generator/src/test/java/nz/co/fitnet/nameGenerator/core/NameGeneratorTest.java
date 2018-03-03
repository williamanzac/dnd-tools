package nz.co.fitnet.nameGenerator.core;

import static nz.co.fitnet.nameGenerator.api.Gender.Female;
import static nz.co.fitnet.nameGenerator.api.Gender.Male;
import static nz.co.fitnet.nameGenerator.api.Type.Markov;
import static nz.co.fitnet.nameGenerator.api.Type.Random;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import nz.co.fitnet.numberGenerator.core.NumberGenerator;

public class NameGeneratorTest {
	private NameGenerator generator;
	private NumberGenerator numberService;

	@Before
	public void setup() {
		numberService = new NumberGenerator();

		generator = new NameGenerator(numberService);
	}

	@Test
	public void verifyGeneratedMarkovName() {
		final HashMap<String, String> parameters = new HashMap<>();
		parameters.put("gender", Male.name());
		final String actual = generator.generateName(Markov, "Dwarf", parameters);
		System.out.println(actual);
		final String[] split = actual.split("\\s");
		assertThat(split.length, equalTo(2));
	}

	@Test
	public void verifyGeneratedRandomName() {
		final HashMap<String, String> parameters = new HashMap<>();
		parameters.put("gender", Male.name());
		final String actual = generator.generateName(Random, "Dwarf", parameters);
		System.out.println(actual);
		final String[] split = actual.split("\\s");
		assertThat(split.length, equalTo(2));
	}

	@Test
	public void verifyGeneratedMarkovNameWithOverride() {
		final HashMap<String, String> parameters = new HashMap<>();
		parameters.put("gender", Female.name());
		final String actual = generator.generateName(Markov, "Elf", parameters);
		System.out.println(actual);
		final String[] split = actual.split("\\s");
		assertThat(split.length, equalTo(3));
	}
}
