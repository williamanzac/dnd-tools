package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.data.traits.StoutResilienceTrait;

public class Stout extends Halfling {
	public Stout() {
		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.CON, 1);
		traits.add(new AbilityModifiersTrait(abilityMods));
		traits.add(new StoutResilienceTrait());
		// TODO Stout Resilience. You have advantage on saving throws against poison, and you have resistance against
		// poison damage.
	}
}
