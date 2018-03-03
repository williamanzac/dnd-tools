package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.Size;

import nz.co.fitnet.characterGenerator.api.Size;

public class SizeTrait extends Trait<Size> {
	public SizeTrait(final Size size) {
		super(Size, size);
	}
}
