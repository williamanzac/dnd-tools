package nz.co.fitnet.ui.api;

import nz.co.fitnet.ui.core.CharacterBuilderModel;
import nz.co.fitnet.wizard.InvalidStateException;

public class FinishedStep extends CharacterBuilderStep {

	public FinishedStep() {
		super();
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

	@Override
	public boolean isComplete() {
		return true;
	}
}
