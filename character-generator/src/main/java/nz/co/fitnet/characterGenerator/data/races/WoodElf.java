package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.api.traits.HeightTrait;
import nz.co.fitnet.characterGenerator.api.traits.WeightTrait;
import nz.co.fitnet.characterGenerator.data.traits.ElfWeaponTrainingTrait;
import nz.co.fitnet.characterGenerator.data.traits.FleetofFootTrait;

public class WoodElf extends Elf {
	public WoodElf() {
		traits.add(new HeightTrait(4 * 12 + 6, "2d10")); // 4'6"
		traits.add(new WeightTrait(110, "1d4")); // lbs

		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.WIS, 1);
		traits.add(new AbilityModifiersTrait(abilityMods));
		traits.add(new ElfWeaponTrainingTrait());
		traits.add(new FleetofFootTrait());
		// TODO Mask of the Wild. You can attempt to hide even when you are only lightly obscured by foliage, heavy
		// rain, falling snow, mist, and other natural phenomena.
	}
}
