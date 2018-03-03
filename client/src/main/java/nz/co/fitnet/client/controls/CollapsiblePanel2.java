package nz.co.fitnet.client.controls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CollapsiblePanel2 extends JPanel {
	private static final long serialVersionUID = 5653796556959839212L;

	private boolean selected;
	JPanel contentPanel_;
	HeaderPanel headerPanel_;

	private class HeaderPanel extends JPanel implements MouseListener {
		private static final long serialVersionUID = 5501237754147916283L;

		String text_;
		Font font;
		BufferedImage open, closed;
		final int OFFSET = 30, PAD = 5;

		public HeaderPanel(final String text) {
			addMouseListener(this);
			text_ = text;
			font = new Font("sans-serif", Font.PLAIN, 12);
			setPreferredSize(new Dimension(200, 20));
			final int w = getWidth();
			final int h = getHeight();
		}

		@Override
		protected void paintComponent(final Graphics g) {
			super.paintComponent(g);
			final Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			final int h = getHeight();
			/*
			 * if (selected) g2.drawImage(open, PAD, 0, h, h, this); else g2.drawImage(closed, PAD, 0, h, h, this);
			 */ // Uncomment once you have your own images
			g2.setFont(font);
			final FontRenderContext frc = g2.getFontRenderContext();
			final LineMetrics lm = font.getLineMetrics(text_, frc);
			final float height = lm.getAscent() + lm.getDescent();
			final float x = OFFSET;
			final float y = (h + height) / 2 - lm.getDescent();
			g2.drawString(text_, x, y);
		}

		@Override
		public void mouseClicked(final MouseEvent e) {
			toggleSelection();
		}

		@Override
		public void mouseEntered(final MouseEvent e) {
		}

		@Override
		public void mouseExited(final MouseEvent e) {
		}

		@Override
		public void mousePressed(final MouseEvent e) {
		}

		@Override
		public void mouseReleased(final MouseEvent e) {
		}
	}

	public CollapsiblePanel2(final String text, final JPanel panel) {
		super(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(1, 3, 0, 3);
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		selected = false;
		headerPanel_ = new HeaderPanel(text);

		setBackground(new Color(200, 200, 220));
		contentPanel_ = panel;

		add(headerPanel_, gbc);
		add(contentPanel_, gbc);
		contentPanel_.setVisible(false);

		final JLabel padding = new JLabel();
		gbc.weighty = 1.0;
		add(padding, gbc);
	}

	public void toggleSelection() {
		selected = !selected;

		if (contentPanel_.isShowing()) {
			contentPanel_.setVisible(false);
		} else {
			contentPanel_.setVisible(true);
		}

		validate();

		headerPanel_.repaint();
	}
}
