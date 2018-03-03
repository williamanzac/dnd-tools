package nz.co.fitnet.characterGenerator.api;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Level {

	private static final List<Level> levelList = new ArrayList<>();
	public static final Map<Integer, Level> levelMap;

	static {
		for (int i = 1; i <= 20; i++) {
			final int bonus = (i + 3) / 4 + 1;
			levelList.add(new Level(i, bonus));
		}
		levelMap = levelList.stream().collect(toMap(Level::getLevel, u -> u));
	}

	private final int level;
	private final int proficiencyBonus;

	public Level(final int level, final int proficiencyBonus) {
		this.level = level;
		this.proficiencyBonus = proficiencyBonus;
	}

	public int getLevel() {
		return level;
	}

	public int getProficiencyBonus() {
		return proficiencyBonus;
	}
}
