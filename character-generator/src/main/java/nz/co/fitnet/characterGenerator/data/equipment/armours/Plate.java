package nz.co.fitnet.characterGenerator.data.equipment.armours;

import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Heavy;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;

public class Plate extends Armour {
	public Plate() {
		super(Heavy, 18, false, true, 15, 65, 1500);
	}
}
