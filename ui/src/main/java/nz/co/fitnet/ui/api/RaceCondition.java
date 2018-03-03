package nz.co.fitnet.ui.api;

import java.lang.reflect.ParameterizedType;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.ui.core.CharacterBuilderModel;
import nz.co.fitnet.wizard.models.Condition;

public abstract class RaceCondition<R extends Race> implements Condition<CharacterBuilderModel> {
	private final Class<R> clazz;

	@SuppressWarnings("unchecked")
	public RaceCondition() {
		clazz = (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public boolean evaluate(final CharacterBuilderModel model) {
		final Class<? extends Race> class1 = model.getRace().getClass();
		return clazz.isAssignableFrom(class1);
	}
}
