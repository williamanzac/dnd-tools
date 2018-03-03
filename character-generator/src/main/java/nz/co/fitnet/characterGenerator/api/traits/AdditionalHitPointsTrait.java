package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.AdditionalHP;

public abstract class AdditionalHitPointsTrait extends Trait<Integer> {
	public AdditionalHitPointsTrait(final Integer value) {
		super(AdditionalHP, value);
	}
}
