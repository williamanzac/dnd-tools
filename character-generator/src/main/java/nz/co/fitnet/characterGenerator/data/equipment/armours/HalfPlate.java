package nz.co.fitnet.characterGenerator.data.equipment.armours;

import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Medium;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;

public class HalfPlate extends Armour {
	public HalfPlate() {
		super(Medium, 15, true, true, 0, 40, 750);
	}
}
