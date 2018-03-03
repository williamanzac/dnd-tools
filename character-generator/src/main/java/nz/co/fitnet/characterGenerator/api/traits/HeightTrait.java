package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.Height;

public class HeightTrait extends MeasurementTrait {
	public HeightTrait(final int base, final String modifier) {
		super(Height, base, modifier);
	}
}
