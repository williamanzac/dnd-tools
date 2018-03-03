package nz.co.fitnet.client;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import nz.co.fitnet.client.step.ChooseRaceStep;
import nz.co.fitnet.client.step.DwarfCondition;
import nz.co.fitnet.client.step.DwarfPath;
import nz.co.fitnet.client.step.FinishedStep;
import nz.co.fitnet.client.step.WelcomeStep;
import nz.co.fitnet.wizard.Wizard;
import nz.co.fitnet.wizard.models.BranchingPath;
import nz.co.fitnet.wizard.models.SimplePath;

public class CharacterBuilderWizard extends Wizard {

	private static final long serialVersionUID = 5264918634449585404L;

	/**
	 * Launch the application.
	 *
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public static void main(final String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		// EventQueue.invokeLater(() -> {
		// try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		final BranchingPath firstPath = new BranchingPath();

		final DwarfPath dwarfPath = new DwarfPath();
		// TODO other race paths

		firstPath.addStep(new WelcomeStep());
		firstPath.addStep(new ChooseRaceStep());
		firstPath.addBranch(dwarfPath, new DwarfCondition());
		// TODO other race branches

		final SimplePath lastPath = new SimplePath(new FinishedStep());

		dwarfPath.setNextPath(lastPath);

		final CharacterBuilderModel model = new CharacterBuilderModel(firstPath);

		final CharacterBuilderWizard window = new CharacterBuilderWizard(model);
		window.showInFrame("Character Builder");
		// } catch (final Exception e) {
		// e.printStackTrace();
		// }
		// });
	}

	/**
	 * Create the application.
	 */
	public CharacterBuilderWizard(final CharacterBuilderModel model) {
		super(model);
	}
}
