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
 * $Id: HelpAction.java,v 1.3 2005/05/16 23:06:57 pietschy Exp $
 */

package nz.co.fitnet.wizard;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 *
 */
class HelpAction extends AbstractAction {
	/**
	 *
	 */
	private static final long serialVersionUID = 4960250970019852402L;
	private final Wizard wizard;
	private HelpBroker broker;

	protected HelpAction(final Wizard wizard) {
		super(I18n.getString("help.text"));
		this.wizard = wizard;
		putValue(Action.MNEMONIC_KEY, new Integer(I18n.getMnemonic("help.mnemonic")));
		wizard.addPropertyChangeListener("helpBroker", evt -> configureState());

		configureState();
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final HelpBroker helpBroker = wizard.getHelpBroker();

		if (helpBroker != null) {
			helpBroker.activateHelp(wizard, wizard.getModel());
		}
	}

	private void configureState() {
		setEnabled(wizard.getHelpBroker() != null);
	}
}
