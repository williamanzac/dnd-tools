package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.Age;

import nz.co.fitnet.characterGenerator.api.Age;

public class AgeTrait extends Trait<Age> {

	public AgeTrait(final int maturity, final int max) {
		super(Age, new Age(maturity, max));
	}
}
