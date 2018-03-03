package nz.co.fitnet.characterGenerator.data;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import nz.co.fitnet.characterGenerator.api.spells.Spell;
import nz.co.fitnet.characterGenerator.data.spells.AcidSplash;

public class Spells {
	public static final AcidSplash ACID_SPLASH = new AcidSplash();

	public static final List<Spell> spellList = asList(ACID_SPLASH);
	public static final Map<Integer, List<Spell>> spellsByLevel = spellList.stream()
			.collect(groupingBy(Spell::getLevel));
	public static final Map<String, List<Spell>> spellsByClass = spellList.stream().map(s -> {
		final List<Pair<String, Spell>> pairs = new ArrayList<>();
		s.getClasses().forEach(c -> pairs.add(new ImmutablePair<>(c, s)));
		return pairs;
	}).flatMap(Collection::stream).collect(groupingBy(Pair::getLeft, mapping(Pair::getRight, toList())));
}
