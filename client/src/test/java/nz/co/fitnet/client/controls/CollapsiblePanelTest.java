package nz.co.fitnet.client.controls;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class CollapsiblePanelTest {

	public static void main(final String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		final JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
		CollapsiblePanel panel = new CollapsiblePanel();
		panel.add(new JLabel("test"));
		f.getContentPane().add(panel);
		panel = new CollapsiblePanel();
		panel.add(new JLabel("test"));
		f.getContentPane().add(panel);
		panel = new CollapsiblePanel();
		panel.add(new JLabel("test"));
		f.getContentPane().add(panel);
		f.setSize(400, 400);
		f.setLocation(200, 200);
		f.setVisible(true);
	}
}
