package nz.co.fitnet.characterGenerator.data.races;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.data.traits.DrowMagicTrait;
import nz.co.fitnet.characterGenerator.data.traits.DrowWeaponTrainingTrait;
import nz.co.fitnet.characterGenerator.data.traits.SunlightSensitivityTrait;
import nz.co.fitnet.characterGenerator.data.traits.SuperiorDarkvisionTrait;

public class Drow extends Elf {
	public Drow() {
		height = new Measurement(4 * 12 + 5, "2d6"); // 4'5"
		weight = new Measurement(75, "1d6"); // lbs

		mods.addModifier(Ability.CHA, 1);
		traits.add(new SuperiorDarkvisionTrait());
		traits.add(new SunlightSensitivityTrait());
		traits.add(new DrowMagicTrait());
		traits.add(new DrowWeaponTrainingTrait());
	}
}
