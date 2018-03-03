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
 * $Id: DefaultTitleComponent.java,v 1.4 2005/05/16 23:06:57 pietschy Exp $
 */

package nz.co.fitnet.wizard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This class displays the details of the current {@link WizardStep}. It displays the steps name, summary and icon.
 * During construction, the title component iterates over all of the wizards steps to determine its appropriate size.
 */
public class DefaultTitleComponent extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = -4439887125649107224L;

	private static final Color COLOR_GRAY_230 = new Color(230, 230, 230);

	private final JLabel title;
	private final JEditorPane summary;
	private final JLabel iconLabel;

	private final WizardModel model;

	private boolean gradientBackground = false;
	private Color fadeColor = COLOR_GRAY_230;

	protected DefaultTitleComponent(final Wizard wizard) {
		model = wizard.getModel();

		setLayout(new BorderLayout());

		final JPanel p = new JPanel(new BorderLayout());
		p.setBackground(Color.WHITE);
		title = new JLabel();
		title.setFont(title.getFont().deriveFont(Font.BOLD));

		summary = new HTMLPane(false);
		summary.setFont(title.getFont().deriveFont(Font.PLAIN));
		summary.setEditable(false);
		summary.setEnabled(false);
		summary.setForeground(Color.BLACK);
		summary.setDisabledTextColor(Color.BLACK);
		summary.setBorder(
				BorderFactory.createEmptyBorder(Wizard.BORDER_WIDTH / 2, Wizard.BORDER_WIDTH, 0, Wizard.BORDER_WIDTH));

		// lock in the preferred size
		summary.setText("<html>Blah</html>");
		final Dimension preferredSize = summary.getPreferredSize();
		preferredSize.width = 0;
		preferredSize.height *= 2;
		summary.setPreferredSize(preferredSize);

		// determine the largest icon size.
		int maxIconHeight = 0;
		int maxIconWidth = 0;
		for (final Iterator iter = model.stepIterator(); iter.hasNext();) {
			final Icon icon = ((WizardStep) iter.next()).getIcon();
			if (icon != null) {
				maxIconWidth = Math.max(maxIconWidth, icon.getIconWidth());
				maxIconHeight = Math.max(maxIconHeight, icon.getIconHeight());
			}
		}

		iconLabel = new JLabel();
		final Dimension maximumSize = new Dimension(maxIconWidth, maxIconHeight);
		iconLabel.setMaximumSize(maximumSize);
		iconLabel.setPreferredSize(maximumSize);
		if (iconLabel.getComponentOrientation().isLeftToRight()) {
			iconLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		} else {
			iconLabel.setHorizontalAlignment(SwingConstants.LEFT);
		}
		iconLabel.setVerticalAlignment(SwingConstants.CENTER);

		p.add(title, BorderLayout.PAGE_START);
		p.add(summary, BorderLayout.CENTER);
		p.setOpaque(false);

		add(p, BorderLayout.CENTER);
		add(iconLabel, BorderLayout.LINE_END);

		setOpaque(true);
		setBackground(Color.WHITE);

		setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(), BorderFactory.createEmptyBorder(
						Wizard.BORDER_WIDTH, Wizard.BORDER_WIDTH, Wizard.BORDER_WIDTH, Wizard.BORDER_WIDTH)));

		model.addPropertyChangeListener(evt -> {
			if (evt.getPropertyName().equals("activeStep")) {
				final WizardStep activeStep = model.getActiveStep();
				title.setText(activeStep.getName());
				summary.setText(activeStep.getSummary());
				iconLabel.setIcon(activeStep.getIcon());
			}
		});
	}

	/**
	 * Checks if the title is using a gradient background. Subclasses can control the appearance of the gradient by
	 * overriding {@link #prepareGradient()}.
	 *
	 * @return <tt>true</tt> if the background will use a gradient, <tt>false</tt> if the background will be painted
	 *         using the background color.
	 * @see #prepareGradient()
	 */
	public boolean isGradientBackground() {
		return gradientBackground;
	}

	/**
	 * Configures the title to use a gradient background. Subclasses can control the appearance of the gradient by
	 * overriding {@link #prepareGradient()}.
	 *
	 * @param gradientBackground
	 *            <tt>true</tt> to paint a gradient background.
	 * @see #prepareGradient()
	 */
	public void setGradientBackground(final boolean gradientBackground) {
		this.gradientBackground = gradientBackground;
	}

	@Override
	protected void paintComponent(final Graphics g) {
		if (isGradientBackground()) {
			final Paint gradientPaint = prepareGradient();

			final Graphics2D g2 = (Graphics2D) g;
			final Paint oldPaint = g2.getPaint();

			g2.setPaint(gradientPaint);
			g2.fillRect(0, 0, getWidth(), getHeight());
			g2.setPaint(oldPaint);
		} else {
			super.paintComponent(g);
		}
	}

	/**
	 * Prepares the background paint for the component. By default it returns a {@link java.awt.GradientPaint} as per
	 * the following.
	 * 
	 * <pre>
	 * new GradientPaint(getWidth()/2, 0, Color.WHITE,
	 *                   getWidth(), getHeight(), COLOR_GRAY_230))
	 * </pre>
	 *
	 * If this method returns null, the component will be filled with the current backgrount color.
	 *
	 * @return the background paint to use for this component or <tt>null</tt> to use the default background color.
	 */
	protected Paint prepareGradient() {
		return new GradientPaint(getWidth() / 2, 0, getBackground(), getWidth(), getHeight(), getFadeColor());
	}

	/**
	 * Gets the color the gradient will fade to. By default this is gray(230,230,230).
	 * 
	 * @return the second color of the gradient. The first color is the background of the component.
	 */
	private Color getFadeColor() {
		return fadeColor;
	}

	/**
	 * Sets the color the gradient will fade to.
	 * 
	 * @param fadeColor
	 *            the second color of the gradient. The first color is the background of the component.
	 */
	public void setFadeColor(final Color fadeColor) {
		this.fadeColor = fadeColor;
	}

}
