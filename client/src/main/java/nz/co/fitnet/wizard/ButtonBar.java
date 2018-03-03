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
 * $Id: ButtonBar.java,v 1.11 2005/05/22 07:13:28 pietschy Exp $
 */

package nz.co.fitnet.wizard;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * The component that holds the wizards buttons. Subclasses may override {@link #layoutButtons layoutButtons()} to
 * customize the look of the wizrad.
 *
 * @see Wizard#createButtonBar()
 * @see #layoutButtons
 */
public class ButtonBar extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 5590706324286081987L;
	public static final int RELATED_GAP = Wizard.BORDER_WIDTH / 2;
	public static final int UNRELATED_GAP = Wizard.BORDER_WIDTH;

	private final Wizard wizard;
	private final JButton lastButton;
	private final JButton nextButton;
	private final JButton previousButton;
	private final JButton finishButton;
	private final JButton cancelButton;
	private final JButton closeButton;
	private final JButton helpButton;

	protected Component lastButtonGap = Box.createHorizontalStrut(RELATED_GAP);
	protected Component helpButtonGap = Box.createHorizontalStrut(UNRELATED_GAP);

	public ButtonBar(final Wizard wizard) {
		this.wizard = wizard;
		this.wizard.getModel().addPropertyChangeListener("lastVisible", evt -> configureLastButton());

		this.wizard.addPropertyChangeListener("helpBroker", evt -> configureHelpButton());

		previousButton = new JButton(wizard.getPreviousAction());
		nextButton = new JButton(wizard.getNextAction());
		nextButton.setHorizontalTextPosition(SwingConstants.LEADING);
		lastButton = new JButton(wizard.getLastAction());
		finishButton = new JButton(wizard.getFinishAction());
		cancelButton = new JButton(wizard.getCancelAction());
		closeButton = new JButton(wizard.getCloseAction());
		helpButton = new JButton(wizard.getHelpAction());

		setBorder(BorderFactory.createEmptyBorder(Wizard.BORDER_WIDTH, Wizard.BORDER_WIDTH, Wizard.BORDER_WIDTH,
				Wizard.BORDER_WIDTH));

		showCloseButton(false);

		equalizeButtonWidths(helpButton, previousButton, nextButton, lastButton, finishButton, cancelButton,
				closeButton);
		layoutButtons(helpButton, previousButton, nextButton, lastButton, finishButton, cancelButton, closeButton);

		configureLastButton();
		configureHelpButton();
	}

	private void configureLastButton() {
		setLastVisible(wizard.getModel().isLastVisible());
	}

	private void configureHelpButton() {
		setHelpVisible(wizard.getHelpBroker() != null);
	}

	/**
	 * Called by the constructor to add the buttons to the button bar. This may be overridden to alter the layout of the
	 * bar. Subclasses that override this method are responsible for setting the layout manager using
	 * {@link #setLayout(LayoutManager)}.
	 *
	 * @param helpButton
	 *            the help button.
	 * @param previousButton
	 *            the previous button.
	 * @param nextButton
	 *            the next button
	 * @param lastButton
	 *            the last button
	 * @param finishButton
	 *            the showCloseButton button
	 * @param cancelButton
	 *            the cancel button.
	 * @param closeButton
	 *            the close button.
	 */
	protected void layoutButtons(final JButton helpButton, final JButton previousButton, final JButton nextButton,
			final JButton lastButton, final JButton finishButton, final JButton cancelButton,
			final JButton closeButton) {
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		add(helpButton);
		add(helpButtonGap);
		add(Box.createHorizontalGlue());
		add(previousButton);
		add(Box.createHorizontalStrut(RELATED_GAP));
		add(nextButton);
		add(lastButtonGap);
		add(lastButton);
		add(Box.createHorizontalStrut(RELATED_GAP));
		add(finishButton);
		add(Box.createHorizontalStrut(UNRELATED_GAP));
		add(cancelButton);
		add(closeButton);

	}

	/**
	 * Call prior to
	 * {@link #layoutButtons(javax.swing.JButton, javax.swing.JButton, javax.swing.JButton, javax.swing.JButton, javax.swing.JButton, javax.swing.JButton, javax.swing.JButton)}
	 * to make all the buttons the same width.
	 * 
	 * @param helpButton
	 * @param previousButton
	 * @param nextButton
	 * @param lastButton
	 * @param finishButton
	 * @param cancelButton
	 * @param closeButton
	 */
	protected void equalizeButtonWidths(final JButton helpButton, final JButton previousButton,
			final JButton nextButton, final JButton lastButton, final JButton finishButton, final JButton cancelButton,
			final JButton closeButton) {
		// make sure that every button has the same size
		final Dimension d = new Dimension();
		final JButton[] buttons = new JButton[] { helpButton, previousButton, nextButton, lastButton, finishButton,
				cancelButton, closeButton };
		for (final JButton button : buttons) {
			final Dimension buttonDim = button.getPreferredSize();
			if (buttonDim.width > d.width) {
				d.width = buttonDim.width;
			}
			if (buttonDim.height > d.height) {
				d.height = buttonDim.height;
			}
		}

		for (final JButton button : buttons) {
			button.setPreferredSize(d);
		}
	}

	public void showCloseButton(final boolean showClose) {
		previousButton.setVisible(!showClose);
		nextButton.setVisible(!showClose);
		lastButton.setVisible(!showClose);
		finishButton.setVisible(!showClose);
		cancelButton.setVisible(!showClose);
		closeButton.setVisible(showClose);
	}

	private void setLastVisible(final boolean visible) {
		lastButton.setVisible(visible);
		lastButtonGap.setVisible(visible);
		revalidate();
		repaint();
	}

	private void setHelpVisible(final boolean visible) {
		helpButton.setVisible(visible);
		helpButtonGap.setVisible(visible);
		revalidate();
		repaint();
	}
}
