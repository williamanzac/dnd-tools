package nz.co.fitnet.client.controls;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class CollapsiblePanel2Test {

	public static void main(final String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		final CollapsiblePanel2 cp = new CollapsiblePanel2("test", buildPanel());

		final JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(new JScrollPane(cp));
		f.setSize(360, 500);
		f.setLocation(200, 100);
		f.setVisible(true);
	}

	public static JPanel buildPanel() {
		final GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2, 1, 2, 1);
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		final JPanel p1 = new JPanel(new GridBagLayout());
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		p1.add(new JButton("button 1"), gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		p1.add(new JButton("button 2"), gbc);
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		p1.add(new JButton("button 3"), gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		p1.add(new JButton("button 4"), gbc);

		return p1;
	}
}
