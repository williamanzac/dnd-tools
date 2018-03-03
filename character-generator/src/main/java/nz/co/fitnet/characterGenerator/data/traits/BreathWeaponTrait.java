package nz.co.fitnet.characterGenerator.data.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.BreathWeapon;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.BreathWeapon;
import nz.co.fitnet.characterGenerator.api.DamageType;
import nz.co.fitnet.characterGenerator.api.traits.Trait;

public class BreathWeaponTrait extends Trait<BreathWeapon> {
	public BreathWeaponTrait(final DamageType damageType, final Ability saveType, final String shape) {
		super(BreathWeapon, new BreathWeapon(damageType, saveType, shape));
	}
}
