package nz.co.fitnet.client.controls;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChildPanel extends JPanel {
	private static final long serialVersionUID = 5745175035124739690L;

	public ChildPanel(final int id, final MouseListener ml) {
		setLayout(new BorderLayout());
		add(new ControlPanel(id, ml), "First");
		add(getContent(id));
	}

	private JPanel getContent(final int id) {
		final JPanel panel = new JPanel(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2, 2, 2, 2);
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		panel.add(new JLabel("Panel " + id + " Content"), gbc);
		return panel;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(300, 150);
	}
}
