package nz.co.fitnet.characterGenerator.data.races;

import nz.co.fitnet.characterGenerator.api.Ability;

public class Lightfoot extends Halfling {
	public Lightfoot() {
		mods.addModifier(Ability.CHA, 1);
		// TODO Naturally Stealthy. You can attempt to hide even when you are obscured only by a creature that is at
		// least one size larger than you.
	}
}
