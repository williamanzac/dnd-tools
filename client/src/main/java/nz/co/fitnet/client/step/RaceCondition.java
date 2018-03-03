package nz.co.fitnet.client.step;

import java.lang.reflect.ParameterizedType;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.client.CharacterBuilderModel;
import nz.co.fitnet.wizard.WizardModel;
import nz.co.fitnet.wizard.models.Condition;

public abstract class RaceCondition<R extends Race> implements Condition {
	private final Class<R> clazz;

	@SuppressWarnings("unchecked")
	public RaceCondition() {
		clazz = (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public boolean evaluate(final WizardModel model) {
		if (!(model instanceof CharacterBuilderModel)) {
			return false;
		}
		if (((CharacterBuilderModel) model).getRace() == null) {
			return false;
		}
		final Class<? extends Race> class1 = ((CharacterBuilderModel) model).getRace().getClass();
		return clazz.isAssignableFrom(class1);
	}
}
