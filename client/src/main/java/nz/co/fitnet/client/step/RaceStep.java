package nz.co.fitnet.client.step;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.lang.reflect.ParameterizedType;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.characterGenerator.api.traits.Trait;
import nz.co.fitnet.client.CharacterBuilderModel;
import nz.co.fitnet.client.RaceResourceBundle;
import nz.co.fitnet.client.controls.trait.TraitPanel;
import nz.co.fitnet.client.controls.trait.TraitPanels;
import nz.co.fitnet.wizard.WizardModel;

public abstract class RaceStep<R extends Race> extends CharacterBuilderStep {
	private static final long serialVersionUID = -172855986064762025L;

	private final Class<R> clazz;
	private CharacterBuilderModel model;
	private final JPanel panel = new JPanel();
	protected final RaceResourceBundle bundle;

	@SuppressWarnings("unchecked")
	public RaceStep() {
		super();
		clazz = (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		bundle = RaceResourceBundle.getBundle(clazz);
		setName(clazz.getSimpleName());
		setLayout(new BorderLayout(0, 0));

		final JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		final GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);

		add(scrollPane);
	}

	public Class<R> getClazz() {
		return clazz;
	}

	@Override
	public void init(final WizardModel model) {
		super.init(model);
		this.model = (CharacterBuilderModel) model;
	}

	@Override
	public void prepare() {
		super.prepare();

		int count = 0;
		for (final Trait<?> t : model.getRace().getTraits()) {
			final TraitPanel<?> traitPanel = TraitPanels.panelFor(t, model);
			if (traitPanel == null) {
				continue;
			}
			final GridBagConstraints gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = 0;
			gbc.gridy = count;
			panel.add(traitPanel, gbc);
			count++;
		}
	}

}
