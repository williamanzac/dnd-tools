package nz.co.fitnet.characterGenerator.data.equipment.armours;

import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Light;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;

public class StuddedLeather extends Armour {
	public StuddedLeather() {
		super(Light, 12, true, false, 0, 13, 45);
	}
}
