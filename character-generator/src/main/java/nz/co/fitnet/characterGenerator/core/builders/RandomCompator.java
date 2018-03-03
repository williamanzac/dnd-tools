package nz.co.fitnet.characterGenerator.core.builders;

import java.util.Comparator;

import javax.inject.Inject;

import nz.co.fitnet.numberGenerator.api.NumberService;

public class RandomCompator<T> implements Comparator<T> {
	@Inject
	private NumberService numberService;

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

	void setNumberService(final NumberService numberService) {
		this.numberService = numberService;
	}
}
