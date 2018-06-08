package nz.co.fitnet.characterGenerator.data.spells;

import static nz.co.fitnet.characterGenerator.api.spells.Component.M;
import static nz.co.fitnet.characterGenerator.api.spells.Component.S;
import static nz.co.fitnet.characterGenerator.api.spells.Component.V;
import static nz.co.fitnet.characterGenerator.api.spells.School.Enchantment;

import java.util.EnumSet;

import nz.co.fitnet.characterGenerator.api.spells.Spell;

public class Sleep extends Spell {

	public Sleep() {
		school = Enchantment;
		level = 1;
		castingTime = "1 action";
		range = "90 feet";
		components = EnumSet.of(V, S, M);
		duration = "1 minute";
		classes.add("Bard");
		classes.add("Sorcerer");
		classes.add("Wizard");
	}

}
