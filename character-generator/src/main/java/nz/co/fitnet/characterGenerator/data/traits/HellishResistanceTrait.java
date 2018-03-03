package nz.co.fitnet.characterGenerator.data.traits;

import static nz.co.fitnet.characterGenerator.api.DamageType.Fire;

import nz.co.fitnet.characterGenerator.api.traits.DamageResistanceTrait;

public class HellishResistanceTrait extends DamageResistanceTrait {
	public HellishResistanceTrait() {
		super(Fire);
	}
}
