package nz.co.fitnet.characterGenerator.data.traits;

import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Light;
import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Medium;

import nz.co.fitnet.characterGenerator.api.traits.ArmourProficiencyTrait;

public class DwarvenArmorTrainingTrait extends ArmourProficiencyTrait {
	public DwarvenArmorTrainingTrait() {
		super(Light, Medium);
	}
}
