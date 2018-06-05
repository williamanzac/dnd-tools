package nz.co.fitnet.characterGenerator.data.races;

import nz.co.fitnet.characterGenerator.api.Ability;

public class ForestGnome extends Gnome {
	public ForestGnome() {
		mods.addModifier(Ability.DEX, 1);

		// TODO Natural Illusionist. You know the minor illusion cantrip. Intelligence is your spellcasting ability for
		// it.
		// TODO Speak with Small Beasts. Through sounds and gestures, you can communicate simple ideas with Small or
		// smaller beasts. Forest gnomes love animals and often keep squirrels, badgers, rabbits, moles, woodpeckers,
		// and other creatures as beloved pets.
	}
}
