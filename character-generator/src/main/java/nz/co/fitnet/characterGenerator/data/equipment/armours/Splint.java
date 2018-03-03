package nz.co.fitnet.characterGenerator.data.equipment.armours;

import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Heavy;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;

public class Splint extends Armour {
	public Splint() {
		super(Heavy, 17, false, true, 15, 60, 200);
	}
}
