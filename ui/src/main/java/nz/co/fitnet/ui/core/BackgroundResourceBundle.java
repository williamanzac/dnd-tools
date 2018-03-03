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

import nz.co.fitnet.characterGenerator.api.Background;

public class BackgroundResourceBundle extends ResourceBundle {
	private final Map<String, String> entries = new HashMap<>();

	private BackgroundResourceBundle(final Class<? extends Background> clazz) {
		super();
		final List<Class<? extends Background>> classList = getClassList(clazz);
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
	private List<Class<? extends Background>> getClassList(final Class<? extends Background> clazz) {
		final List<Class<? extends Background>> list = new ArrayList<>();
		Class<? extends Background> c = clazz;
		while (Background.class.isAssignableFrom(c)) {
			list.add(c);
			c = (Class<? extends Background>) c.getSuperclass();
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

	private static Map<Class<?>, BackgroundResourceBundle> bundleMap = new HashMap<>();

	public static <R extends Background> BackgroundResourceBundle getBundle(final R background) {
		return getBundle(background.getClass());
	}

	@SuppressWarnings("unchecked")
	public static <R extends Background> BackgroundResourceBundle forBackground(final String backgroundName) {
		final String className = "nz.co.fitnet.characterGenerator.data.backgrounds." + backgroundName;
		Class<R> clazz;
		try {
			clazz = (Class<R>) Class.forName(className);
			return getBundle(clazz);
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <R extends Background> BackgroundResourceBundle getBundle(final Class<R> clazz) {
		if (!bundleMap.containsKey(clazz)) {
			bundleMap.put(clazz, new BackgroundResourceBundle(clazz));
		}
		return bundleMap.get(clazz);
	}
}
