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

import nz.co.fitnet.characterGenerator.api.CharacterClass;

public class ClassResourceBundle extends ResourceBundle {
	private final Map<String, String> entries = new HashMap<>();

	private ClassResourceBundle(final Class<? extends CharacterClass> clazz) {
		super();
		final List<Class<? extends CharacterClass>> classList = getClassList(clazz);
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
	private List<Class<? extends CharacterClass>> getClassList(final Class<? extends CharacterClass> clazz) {
		final List<Class<? extends CharacterClass>> list = new ArrayList<>();
		Class<? extends CharacterClass> c = clazz;
		while (CharacterClass.class.isAssignableFrom(c)) {
			list.add(c);
			c = (Class<? extends CharacterClass>) c.getSuperclass();
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

	private static Map<Class<?>, ClassResourceBundle> bundleMap = new HashMap<>();

	public static <R extends CharacterClass> ClassResourceBundle getBundle(final R race) {
		return getBundle(race.getClass());
	}

	@SuppressWarnings("unchecked")
	public static <R extends CharacterClass> ClassResourceBundle forCharacterClass(final String raceName) {
		final String className = "nz.co.fitnet.characterGenerator.data.classes." + raceName;
		Class<R> clazz;
		try {
			clazz = (Class<R>) Class.forName(className);
			return getBundle(clazz);
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <R extends CharacterClass> ClassResourceBundle getBundle(final Class<R> clazz) {
		if (!bundleMap.containsKey(clazz)) {
			bundleMap.put(clazz, new ClassResourceBundle(clazz));
		}
		return bundleMap.get(clazz);
	}
}
