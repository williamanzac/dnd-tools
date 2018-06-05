package nz.co.fitnet.characterGenerator.data.races;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.data.traits.StoutResilienceTrait;

public class Stout extends Halfling {
	public Stout() {
		mods.addModifier(Ability.CON, 1);
		traits.add(new StoutResilienceTrait());
		// TODO Stout Resilience. You have advantage on saving throws against poison, and you have resistance against
		// poison damage.
	}
}
