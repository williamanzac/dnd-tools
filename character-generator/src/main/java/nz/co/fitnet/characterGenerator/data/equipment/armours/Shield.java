package nz.co.fitnet.characterGenerator.data.equipment.armours;

import static nz.co.fitnet.characterGenerator.api.equipment.ArmourType.Shield;

import nz.co.fitnet.characterGenerator.api.equipment.Armour;

public class Shield extends Armour {
	public Shield() {
		super(Shield, 2, false, false, 0, 6, 10);
	}
}
