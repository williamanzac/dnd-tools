package nz.co.fitnet.client.controls;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ControlPanel extends JPanel {
	private static final long serialVersionUID = -8267330941116995231L;

	int id;
	JLabel titleLabel;
	Color c1 = new Color(200, 180, 180);
	Color c2 = new Color(200, 220, 220);
	Color fontFg = Color.blue;
	Color rolloverFg = Color.red;
	public final static int HEIGHT = 45;

	public ControlPanel(final int id, final MouseListener ml) {
		this.id = id;
		setLayout(new BorderLayout());
		add(titleLabel = new JLabel("Panel " + id, SwingConstants.CENTER));
		titleLabel.setForeground(fontFg);
		final Dimension d = getPreferredSize();
		d.height = HEIGHT;
		setPreferredSize(d);
		addMouseListener(ml);
		addMouseListener(listener);
	}

	@Override
	protected void paintComponent(final Graphics g) {
		final int w = getWidth();
		final Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(new GradientPaint(w / 2, 0, c1, w / 2, HEIGHT / 2, c2));
		g2.fillRect(0, 0, w, HEIGHT);
	}

	private final MouseListener listener = new MouseAdapter() {
		@Override
		public void mouseEntered(final MouseEvent e) {
			titleLabel.setForeground(rolloverFg);
		}

		@Override
		public void mouseExited(final MouseEvent e) {
			titleLabel.setForeground(fontFg);
		}
	};
}
