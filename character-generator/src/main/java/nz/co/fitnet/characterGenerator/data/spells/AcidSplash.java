package nz.co.fitnet.characterGenerator.data.spells;

import static nz.co.fitnet.characterGenerator.api.spells.Component.S;
import static nz.co.fitnet.characterGenerator.api.spells.Component.V;
import static nz.co.fitnet.characterGenerator.api.spells.School.Conjuration;

import java.util.EnumSet;

import nz.co.fitnet.characterGenerator.api.spells.Spell;

public class AcidSplash extends Spell {
	public AcidSplash() {
		school = Conjuration;
		level = 0;
		castingTime = "1 action";
		range = "60 feet";
		components = EnumSet.of(V, S);
		duration = "Instantaneous";
		classes.add("Bard");
		classes.add("Wizard");
	}
}
