package nz.co.fitnet.client.controls;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AccordianPanel extends JPanel {
	private static final long serialVersionUID = -3160156611419863736L;

	boolean movingComponents = false;
	int visibleIndex = 3;

	public AccordianPanel() {
		setLayout(null);
		// Add children and compute prefSize.
		final int childCount = 4;
		Dimension d = new Dimension();
		int h = 0;
		for (int j = 0; j < childCount; j++) {
			final ChildPanel child = new ChildPanel(j + 1, ml);
			add(child);
			d = child.getPreferredSize();
			child.setBounds(0, h, d.width, d.height);
			if (j < childCount - 1) {
				h += ControlPanel.HEIGHT;
			}
		}
		h += d.height;
		setPreferredSize(new Dimension(d.width, h));
		// Set z-order for children.
		setZOrder();
	}

	private void setZOrder() {
		final Component[] c = getComponents();
		for (int j = 0; j < c.length - 1; j++) {
			setComponentZOrder(c[j], c.length - 1 - j);
		}
	}

	private void setChildVisible(final int indexToOpen) {
		// If visibleIndex < indexToOpen, components at
		// [visibleIndex+1 down to indexToOpen] move up.
		// If visibleIndex > indexToOpen, components at
		// [indexToOpen+1 up to visibleIndex] move down.
		// Collect indices of components that will move
		// and determine the distance/direction to move.
		int[] indices = new int[0];
		int travelLimit = 0;
		if (visibleIndex < indexToOpen) {
			travelLimit = ControlPanel.HEIGHT - getComponent(visibleIndex).getHeight();
			final int n = indexToOpen - visibleIndex;
			indices = new int[n];
			for (int j = visibleIndex, k = 0; j < indexToOpen; j++, k++) {
				indices[k] = j + 1;
			}
		} else if (visibleIndex > indexToOpen) {
			travelLimit = getComponent(visibleIndex).getHeight() - ControlPanel.HEIGHT;
			final int n = visibleIndex - indexToOpen;
			indices = new int[n];
			for (int j = indexToOpen, k = 0; j < visibleIndex; j++, k++) {
				indices[k] = j + 1;
			}
		}
		movePanels(indices, travelLimit);
		visibleIndex = indexToOpen;
	}

	private void movePanels(final int[] indices, final int travel) {
		movingComponents = true;
		final Thread thread = new Thread(() -> {
			final Component[] c = getComponents();
			final int limit = travel > 0 ? travel : 0;
			int count = travel > 0 ? 0 : travel;
			final int dy = travel > 0 ? 8 : -8;
			System.out.println("-----travel=" + travel);
			System.out.println("--count---=" + count);
			System.out.println("-limit-" + limit);

			while (count < limit) {
				try {
					Thread.sleep(25);
				} catch (final InterruptedException e) {
					System.out.println("interrupted");
					break;
				}
				for (final int indice : indices) {

					// The z-order reversed the order returned
					// by getComponents. Adjust the indices to
					// get the correct components to relocate.
					final int index = c.length - 1 - indice;
					final Point p = c[index].getLocation();
					p.y += dy;
					c[index].setLocation(p.x, p.y);
					System.out.println("x=" + p.x + "y=" + p.y);
				}
				repaint();
				count = count + 8;
			}
			movingComponents = false;
		});
		thread.setPriority(Thread.NORM_PRIORITY);
		thread.start();
	}

	private final MouseListener ml = new MouseAdapter() {
		@Override
		public void mousePressed(final MouseEvent e) {
			final int index = ((ControlPanel) e.getSource()).id - 1;
			if (!movingComponents) {
				setChildVisible(index);
			}
		}
	};

	public JPanel getPanel() {
		final JPanel panel = new JPanel(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();
		panel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panel.add(this, gbc);
		return panel;
	}
}
