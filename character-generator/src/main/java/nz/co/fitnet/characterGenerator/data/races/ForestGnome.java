package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;

public class ForestGnome extends Gnome {
	public ForestGnome() {
		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.DEX, 1);
		traits.add(new AbilityModifiersTrait(abilityMods));

		// TODO Natural Illusionist. You know the minor illusion cantrip. Intelligence is your spellcasting ability for
		// it.
		// TODO Speak with Small Beasts. Through sounds and gestures, you can communicate simple ideas with Small or
		// smaller beasts. Forest gnomes love animals and often keep squirrels, badgers, rabbits, moles, woodpeckers,
		// and other creatures as beloved pets.
	}
}
