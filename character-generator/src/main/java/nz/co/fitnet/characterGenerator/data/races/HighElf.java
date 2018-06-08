package nz.co.fitnet.characterGenerator.data.races;

import static nz.co.fitnet.characterGenerator.api.Ability.INT;

import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.data.traits.CantripTrait;
import nz.co.fitnet.characterGenerator.data.traits.ElfWeaponTrainingTrait;
import nz.co.fitnet.characterGenerator.data.traits.ExtraLanguageTrait;

public class HighElf extends Elf {
	public HighElf() {
		height = new Measurement(4 * 12 + 6, "2d10"); // 4'6"
		weight = new Measurement(90, "1d4"); // lbs

		mods.addModifier(INT, 1);
		traits.add(new ElfWeaponTrainingTrait());
		traits.add(new CantripTrait());
		traits.add(new ExtraLanguageTrait());
	}
}
