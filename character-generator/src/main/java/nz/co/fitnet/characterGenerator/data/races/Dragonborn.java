package nz.co.fitnet.characterGenerator.data.races;

import java.util.HashMap;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.DamageType;
import nz.co.fitnet.characterGenerator.api.Language;
import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.api.MovementType;
import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.api.Size;
import nz.co.fitnet.characterGenerator.api.traits.AbilityModifiersTrait;
import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.characterGenerator.api.traits.AlignmentTrait;
import nz.co.fitnet.characterGenerator.api.traits.KnownLanguagesTrait;
import nz.co.fitnet.characterGenerator.api.traits.SizeTrait;
import nz.co.fitnet.characterGenerator.api.traits.SpeedTrait;
import nz.co.fitnet.characterGenerator.data.traits.BreathWeaponTrait;
import nz.co.fitnet.characterGenerator.data.traits.DragonbornDamageResistanceTrait;

public class Dragonborn extends Race {
	public Dragonborn() {
		final HashMap<Ability, Integer> abilityMods = new HashMap<>();
		abilityMods.put(Ability.STR, 2);
		abilityMods.put(Ability.CHA, 1);
		traits.add(new AbilityModifiersTrait(abilityMods));
		traits.add(new AgeTrait(15, 80));
		traits.add(new AlignmentTrait());
		traits.add(new SizeTrait(Size.Medium));
		height = new Measurement(5 * 12 + 6, "2d8"); // 5'6"
		weight = new Measurement(175, "2d6"); // lbs
		traits.add(new SpeedTrait(MovementType.walk, 30));
		traits.add(new KnownLanguagesTrait(Language.Common, Language.Draconic));

		// TODO Draconic Ancestry. You have draconic ancestry. Choose one type of dragon from the Draconic Ancestry
		// table. Your breath weapon and damage resistance are determined by the dragon type, as shown in the table.
		// TODO Breath Weapon. You can use your action to exhale destructive energy. Your draconic ancestry determines
		// the size, shape, and damage type of the exhalation. When you use your breath weapon, each creature in the
		// area of the exhalation must make a saving throw, the type of which is determined by your draconic ancestry.
		// The DC for this saving throw equals 8 + your Constitution modifier + your proficiency bonus. A creature takes
		// 2d6 damage on a failed save, and half as much damage on a successful one. The damage increases to 3d6 at 6th
		// level, 4d6 at 11th level, and 5d6 at 16th level. After you use your breath weapon, you can’t use it again
		// until you complete a short or long rest.
		// TODO Damage Resistance. You have resistance to the damage type associated with your draconic ancestry.
	}

	public static class Black extends Dragonborn {
		public Black() {
			traits.add(new DragonbornDamageResistanceTrait(DamageType.Acid)); // example
			traits.add(new BreathWeaponTrait(DamageType.Acid, Ability.DEX, "5 by 30 ft. line")); // example
		}
	}
}
