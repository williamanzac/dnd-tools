package nz.co.fitnet.characterGenerator.data.equipment.armours;

import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Light;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;

public class Leather extends Armour {
	public Leather() {
		super(Light, 11, true, false, 0, 10, 10);
	}
}
