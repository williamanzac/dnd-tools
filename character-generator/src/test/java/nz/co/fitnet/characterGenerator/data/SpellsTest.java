package nz.co.fitnet.characterGenerator.data;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import nz.co.fitnet.characterGenerator.api.spells.Spell;

public class SpellsTest {

	@Test
	public void verifySpellsByLevel() {
		final Map<Integer, List<Spell>> actual = Spells.spellsByLevel;
		System.out.println(actual);
		final List<Spell> list = actual.get(0);
		final Map<String, List<Spell>> collect = Spells.spellsByClass;
		System.out.println(collect);
	}
}
