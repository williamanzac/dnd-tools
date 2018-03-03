package nz.co.fitnet.characterGenerator.data.traits;

import static nz.co.fitnet.characterGenerator.api.DamageType.Poison;

import nz.co.fitnet.characterGenerator.api.traits.DamageResistanceTrait;

public class DwarvenResilienceTrait extends DamageResistanceTrait {
	public DwarvenResilienceTrait() {
		super(Poison);
	}
}
