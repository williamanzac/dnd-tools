package nz.co.fitnet.ui.core;

import static nz.co.fitnet.ui.core.MyCharacters.createNewBuilder;
import static nz.co.fitnet.ui.core.MyCharacters.readBuilder;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.util.UUID;

import org.junit.Test;

import nz.co.fitnet.characterGenerator.data.Races;
import nz.co.fitnet.ui.api.ChooseRaceStep;
import nz.co.fitnet.ui.api.DwarfStep;
import nz.co.fitnet.ui.api.FinishedStep;
import nz.co.fitnet.ui.api.WelcomeStep;
import nz.co.fitnet.wizard.InvalidStateException;
import nz.co.fitnet.wizard.WizardStep;

public class CharacterBuilderTest {
	@Test
	public void verifySteps() throws InvalidStateException {
		final UUID uuid = createNewBuilder();
		final CharacterBuilder characterBuilder = readBuilder(uuid);
		WizardStep<CharacterBuilderModel> activeStep = characterBuilder.getActiveStep();
		assertThat(activeStep, instanceOf(WelcomeStep.class));

		characterBuilder.nextStep();
		activeStep = characterBuilder.getActiveStep();
		assertThat(activeStep, instanceOf(ChooseRaceStep.class));

		characterBuilder.getModel().setRace(Races.HILL_DWARF);
		characterBuilder.getModel().refreshModelState();
		characterBuilder.nextStep();
		activeStep = characterBuilder.getActiveStep();
		assertThat(activeStep, instanceOf(DwarfStep.class));

		characterBuilder.nextStep();
		activeStep = characterBuilder.getActiveStep();
		assertThat(activeStep, instanceOf(FinishedStep.class));
	}
}
