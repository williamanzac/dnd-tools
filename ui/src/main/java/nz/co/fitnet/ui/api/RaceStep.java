package nz.co.fitnet.ui.api;

import java.lang.reflect.ParameterizedType;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.ui.core.CharacterBuilderModel;
import nz.co.fitnet.wizard.InvalidStateException;

public abstract class RaceStep<R extends Race> extends CharacterBuilderStep {
	private final Class<R> clazz;

	@SuppressWarnings("unchecked")
	public RaceStep() {
		super();
		clazz = (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public String getView() {
		return null;
	}

	@Override
	public void prepare() {
	}

	@Override
	public void applyState() throws InvalidStateException {
	}

	@Override
	public void init(final CharacterBuilderModel model) {
	}

	public Class<R> getClazz() {
		return clazz;
	}
}
