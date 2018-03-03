package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import nz.co.fitnet.characterGenerator.api.DamageType;
import nz.co.fitnet.characterGenerator.api.equipment.Weapon;
import nz.co.fitnet.characterGenerator.api.equipment.WeaponType;

public class UnarmedStrike extends Weapon {
	public UnarmedStrike() {
		super(0, WeaponType.Simple, DamageType.Bludgeoning, "1", null, 0);
	}
}
