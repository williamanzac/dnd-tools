package nz.co.fitnet.characterGenerator.core.builders;

import nz.co.fitnet.characterGenerator.api.Background;
import nz.co.fitnet.numberGenerator.api.NumberService;

public class BackgroundBuilder {
	private static final RandomCompator<String> COMPARATOR = new RandomCompator<>();
	private Background background;

	public BackgroundBuilder withBackground(final Background background) {
		this.background = background;
		return this;
	}

	public String buildPersonalityTrait() {
		final String string = background.getPersonalityTraits().stream().sorted(COMPARATOR).findFirst().get();
		return string;
	}

	public String buildIdeal() {
		final String string = background.getIdeals().stream().sorted(COMPARATOR).findFirst().get();
		return string;
	}

	public String buildBond() {
		final String string = background.getBonds().stream().sorted(COMPARATOR).findFirst().get();
		return string;
	}

	public String buildFlaw() {
		final String string = background.getFlaws().stream().sorted(COMPARATOR).findFirst().get();
		return string;
	}

	void setNumberService(final NumberService numberService) {
		COMPARATOR.setNumberService(numberService);
	}
}
