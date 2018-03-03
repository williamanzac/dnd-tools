package nz.co.fitnet.client.step;

import javax.swing.JLabel;

public class WelcomeStep extends CharacterBuilderStep {

	private static final long serialVersionUID = -6363811970233643194L;

	public WelcomeStep() {
		super();
		setComplete(true);
		setName("Welcome");

		final JLabel lblWelcome = new JLabel("Welcome");
		add(lblWelcome);
	}
}
