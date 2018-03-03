package nz.co.fitnet.characterGenerator.data.equipment.armours;

import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Light;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;

public class Padded extends Armour {
	public Padded() {
		super(Light, 11, true, true, 0, 8, 5);
	}
}
