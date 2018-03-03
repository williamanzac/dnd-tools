package nz.co.fitnet.ui.resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.dropwizard.views.View;
import nz.co.fitnet.wizard.WizardModel;
import nz.co.fitnet.wizard.WizardStep;

public abstract class StepView<S extends WizardStep<?>, M extends WizardModel<WizardStep<M>>> extends View {
	private final S step;
	private final String type;
	private final M model;
	private final List<WizardStep<M>> steps = new ArrayList<>();

	public StepView(final String type, final S step, final M model) {
		super("/" + type + "/builder/steps/" + step.getView() + ".ui.ftl");
		this.step = step;
		this.type = type;
		this.model = model;
		final Iterator<WizardStep<M>> stepIterator = model.stepIterator();
		while (stepIterator.hasNext()) {
			steps.add(stepIterator.next());
		}
	}

	public S getStep() {
		return step;
	}

	public String getType() {
		return type;
	}

	public M getModel() {
		return model;
	}

	public List<WizardStep<M>> getSteps() {
		return steps;
	}
}
