package nz.co.fitnet.characterGenerator.core.builders;

import static java.util.Arrays.asList;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import nz.co.fitnet.numberGenerator.api.NumberService;
import nz.co.fitnet.numberGenerator.core.NumberGenerator;

public class RandomComparatorTest {
	private NumberService numberService;
	private RandomCompator<Integer> randomCompator;

	@Before
	public void setup() {
		numberService = new NumberGenerator();

		randomCompator = new RandomCompator<>();
		randomCompator.setNumberService(numberService);
	}

	@Test
	public void verifyRandomOrder() {
		final List<Integer> list = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		list.sort(randomCompator);
		System.out.println(list);
	}
}
