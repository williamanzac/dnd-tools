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
import nz.co.fitnet.characterGenerator.data.traits.DarkvisionTrait;

public abstract class Gnome extends Race {
	public Gnome() {
		mods.addModifier(Ability.INT, 2);
		traits.add(new AgeTrait(40, 500));
		traits.add(new AlignmentTrait());
		traits.add(new SizeTrait(Size.Small));
		height = new Measurement(2 * 12 + 11, "2d4"); // 2'11"
		weight = new Measurement(35, "1"); // lbs
		traits.add(new SpeedTrait(MovementType.walk, 25));
		traits.add(new KnownLanguagesTrait(Language.Common, Language.Gnomish));

		traits.add(new DarkvisionTrait());
		// Gnome Cunning. You have advantage on all Intelligence, Wisdom, and Charisma saving throws against magic.
	}
}
