package nz.co.fitnet.ui.core;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import nz.co.fitnet.characterGenerator.api.Character;
import nz.co.fitnet.ui.api.ChooseRaceStep;
import nz.co.fitnet.ui.api.DwarfCondition;
import nz.co.fitnet.ui.api.DwarfPath;
import nz.co.fitnet.ui.api.FinishedStep;
import nz.co.fitnet.ui.api.WelcomeStep;
import nz.co.fitnet.wizard.WizardStep;
import nz.co.fitnet.wizard.models.BranchingPath;
import nz.co.fitnet.wizard.models.SimplePath;

public class MyCharacters {
	private static final Map<UUID, Character> myCharacters = new HashMap<>();
	private static final Map<UUID, CharacterBuilder> myCharacterBuilders = new HashMap<>();

	public static UUID createNewBuilder() {
		final UUID uuid = UUID.randomUUID();
		final BranchingPath<CharacterBuilderModel, WizardStep<CharacterBuilderModel>> firstPath = new BranchingPath<>();

		final DwarfPath dwarfPath = new DwarfPath();
		// TODO other race paths

		firstPath.addStep(new WelcomeStep());
		firstPath.addStep(new ChooseRaceStep());
		firstPath.addBranch(dwarfPath, new DwarfCondition());
		// TODO other race branches

		final SimplePath<CharacterBuilderModel, WizardStep<CharacterBuilderModel>> lastPath = new SimplePath<>(
				new FinishedStep());

		dwarfPath.setNextPath(lastPath);

		final CharacterBuilderModel model = new CharacterBuilderModel(firstPath);
		final CharacterBuilder characterBuilder = new CharacterBuilder(model);
		myCharacterBuilders.put(uuid, characterBuilder);
		return uuid;
	}

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

	public static CharacterBuilder readBuilder(final UUID uuid) {
		return myCharacterBuilders.get(uuid);
	}

	public static void update(final UUID uuid, final Character character) {
		myCharacters.put(uuid, character);
	}

	public static void updateBuilder(final UUID uuid, final CharacterBuilder character) {
		myCharacterBuilders.put(uuid, character);
	}

	public static void delete(final UUID uuid) {
		myCharacters.remove(uuid);
	}

	public static void deleteBuilder(final UUID uuid) {
		myCharacterBuilders.remove(uuid);
	}

	public static Map<UUID, Character> all() {
		return myCharacters;
	}
}
