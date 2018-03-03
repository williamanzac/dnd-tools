package nz.co.fitnet.characterGenerator.data;

import static java.util.Arrays.asList;

import java.util.List;

import nz.co.fitnet.characterGenerator.api.Archetype;
import nz.co.fitnet.characterGenerator.data.classes.PathOfTheBerserker;

public class Archetypes {
	public static final PathOfTheBerserker PATH_OF_THE_BERSERKER = new PathOfTheBerserker();

	public static final List<Archetype> archtypeList = asList(PATH_OF_THE_BERSERKER);
}
