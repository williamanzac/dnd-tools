package nz.co.fitnet.numberGenerator.core;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NumberGeneratorTest {
	@Test
	public void verifyGaussianNumber() {
		final List<Double> actual = new ArrayList<>();
		final NumberGenerator cut = new NumberGenerator();
		for (int i = 0; i < 100; i++) {
			actual.add(cut.gaussianNumber());
		}
		System.out.println(actual);
	}
}
