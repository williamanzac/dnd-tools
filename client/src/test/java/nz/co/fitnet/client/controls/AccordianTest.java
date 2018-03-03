package nz.co.fitnet.client.controls;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class AccordianTest {
	private JPanel getContent() {
		final JPanel panel = new JPanel(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();
		panel.add(new AccordianPanel().getPanel(), gbc);
		return panel;
	}

	public static void main(final String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		final JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(new AccordianTest().getContent());
		f.setSize(400, 400);
		f.setLocation(200, 200);
		f.setVisible(true);
	}
}
