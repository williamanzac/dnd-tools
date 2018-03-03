package nz.co.fitnet.characterGenerator.data.equipment.armours;

import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Medium;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;

public class Breastplate extends Armour {
	public Breastplate() {
		super(Medium, 14, true, false, 0, 20, 400);
	}
}
