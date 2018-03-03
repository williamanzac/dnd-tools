package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;

public class RockGnome extends Gnome {
	public RockGnome() {
		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.CON, 1);
		traits.add(new AbilityModifiersTrait(abilityMods));

		// TODO Artificer’s Lore. Whenever you make an Intelligence (History) check related to magic items, alchemical
		// objects, or technological devices, you can add twice your proficiency bonus, instead of any proficiency bonus
		// you normally apply.
		// TODO Tinker. You have proficiency with artisan’s tools (tinker’s tools). Using those tools, you can spend 1
		// hour and 10 gp worth of materials to construct a Tiny clockwork device (AC 5, 1 hp). The device ceases to
		// function after 24 hours (unless you spend 1 hour repairing it to keep the device functioning), or when you
		// use your action to dismantle it; at that time, you can reclaim the materials used to create it. You can have
		// up to three such devices active at a time.
	}
}
