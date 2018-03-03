package nz.co.fitnet.characterGenerator.data.equipment.armours;

import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Medium;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;

public class Hide extends Armour {
	public Hide() {
		super(Medium, 12, true, false, 0, 12, 10);
	}
}
