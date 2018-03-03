package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Language;
import nz.co.fitnet.characterGenerator.api.MovementType;
import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.api.Size;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.characterGenerator.api.traits.KnownLanguagesTrait;
import nz.co.fitnet.characterGenerator.api.traits.SizeTrait;
import nz.co.fitnet.characterGenerator.api.traits.SpeedTrait;
import nz.co.fitnet.characterGenerator.data.traits.DarkvisionTrait;
import nz.co.fitnet.characterGenerator.data.traits.DwarvenCombatTrainingTrait;
import nz.co.fitnet.characterGenerator.data.traits.DwarvenResilienceTrait;
import nz.co.fitnet.characterGenerator.data.traits.DwarvenToolProficiencyTrait;

public abstract class Dwarf extends Race {
	public Dwarf() {
		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.CON, 2);
		traits.add(new AbilityModifiersTrait(abilityMods));
		traits.add(new AgeTrait(50, 350));
		// TODO alignment trait
		traits.add(new SizeTrait(Size.Medium));
		traits.add(new SpeedTrait(MovementType.walk, 25));
		// TODO Your speed is not reduced by wearing heavy armor.
		traits.add(new KnownLanguagesTrait(Language.Common, Language.Dwarvish));

		traits.add(new DarkvisionTrait());
		traits.add(new DwarvenResilienceTrait());
		// TODO Dwarven Resilience You have advantage on saving throws against poison, and you have resistance against
		// poison damage (explained in chapter 9).
		traits.add(new DwarvenCombatTrainingTrait());
		traits.add(new DwarvenToolProficiencyTrait());
		// TODO Stonecunning Whenever you make an Intelligence (History) check related to the origin of stonework, you
		// are considered proficient in the History skill and add double your proficiency bonus to the check, instead of
		// your normal proficiency bonus.
	}
}
