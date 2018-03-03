package nz.co.fitnet.characterGenerator.core.builders;

import javax.inject.Inject;

import org.jvnet.hk2.annotations.Service;

import nz.co.fitnet.characterGenerator.api.Age;
import nz.co.fitnet.numberGenerator.api.NumberService;

@Service
public class AgeBuilder {
	private Age age;

	private final NumberService numberService;

	@Inject
	public AgeBuilder(final NumberService numberService) {
		this.numberService = numberService;
	}

	public AgeBuilder withAge(final Age age) {
		this.age = age;
		return this;
	}

	public int build() {
		return (int) numberService.numberBetween(age.getMaturity(), age.getMax());
	}
}
