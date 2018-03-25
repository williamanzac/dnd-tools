package nz.co.fitnet.characterGenerator.core.builders;

import javax.inject.Inject;

import nz.co.fitnet.characterGenerator.api.Background;
import nz.co.fitnet.numberGenerator.api.NumberService;

public class BackgroundBuilder {
	private final RandomComparator<String> comparator;
	private Background background;

	@Inject
	public BackgroundBuilder(final NumberService numberService) {
		comparator = new RandomComparator<>(numberService);
	}

	public BackgroundBuilder withBackground(final Background background) {
		this.background = background;
		return this;
	}

	public String buildPersonalityTrait() {
		final String string = background.getPersonalityTraits().stream().sorted(comparator).findFirst().get();
		return string;
	}

	public String buildIdeal() {
		final String string = background.getIdeals().stream().sorted(comparator).findFirst().get();
		return string;
	}

	public String buildBond() {
		final String string = background.getBonds().stream().sorted(comparator).findFirst().get();
		return string;
	}

	public String buildFlaw() {
		final String string = background.getFlaws().stream().sorted(comparator).findFirst().get();
		return string;
	}
}
