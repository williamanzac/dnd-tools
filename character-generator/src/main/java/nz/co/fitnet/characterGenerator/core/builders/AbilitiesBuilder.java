package nz.co.fitnet.characterGenerator.core.builders;

import java.util.Map;

import nz.co.fitnet.characterGenerator.api.Ability;

public interface AbilitiesBuilder {

	AbilitiesBuilder withAbilityScores(Map<Ability, Integer> abilityScores);

	AbilitiesBuilder withAbilityScore(Ability ability, Integer score);

	Map<Ability, Integer> build();

}