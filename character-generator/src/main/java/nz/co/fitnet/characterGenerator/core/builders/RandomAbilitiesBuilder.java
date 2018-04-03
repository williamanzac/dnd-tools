package nz.co.fitnet.characterGenerator.core.builders;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.inject.Inject;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.numberGenerator.api.NumberService;

public class RandomAbilitiesBuilder extends AbstractAbilitiesBuilder implements AbilitiesBuilder {

	@Inject
	public RandomAbilitiesBuilder(final NumberService numberService) {
		super(numberService);
	}

	@Override
	protected List<Integer> statList(final List<Ability> abilityList) {
		return abilityList.stream().map((ability) -> generateScore()).sorted((a, b) -> b - a).collect(toList());
	}

	private int generateScore() {
		final List<Integer> dice = numberService.rollDice(6, 4); // 4d6
		return dice.stream().sorted().skip(1).reduce((t, n) -> t + n).get().intValue();
	}
}
