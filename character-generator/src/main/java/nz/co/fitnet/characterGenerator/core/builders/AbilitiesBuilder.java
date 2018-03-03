package nz.co.fitnet.characterGenerator.core.builders;

import static java.util.stream.Collectors.toList;
import static nz.co.fitnet.characterGenerator.api.Ability.values;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.numberGenerator.api.NumberService;

public class AbilitiesBuilder {

	private static final RandomCompator<Object> RANDOM_COMPATOR = new RandomCompator<>();
	private final Map<Ability, Integer> abilityScores = new HashMap<>();
	private Ability primaryAbility;
	private Ability secondaryAbility;

	@Inject
	private NumberService numberService;

	public AbilitiesBuilder withAbilityScores(final Map<Ability, Integer> abilityScores) {
		this.abilityScores.putAll(abilityScores);
		return this;
	}

	public AbilitiesBuilder withAbilityScore(final Ability ability, final Integer score) {
		abilityScores.put(ability, score);
		return this;
	}

	public AbilitiesBuilder withPrimaryAbility(final Ability ability) {
		primaryAbility = ability;
		return this;
	}

	public AbilitiesBuilder withSecondaryAbility(final Ability ability) {
		secondaryAbility = ability;
		return this;
	}

	public Map<Ability, Integer> build() {
		final List<Ability> abilityList = Stream.of(values()).filter(a -> !abilityScores.containsKey(a))
				.sorted((o1, o2) -> {
					if (o1.equals(o2)) {
						return 0;
					}
					if (o1 == primaryAbility && o2 != primaryAbility) {
						return -1;
					}
					if (o2 == primaryAbility && o1 != primaryAbility) {
						return 1;
					}
					if (o1 == secondaryAbility && o2 != secondaryAbility) {
						return -1;
					}
					if (o2 == secondaryAbility && o1 != secondaryAbility) {
						return 1;
					}
					return RANDOM_COMPATOR.compare(o1, o2);
				}).collect(Collectors.toList());
		final List<Integer> statList = abilityList.stream().map((ability) -> generateScore()).sorted((a, b) -> b - a)
				.collect(toList());
		final Map<Ability, Integer> map = new HashMap<>();
		for (int i = 0; i < abilityList.size(); i++) {
			map.put(abilityList.get(i), statList.get(i));
		}

		return map;
	}

	private int generateScore() {
		final List<Integer> dice = numberService.rollDice(6, 4); // 4d6
		return dice.stream().sorted().skip(1).reduce((t, n) -> t + n).get().intValue();
	}

	void setNumberService(final NumberService numberService) {
		this.numberService = numberService;
		RANDOM_COMPATOR.setNumberService(numberService);
	}
}
