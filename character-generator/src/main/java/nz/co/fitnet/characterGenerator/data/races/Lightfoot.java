package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;

public class Lightfoot extends Halfling {
	public Lightfoot() {
		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.CHA, 1);
		traits.add(new AbilityModifiersTrait(abilityMods));
		// TODO Naturally Stealthy. You can attempt to hide even when you are obscured only by a creature that is at
		// least one size larger than you.
	}
}
