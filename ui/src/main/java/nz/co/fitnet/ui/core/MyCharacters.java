package nz.co.fitnet.ui.core;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import nz.co.fitnet.characterGenerator.api.Character;

public class MyCharacters {
	private static final Map<UUID, Character> myCharacters = new HashMap<>();

	public static UUID create(final Character character) {
		final UUID uuid = UUID.randomUUID();
		return create(uuid, character);
	}

	public static UUID create(final UUID uuid, final Character character) {
		myCharacters.put(uuid, character);
		return uuid;
	}

	public static Character read(final UUID uuid) {
		return myCharacters.get(uuid);
	}

	public static void update(final UUID uuid, final Character character) {
		myCharacters.put(uuid, character);
	}

	public static void delete(final UUID uuid) {
		myCharacters.remove(uuid);
	}

	public static Map<UUID, Character> all() {
		return myCharacters;
	}
}
