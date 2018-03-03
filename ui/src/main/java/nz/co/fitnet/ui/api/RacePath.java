package nz.co.fitnet.ui.api;

import java.lang.reflect.ParameterizedType;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.ui.core.CharacterBuilderModel;
import nz.co.fitnet.wizard.WizardStep;
import nz.co.fitnet.wizard.models.SimplePath;

public abstract class RacePath<R extends Race>
		extends SimplePath<CharacterBuilderModel, WizardStep<CharacterBuilderModel>> {
	private final Class<R> clazz;

	@SuppressWarnings("unchecked")
	public RacePath(final RaceStep<R> step) {
		super(step);
		clazz = (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<R> getClazz() {
		return clazz;
	}
}
