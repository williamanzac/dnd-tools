package nz.co.fitnet.client.step;

import java.awt.event.ItemEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import nz.co.fitnet.characterGenerator.api.Race;
import nz.co.fitnet.client.CharacterBuilderModel;
import nz.co.fitnet.wizard.WizardModel;

public class ChooseRaceStep extends CharacterBuilderStep {
	private static final long serialVersionUID = -4701689788706210468L;

	private CharacterBuilderModel model;

	public ChooseRaceStep() {
		super();
		setName("Choose Race");

		final JLabel lblSelectRace = new JLabel("Select Race:");

		final JComboBox<Race> comboBox = new JComboBox<>();
		comboBox.setModel(new RaceComboBoxModel());
		comboBox.setRenderer(new RaceListCellRenderer());
		comboBox.addItemListener(e -> {
			if (e.getStateChange() != ItemEvent.SELECTED) {
				return;
			}
			final Object[] selectedObjects = e.getItemSelectable().getSelectedObjects();
			if (selectedObjects == null || selectedObjects.length == 0) {
				return;
			}
			final Race selectedRace = (Race) selectedObjects[0];
			setRace(selectedRace);
		});
		lblSelectRace.setLabelFor(comboBox);
		final GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(6).addComponent(lblSelectRace).addGap(6)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(9).addComponent(lblSelectRace))
				.addGroup(groupLayout.createSequentialGroup().addGap(6).addComponent(comboBox,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));
		setLayout(groupLayout);
	}

	@Override
	public void init(final WizardModel model) {
		this.model = (CharacterBuilderModel) model;
	}

	private void setRace(final Race race) {
		model.setRace(race);
		setComplete(true);
	}
}
