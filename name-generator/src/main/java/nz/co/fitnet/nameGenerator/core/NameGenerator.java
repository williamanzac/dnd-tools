package nz.co.fitnet.nameGenerator.core;

import static java.util.regex.Pattern.compile;
import static java.util.stream.Collectors.joining;
import static nz.co.fitnet.nameGenerator.api.Type.Markov;
import static nz.co.fitnet.nameGenerator.api.Type.Random;
import static nz.co.fitnet.nameGenerator.data.Names.nameMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.jvnet.hk2.annotations.Service;

import nz.co.fitnet.nameGenerator.api.NameDefinition;
import nz.co.fitnet.nameGenerator.api.NameDefinitionList;
import nz.co.fitnet.nameGenerator.api.NamePartDefinition;
import nz.co.fitnet.nameGenerator.api.NameService;
import nz.co.fitnet.nameGenerator.api.NameServiceException;
import nz.co.fitnet.nameGenerator.api.Type;
import nz.co.fitnet.numberGenerator.core.NumberGenerator;

@Service
public class NameGenerator implements NameService {
	private final RandomCompator<String> stringCompator;
	private final RandomCompator<NameDefinition> definitionCompator;
	private static final Pattern parameterPattern = compile("\\{(.*)\\}");

	@Inject
	public NameGenerator(final NumberGenerator numberService) {
		stringCompator = new RandomCompator<>(numberService);
		definitionCompator = new RandomCompator<>(numberService);
	}

	@Override
	public String generateName(final Type type, final String name, final Map<String, String> parameters) {
		final NameDefinitionList nameDefinitionList = nameMap.get(name);
		final NameDefinition nameDefinition = nameDefinitionList.getDefinitions().stream().sorted(definitionCompator)
				.limit(1).findFirst().get();
		final String format = nameDefinition.getFormat();
		final String[] formatparts = format.split("\\s");
		final String ret = Stream.of(formatparts).map(p -> {
			final Matcher matcher = parameterPattern.matcher(p);
			final String key;
			if (matcher.find()) {
				final String parameter = matcher.group(1);
				if (parameters.containsKey(parameter)) {
					key = parameters.get(parameter);
				} else {
					key = parameter;
				}
			} else {
				key = p;
			}
			final NamePartDefinition definition = nameDefinition.getPart(key);
			try {
				return generateName(type, definition);
			} catch (final NameServiceException e) {
				e.printStackTrace();
			}
			return null;
		}).collect(joining(" "));
		return ret;
	}

	@Override
	public List<String> nameList(final Type type, final String name, final Map<String, String> parameters,
			final int numOf) {
		final List<String> names = new ArrayList<>();
		for (int i = 0; i < numOf; i++) {
			names.add(generateName(type, name, parameters));
		}
		return names;
	}

	private String generateName(final Type type, final NamePartDefinition definition) throws NameServiceException {
		final Type generationType = definition.getGenerationType();
		if (generationType == Random || type == Random && generationType != Markov) {
			return definition.getNames().stream().sorted(stringCompator).limit(1).findFirst().get();
		}
		// definition type is markov or definition type is any and type is markov
		final Map<String, Map<String, Double>> chain = markovChain(definition.getNames());
		if (chain == null) {
			throw new NameServiceException("Unable to generate Name.");
		}
		return markovName(chain);
	}

	private Map<String, Map<String, Double>> markovChain(final List<String> list) throws NameServiceException {
		if (list == null || list.isEmpty()) {
			throw new NameServiceException("No Names defined.");
		}
		final Map<String, Map<String, Double>> chain = constructChain(list);
		if (chain == null || chain.isEmpty()) {
			throw new NameServiceException("Unable to process names.");
		}
		return chain;
	}

