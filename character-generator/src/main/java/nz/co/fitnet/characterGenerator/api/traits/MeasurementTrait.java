package nz.co.fitnet.characterGenerator.api.traits;

import nz.co.fitnet.characterGenerator.api.Measurement;

public abstract class MeasurementTrait extends Trait<Measurement> {
	public MeasurementTrait(final TraitType type, final int base, final String modifier) {
		super(type, new Measurement(base, modifier));
	}
}
