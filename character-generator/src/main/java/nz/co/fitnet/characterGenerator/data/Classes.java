package nz.co.fitnet.characterGenerator.data;

import static java.util.Arrays.asList;

import java.util.List;

import nz.co.fitnet.characterGenerator.api.CharacterClass;
import nz.co.fitnet.characterGenerator.data.classes.Barbarian;

public class Classes {
	public static final Barbarian BARBARIAN = new Barbarian();

	public static final List<CharacterClass> classList = asList(BARBARIAN);
}
