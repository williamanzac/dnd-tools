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
import nz.co.fitnet.characterGenerator.data.traits.HellishResistanceTrait;

public class Tiefling extends Race {
	public Tiefling() {
		mods.addModifier(Ability.INT, 1);
		mods.addModifier(Ability.CHA, 2);
		traits.add(new AgeTrait(18, 110));
		traits.add(new AlignmentTrait());
		traits.add(new SizeTrait(Size.Medium));
		height = new Measurement(4 * 12 + 9, "2d8"); // 4'9"
		weight = new Measurement(110, "2d4"); // lbs
		traits.add(new SpeedTrait(MovementType.walk, 30));
		traits.add(new KnownLanguagesTrait(Language.Common, Language.Infernal));

		traits.add(new DarkvisionTrait());
		traits.add(new HellishResistanceTrait());
		// TODO Infernal Legacy. You know the thaumaturgy cantrip. Once you reach 3rd level, you can cast the hellish
		// rebuke spell once per day as a 2nd-level spell. Once you reach 5th level, you can also cast the darkness
		// spell once per day. Charisma is your spellcasting ability for these spells.
	}
}
