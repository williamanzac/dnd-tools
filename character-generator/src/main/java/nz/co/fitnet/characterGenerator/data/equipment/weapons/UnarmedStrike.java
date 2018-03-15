package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Bludgeoning;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Melee;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Simple;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class UnarmedStrike extends Weapon {
	public UnarmedStrike() {
		super(0, Simple, Melee, Bludgeoning, "1", null, 0);
	}
}
