package nz.co.fitnet.characterGenerator.core.builders;

import static nz.co.fitnet.characterGenerator.api.Ability.values;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.numberGenerator.api.NumberService;

public abstract class AbstractAbilitiesBuilder implements AbilitiesBuilder {

	protected final Map<Ability, Integer> abilityScores = new HashMap<>();
	protected final RandomComparator<Ability> comparator;
	protected final NumberService numberService;

	@Inject
	public AbstractAbilitiesBuilder(final NumberService numberService) {
		this.numberService = numberService;
		comparator = new RandomComparator<>(numberService);
	}

	@Override
	public AbilitiesBuilder withAbilityScores(final Map<Ability, Integer> abilityScores) {
		this.abilityScores.putAll(abilityScores);
		return this;
	}

	@Override
	public AbilitiesBuilder withAbilityScore(final Ability ability, final Integer score) {
		abilityScores.put(ability, score);
		return this;
	}

	protected List<Ability> abilityList() {
		return Stream.of(values()).filter(a -> !abilityScores.containsKey(a)).sorted(comparator)
				.collect(Collectors.toList());
	}

	protected abstract List<Integer> statList(final List<Ability> abilityList);

	@Override
	public Map<Ability, Integer> build() {
		final List<Ability> abilityList = abilityList();
		final List<Integer> statList = statList(abilityList);
		final Map<Ability, Integer> map = new HashMap<>();
		for (int i = 0; i < abilityList.size(); i++) {
			map.put(abilityList.get(i), statList.get(i));
		}

		return map;
	}
}