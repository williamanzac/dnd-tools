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
 * $Id: WizardFrameCloser.java,v 1.1 2005/05/16 23:06:59 pietschy Exp $
 */
package nz.co.fitnet.wizard;

import java.awt.Window;

/**
 * This class implements {@link WizardListener} and is used to hide and dispose frames when a wizard has been completed
 * or canceled.
 */
public class WizardFrameCloser implements WizardListener {
	private final Window window;
	private final Wizard wizard;

	/**
	 * Creates a new closer that monitors the specified wizard and closes the parent frame.
	 *
	 * @param wizard
	 * @param window
	 */
	public static void bind(final Wizard wizard, final Window window) {
		new WizardFrameCloser(wizard, window);
	}

	/**
	 * Constructs a new closer for the specified wizard in the specified window.
	 */
	private WizardFrameCloser(final Wizard wizard, final Window window) {
		this.window = window;
		this.wizard = wizard;
		this.wizard.addWizardListener(this);
	}

	@Override
	public void wizardClosed(final WizardEvent e) {
		closeWindow();
	}

	@Override
	public void wizardCancelled(final WizardEvent e) {
		closeWindow();
	}

	public void closeWindow() {
		window.setVisible(false);
		window.dispose();
		wizard.removeWizardListener(WizardFrameCloser.this);
	}
}
