package nz.co.fitnet.client.controls.trait;

import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.splitByCharacterTypeCamelCase;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import nz.co.fitnet.characterGenerator.api.traits.Trait;

public abstract class TraitPanel<T extends Trait<?>> extends JPanel {
	private static final long serialVersionUID = -8069842922449159389L;

	protected final T trait;
	private JPanel mainPanel;
	private final JLabel headerLabel;

	public TraitPanel(final T trait) {
		super(new BorderLayout());
		this.trait = trait;
		mainPanel = new JPanel();
		headerLabel = new JLabel(join(splitByCharacterTypeCamelCase(trait.getClass().getSimpleName()), " "));
		add(mainPanel, BorderLayout.CENTER);
		add(headerLabel, BorderLayout.NORTH);
		mainPanel.setVisible(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				toggleVisibility();
			}
		});
	}

	public JPanel getContent() {
		return mainPanel;
	}

	public void setContent(final JPanel panel) {
		remove(mainPanel);
		mainPanel = panel;
		add(mainPanel, BorderLayout.CENTER);
		mainPanel.setVisible(false);
	}

	private void toggleVisibility() {
		if (mainPanel.isShowing()) {
			mainPanel.setVisible(false);
		} else {
			mainPanel.setVisible(true);
		}

		validate();
	}
}
