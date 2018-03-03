package nz.co.fitnet.ui.core;

import static java.util.Collections.enumeration;
import static java.util.Collections.reverse;
import static java.util.Collections.unmodifiableMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import nz.co.fitnet.characterGenerator.api.Race;

public class RaceResourceBundle extends ResourceBundle {
	private final Map<String, String> entries = new HashMap<>();

	private RaceResourceBundle(final Class<? extends Race> clazz) {
		super();
		final List<Class<? extends Race>> classList = getClassList(clazz);
		classList.forEach(c -> {
			final String lowerCase = c.getSimpleName().toLowerCase();
			final String name = lowerCase + ".properties";
			final Properties p = new Properties();
			final String filename = "/" + name;
			try (final InputStream inStream = clazz.getResourceAsStream(filename);) {
				if (inStream == null) {
					return;
				}
				p.load(inStream);
				p.forEach((k, v) -> {
					entries.put((String) k, (String) v);
				});
			} catch (final IOException e) {
				e.printStackTrace();
			}
		});
	}

	@SuppressWarnings("unchecked")
	private List<Class<? extends Race>> getClassList(final Class<? extends Race> clazz) {
		final List<Class<? extends Race>> list = new ArrayList<>();
		Class<? extends Race> c = clazz;
		while (Race.class.isAssignableFrom(c)) {
			list.add(c);
			c = (Class<? extends Race>) c.getSuperclass();
		}
		reverse(list);
		return list;
	}

	@Override
	protected Object handleGetObject(final String key) {
		return entries.get(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		return enumeration(entries.keySet());
	}

	public Map<String, String> entries() {
		return unmodifiableMap(entries);
	}

	private static Map<Class<?>, RaceResourceBundle> bundleMap = new HashMap<>();

	public static <R extends Race> RaceResourceBundle getBundle(final R race) {
		return getBundle(race.getClass());
	}

	@SuppressWarnings("unchecked")
	public static <R extends Race> RaceResourceBundle forRace(final String raceName) {
		final String className = "nz.co.fitnet.characterGenerator.data.races." + raceName;
		Class<R> clazz;
		try {
			clazz = (Class<R>) Class.forName(className);
			return getBundle(clazz);
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <R extends Race> RaceResourceBundle getBundle(final Class<R> clazz) {
		if (!bundleMap.containsKey(clazz)) {
			bundleMap.put(clazz, new RaceResourceBundle(clazz));
		}
		return bundleMap.get(clazz);
	}
}
