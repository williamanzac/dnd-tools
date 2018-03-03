package nz.co.fitnet.client.controls.trait;

import static java.text.MessageFormat.format;

import java.util.ResourceBundle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;

import nz.co.fitnet.characterGenerator.api.traits.AgeTrait;
import nz.co.fitnet.client.CharacterBuilderModel;
import nz.co.fitnet.client.RaceResourceBundle;

public class AgeTraitContentPanel extends JPanel {
	private static final long serialVersionUID = 1485062265996389108L;

	public AgeTraitContentPanel(final AgeTrait trait, final CharacterBuilderModel model) {
		final ResourceBundle bundle = RaceResourceBundle.getBundle(model.getRace());
		final JLabel lblDescription = new JLabel(format(bundle.getString("agetrait.description"),
				trait.getThing().getMaturity(), trait.getThing().getMax()));

		final JLabel lblNewLabel_1 = new JLabel("Character Age");

		final JSpinner age = new JSpinner();
		lblNewLabel_1.setLabelFor(age);
		age.setModel(new SpinnerNumberModel(trait.getThing().getMaturity(), trait.getThing().getMaturity(),
				trait.getThing().getMax(), 1));

		final JButton btnGenerate = new JButton("Generate");
		final GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(25)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnGenerate))
						.addComponent(lblDescription))
				.addContainerGap(241, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(23).addComponent(lblDescription)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnGenerate))
						.addContainerGap(238, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}
}
