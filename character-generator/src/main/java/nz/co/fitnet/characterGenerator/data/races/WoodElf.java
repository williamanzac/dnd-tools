package nz.co.fitnet.characterGenerator.data.races;

import static nz.co.fitnet.characterGenerator.api.Ability.WIS;

import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.data.traits.ElfWeaponTrainingTrait;
import nz.co.fitnet.characterGenerator.data.traits.FleetofFootTrait;
import nz.co.fitnet.characterGenerator.data.traits.MaskoftheWildTrait;

public class WoodElf extends Elf {
	public WoodElf() {
		height = new Measurement(4 * 12 + 6, "2d10"); // 4'6"
		weight = new Measurement(110, "1d4"); // lbs

		mods.addModifier(WIS, 1);
		traits.add(new ElfWeaponTrainingTrait());
		traits.add(new FleetofFootTrait());
		traits.add(new MaskoftheWildTrait());
	}
}
