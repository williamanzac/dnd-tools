package nz.co.fitnet.client.controls;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class CollapsiblePanel extends JPanel {
	private static final long serialVersionUID = -1550033911266289147L;

	private String title = "Title";
	private final TitledBorder border;

	public CollapsiblePanel() {
		border = BorderFactory.createTitledBorder(title);
		setBorder(border);
		final BorderLayout borderLayout = new BorderLayout();
		setLayout(borderLayout);
		addMouseListener(mouseListener);
	}

	private final MouseListener mouseListener = new MouseAdapter() {
		@Override
		public void mouseClicked(final MouseEvent e) {
			toggleVisibility();
		}
	};

	private final ComponentListener contentComponentListener = new ComponentAdapter() {
		@Override
		public void componentShown(final ComponentEvent e) {
			updateBorderTitle();
		}

		@Override
		public void componentHidden(final ComponentEvent e) {
			updateBorderTitle();
		}
	};

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		firePropertyChange("title", this.title, this.title = title);
	}

	@Override
	public Component add(final Component comp) {
		comp.addComponentListener(contentComponentListener);
		final Component r = super.add(comp);
		updateBorderTitle();
		return r;
	}

	@Override
	public Component add(final String name, final Component comp) {
		comp.addComponentListener(contentComponentListener);
		final Component r = super.add(name, comp);
		updateBorderTitle();
		return r;
	}

	@Override
	public Component add(final Component comp, final int index) {
		comp.addComponentListener(contentComponentListener);
		final Component r = super.add(comp, index);
		updateBorderTitle();
		return r;
	}

	@Override
	public void add(final Component comp, final Object constraints) {
		comp.addComponentListener(contentComponentListener);
		super.add(comp, constraints);
		updateBorderTitle();
	}

	@Override
	public void add(final Component comp, final Object constraints, final int index) {
		comp.addComponentListener(contentComponentListener);
		super.add(comp, constraints, index);
		updateBorderTitle();
	}

	@Override
	public void remove(final int index) {
		final Component comp = getComponent(index);
		comp.removeComponentListener(contentComponentListener);
		super.remove(index);
	}

	@Override
	public void remove(final Component comp) {
		comp.removeComponentListener(contentComponentListener);
		super.remove(comp);
	}

	@Override
	public void removeAll() {
		for (final Component c : getComponents()) {
			c.removeComponentListener(contentComponentListener);
		}
		super.removeAll();
	}

	protected void toggleVisibility() {
		toggleVisibility(hasInvisibleComponent());
	}

	protected void toggleVisibility(final boolean visible) {
		for (final Component c : getComponents()) {
			c.setVisible(visible);
		}
		updateBorderTitle();
	}

	protected void updateBorderTitle() {
		String arrow = "";
		if (getComponentCount() > 0) {
			arrow = hasInvisibleComponent() ? "▽" : "△";
		}
		border.setTitle(title + " " + arrow);
		repaint();
	}

	protected final boolean hasInvisibleComponent() {
		for (final Component c : getComponents()) {
			if (!c.isVisible()) {
				return true;
			}
		}
		return false;
	}
}