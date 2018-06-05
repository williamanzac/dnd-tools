package nz.co.fitnet.characterGenerator.data.races;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.data.traits.ElfWeaponTrainingTrait;
import nz.co.fitnet.characterGenerator.data.traits.ExtraLanguageTrait;

public class HighElf extends Elf {
	public HighElf() {
		height = new Measurement(4 * 12 + 6, "2d10"); // 4'6"
		weight = new Measurement(90, "1d4"); // lbs

		mods.addModifier(Ability.INT, 1);
		traits.add(new ElfWeaponTrainingTrait());
		// TODO Cantrip. You know one cantrip of your choice from the wizard spell list. Intelligence is your
		// spellcasting ability for it.
		traits.add(new ExtraLanguageTrait());
	}
}
