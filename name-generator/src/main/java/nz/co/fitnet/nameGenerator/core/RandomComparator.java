package nz.co.fitnet.nameGenerator.core;

import java.util.Comparator;

import javax.inject.Inject;

import nz.co.fitnet.numberGenerator.api.NumberService;

public class RandomComparator<T> implements Comparator<T> {
	private final NumberService numberService;

	@Inject
	public RandomComparator(final NumberService numberService) {
		this.numberService = numberService;
	}

	@Override
	public int compare(final T o1, final T o2) {
		if (o1.equals(o2)) {
			return 0;
		}
		final double gaussianNumber = numberService.gaussianNumber(); // number between -1 and 1
		if (gaussianNumber > 0) {
			return 1;
		} else if (gaussianNumber < 0) {
			return -1;
		}
		return 0;
	}
}
