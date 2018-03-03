/**
 * Wizard Framework
 * Copyright 2004 - 2005 Andrew Pietsch
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * $Id: FinishAction.java,v 1.10 2005/05/22 07:13:29 pietschy Exp $
 */

package nz.co.fitnet.wizard;

import java.awt.event.ActionEvent;

/**
 * Created by IntelliJ IDEA. User: andrewp Date: 7/06/2004 Time: 16:06:09 To change this template use Options | File
 * Templates.
 */
class FinishAction extends WizardAction {
	/**
	 *
	 */
	private static final long serialVersionUID = -3977695215056521545L;

	protected FinishAction(final Wizard model) {
		super("finish", model);
	}

	@Override
	public void doAction(final ActionEvent e) throws InvalidStateException {
		final WizardStep finishStep = getModel().getActiveStep();
		finishStep.applyState();
		final int defaultCloseOperation = getWizard().getDefaultExitMode();

		// todo (ap): should really consider making this more OO.
		if (defaultCloseOperation == Wizard.EXIT_ON_FINISH) {
			getWizard().getCloseAction().actionPerformed(e);
		} else if (defaultCloseOperation == Wizard.EXIT_ON_CLOSE) {
			getWizard().showCloseButton();
		} else {
			throw new InvalidStateException("Invalid finish operaion: " + defaultCloseOperation);
		}
	}

	@Override
	protected void updateState() {
		final WizardStep activeStep = getActiveStep();
		setEnabled(activeStep != null && getModel().isLastStep(activeStep) && activeStep.isComplete()
				&& !activeStep.isBusy());
	}
}
