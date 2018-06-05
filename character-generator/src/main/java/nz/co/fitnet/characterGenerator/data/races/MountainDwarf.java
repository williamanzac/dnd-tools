package nz.co.fitnet.characterGenerator.data.races;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.data.traits.DwarvenArmorTrainingTrait;

public class MountainDwarf extends Dwarf {
	public MountainDwarf() {
		height = new Measurement(4 * 12, "2d4"); // 4'
		weight = new Measurement(130, "2d6"); // lbs

		mods.addModifier(Ability.STR, 2);
		traits.add(new DwarvenArmorTrainingTrait());
	}
}
