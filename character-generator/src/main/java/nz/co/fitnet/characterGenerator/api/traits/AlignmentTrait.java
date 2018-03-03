package nz.co.fitnet.characterGenerator.api.traits;

import static nz.co.fitnet.characterGenerator.api.traits.TraitType.Alignment;

import nz.co.fitnet.characterGenerator.api.Alignment;
import nz.co.fitnet.characterGenerator.api.AlignmentPreferences;

public class AlignmentTrait extends Trait<AlignmentPreferences> {

	public AlignmentTrait(final Alignment... alignments) {
		super(Alignment, new AlignmentPreferences(alignments));
	}
}