	private Map<String, Map<String, Double>> constructChain(final List<String> list) {
		final Map<String, Map<String, Double>> chain = new HashMap<>();

		for (int i = 0; i < list.size(); i++) {
			final String[] names = list.get(i).split("\\s+");
			incrChain(chain, "parts", String.valueOf(names.length));

			for (final String name : names) {
				incrChain(chain, "nameLen", String.valueOf(name.length()));

				List<String> strings = splitName(name);

				String c = strings.get(0);
				incrChain(chain, "initial", c);

				strings = strings.subList(1, strings.size());
				String lastC = c;

				while (!strings.isEmpty()) {
					c = strings.get(0);
					incrChain(chain, lastC, c);

					strings = strings.subList(1, strings.size());
					lastC = c;
				}
			}
		}
		scaleChain(chain);
		return chain;
	}

	private List<String> splitName(final String name) {
		final List<String> strings = new ArrayList<>();
		boolean prevVowel = false;
		StringBuilder vowelGroup = new StringBuilder();
		for (final char c : name.toCharArray()) {
			if (isVowel(c)) {
				if (!prevVowel) {
					// start vowel group
					vowelGroup = new StringBuilder();
				}
				// add to vowel group
				vowelGroup.append(c);
				prevVowel = true;
			} else {
				// not a vowel so just add single character to list
				if (prevVowel) {
					// add vowel group
					strings.add(vowelGroup.toString());
				}
				prevVowel = false;
				strings.add(String.valueOf(c));
			}
		}
		if (prevVowel) {
			// add vowel group
			strings.add(vowelGroup.toString());
		}
		return strings;
	}

	private boolean isVowel(final char c) {
		return StringUtils.contains("aeiouAEIOU", c);
	}

	private void incrChain(final Map<String, Map<String, Double>> chain, final String key, final String token) {
		if (chain.containsKey(key)) {
			final Map<String, Double> map = chain.get(key);
			if (map.containsKey(token)) {
				map.put(token, chain.get(key).get(token) + 1);
			} else {
				map.put(token, 1.0);
			}
		} else {
			chain.put(key, new HashMap<>());
			chain.get(key).put(token, 1.0);
		}
	}

	private void scaleChain(final Map<String, Map<String, Double>> chain) {
		final Map<String, Double> tableLen = new HashMap<>();

		for (final String key : chain.keySet()) {
			tableLen.put(key, 0.0);
			final Map<String, Double> map = chain.get(key);
			for (final String token : map.keySet()) {
				final double count = map.get(token);
				final double weighted = Math.floor(Math.pow(count, 1.3));

				map.put(token, weighted);
				tableLen.put(key, tableLen.get(key) + weighted);
			}
		}
		chain.put("tableLen", tableLen);
	}

	private String markovName(final Map<String, Map<String, Double>> chain) {
		final int parts = Integer.valueOf(selectLink(chain, "parts"));
		final List<String> names = new ArrayList<>();

		for (int i = 0; i < parts; i++) {
			int nameLen = Integer.valueOf(selectLink(chain, "nameLen"));
			String c = selectLink(chain, "initial");
			final List<String> name = new ArrayList<>();
			name.add(c);

			while (String.join("", name).length() < nameLen) {
				c = selectLink(chain, name.get(name.size() - 1));
				if (c == null) {
					nameLen = name.size();
					continue;
				}
				name.add(c);
			}
			names.add(String.join("", name));
		}
		return String.join(" ", names);
	}

	private String selectLink(final Map<String, Map<String, Double>> chain, final String key) {
		final Map<String, Double> tableLen = chain.get("tableLen");
		if (!tableLen.containsKey(key)) {
			return null;
		}
		final double len = tableLen.get(key);
		final double idx = Math.floor(Math.random() * len);

		if (!chain.containsKey(key)) {
			return null;
		}
		int t = 0;
		final Map<String, Double> map = chain.get(key);
		for (final String token : map.keySet()) {
			t += map.get(token);
			if (idx < t) {
				return token;
			}
		}
		return null;
	}
}
