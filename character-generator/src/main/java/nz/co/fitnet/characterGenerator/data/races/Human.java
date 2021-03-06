package nz.co.fitnet.characterGenerator.data.races;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Language;
import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.api.MovementType;
import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.api.Size;
import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.characterGenerator.api.traits.AlignmentTrait;
import nz.co.fitnet.characterGenerator.api.traits.KnownLanguagesTrait;
import nz.co.fitnet.characterGenerator.api.traits.SizeTrait;
import nz.co.fitnet.characterGenerator.api.traits.SpeedTrait;

public class Human extends Race {
	public Human() {
		for (final Ability ability : Ability.values()) {
			mods.addModifier(ability, 1);
		}
		traits.add(new AgeTrait(18, 100));
		traits.add(new AlignmentTrait());
		traits.add(new SizeTrait(Size.Medium));
		height = new Measurement(4 * 12 + 8, "2d10"); // 4'8"
		weight = new Measurement(110, "2d4");// lbs
		traits.add(new SpeedTrait(MovementType.walk, 30));
		traits.add(new KnownLanguagesTrait(1, Language.Common));
	}
}
