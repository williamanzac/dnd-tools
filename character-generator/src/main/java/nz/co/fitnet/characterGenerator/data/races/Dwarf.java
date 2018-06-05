package nz.co.fitnet.characterGenerator.data.races;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Language;
import nz.co.fitnet.characterGenerator.api.MovementType;
import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.api.Size;
import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.characterGenerator.api.traits.AlignmentTrait;
import nz.co.fitnet.characterGenerator.api.traits.KnownLanguagesTrait;
import nz.co.fitnet.characterGenerator.api.traits.SizeTrait;
import nz.co.fitnet.characterGenerator.api.traits.SpeedTrait;
import nz.co.fitnet.characterGenerator.data.traits.DarkvisionTrait;
import nz.co.fitnet.characterGenerator.data.traits.DwarvenCombatTrainingTrait;
import nz.co.fitnet.characterGenerator.data.traits.DwarvenResilienceTrait;
import nz.co.fitnet.characterGenerator.data.traits.DwarvenToolProficiencyTrait;
import nz.co.fitnet.characterGenerator.data.traits.Stonecunning;

public abstract class Dwarf extends Race {
	public Dwarf() {
		mods.addModifier(Ability.CON, 2);
		traits.add(new AgeTrait(50, 350));
		traits.add(new AlignmentTrait());
		traits.add(new SizeTrait(Size.Medium));
		traits.add(new SpeedTrait(MovementType.walk, 25));
		traits.add(new DarkvisionTrait());
		traits.add(new DwarvenResilienceTrait());
		traits.add(new DwarvenCombatTrainingTrait());
		traits.add(new DwarvenToolProficiencyTrait());
		traits.add(new Stonecunning());
		traits.add(new KnownLanguagesTrait(Language.Common, Language.Dwarvish));
	}
}
