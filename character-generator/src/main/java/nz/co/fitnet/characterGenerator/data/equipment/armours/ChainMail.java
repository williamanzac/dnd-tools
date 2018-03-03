package nz.co.fitnet.characterGenerator.data.equipment.armours;

import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Heavy;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;

public class ChainMail extends Armour {
	public ChainMail() {
		super(Heavy, 16, false, true, 13, 55, 75);
	}
}
