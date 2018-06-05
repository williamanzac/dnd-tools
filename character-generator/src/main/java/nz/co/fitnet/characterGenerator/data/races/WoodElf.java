package nz.co.fitnet.characterGenerator.data.races;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.data.traits.ElfWeaponTrainingTrait;
import nz.co.fitnet.characterGenerator.data.traits.FleetofFootTrait;

public class WoodElf extends Elf {
	public WoodElf() {
		height = new Measurement(4 * 12 + 6, "2d10"); // 4'6"
		weight = new Measurement(110, "1d4"); // lbs

		mods.addModifier(Ability.WIS, 1);
		traits.add(new ElfWeaponTrainingTrait());
		traits.add(new FleetofFootTrait());
		// TODO Mask of the Wild. You can attempt to hide even when you are only lightly obscured by foliage, heavy
		// rain, falling snow, mist, and other natural phenomena.
	}
}
