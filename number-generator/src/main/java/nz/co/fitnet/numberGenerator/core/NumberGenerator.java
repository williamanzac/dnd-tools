package nz.co.fitnet.numberGenerator.core;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.floor;
import static java.lang.Math.log;
import static java.lang.Math.random;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;

import java.util.ArrayList;
import java.util.List;

import org.jvnet.hk2.annotations.Service;

import nz.co.fitnet.numberGenerator.api.NumberService;

@Service
public class NumberGenerator implements NumberService {
	@Override
	public int rollDie(final int sides) {
		return (int) numberBetween(1, sides);
	}

	@Override
	public double rollGaussianNumber(final double max) {
		return gaussianNumberBetween(1, max);
	}

	@Override
	public List<Integer> rollDice(final int sides, final int times) {
		final List<Integer> retVal = new ArrayList<>();
		for (int n = 0; n < times; n++) {
			retVal.add(rollDie(sides));
		}
		return retVal;
	}

	@Override
	public double numberBetween(final int min, final int max) {
		return numBetween(random(), min, max);
	}

	@Override
	public double gaussianNumberBetween(final double min, final double max) {
		final double half = (max - min) / 2;
		return round(min + half + half * gaussianNumber());
	}

	@Override
	public double gaussianNumber() {
		while (true) {
			final double r = sqrt(-2 * log(random()));
			final double t = 2 * PI * random();
			final double x = r * cos(t) / 2.8;
			if (x > -1 && x < 1) {
				return x;
			}
		}
	}

	private double numBetween(final double source, final int min, final int max) {
		return floor(source * (max - min + 1)) + min;
	}
}
