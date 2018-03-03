package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.Weight;

public class WeightTrait extends MeasurementTrait {
	public WeightTrait(final int base, final String modifier) {
		super(Weight, base, modifier);
	}
}
