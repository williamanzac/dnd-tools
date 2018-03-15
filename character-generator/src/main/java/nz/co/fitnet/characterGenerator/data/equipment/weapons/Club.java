package nz.co.fitnet.characterGenerator.data.equipment.weapons;

import static nz.co.fitnet.characterGenerator.api.DamageType.Bludgeoning;
import static nz.co.fitnet.characterGenerator.api.equipment.AttackType.Melee;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponProperty.Light;
import static nz.co.fitnet.characterGenerator.api.equipment.WeaponType.Simple;

import nz.co.fitnet.characterGenerator.api.equipment.Weapon;

public class Club extends Weapon {
	public Club() {
		super(2, Simple, Melee, Bludgeoning, "1d4", null, 0.1, Light);
	}
}
