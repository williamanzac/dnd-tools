package nz.co.fitnet.characterGenerator.data.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.Cantrip;

import nz.co.fitnet.characterGenerator.api.traits.Trait;

public class CantripTrait extends Trait<Void> {

	public CantripTrait() {
		super(Cantrip, null);
	}
}
