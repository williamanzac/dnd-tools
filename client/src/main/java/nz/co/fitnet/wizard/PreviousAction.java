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
 * $Id: PreviousAction.java,v 1.9 2005/05/16 23:06:58 pietschy Exp $
 */

package nz.co.fitnet.wizard;

import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

/**
 * Created by IntelliJ IDEA. User: andrewp Date: 7/06/2004 Time: 16:06:09 To change this template use Options | File
 * Templates.
 */
class PreviousAction extends WizardAction {
	/**
	 *
	 */
	private static final long serialVersionUID = -7080454690793842462L;

	protected PreviousAction(final Wizard model) {
		super("previous", model, new ArrowIcon(SwingConstants.WEST));
	}

	@Override
	public void doAction(final ActionEvent e) {
		getModel().previousStep();
	}

	@Override
	protected void updateState() {
		final WizardStep activeStep = getActiveStep();
		final boolean busy = activeStep != null && activeStep.isBusy();
		setEnabled(getModel().isPreviousAvailable() && !busy);
	}
}
