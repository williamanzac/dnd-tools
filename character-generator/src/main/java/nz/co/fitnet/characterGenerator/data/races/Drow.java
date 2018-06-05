package nz.co.fitnet.characterGenerator.data.races;

import nz.co.fitnet.characterGenerator.api.Ability;
import nz.co.fitnet.characterGenerator.api.Measurement;
import nz.co.fitnet.characterGenerator.data.traits.DrowWeaponTrainingTrait;
import nz.co.fitnet.characterGenerator.data.traits.SuperiorDarkvisionTrait;

public class Drow extends Elf {
	public Drow() {
		height = new Measurement(4 * 12 + 5, "2d6"); // 4'5"
		weight = new Measurement(75, "1d6"); // lbs

		mods.addModifier(Ability.CHA, 1);
		traits.add(new SuperiorDarkvisionTrait());
		// TODO Sunlight Sensitivity. You have disadvantage on attack rolls and on Wisdom (Perception) checks that rely
		// on sight when you, the target o f your attack, or whatever you are trying to perceive is in direct sunlight.
		// TODO Drow Magic. You know the dancing lights cantrip. When you reach 3rd level, you can cast the faerie fire
		// spell once per day. When you reach 5th level, you can also cast the darkness spell once per day. Charisma is
		// your spellcasting ability for these spells.
		traits.add(new DrowWeaponTrainingTrait());
	}
}
