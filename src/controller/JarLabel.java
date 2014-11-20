package controller;

import java.awt.Font;
import javax.swing.JLabel;

public class JarLabel extends JLabel {

	private static final long serialVersionUID = -1853107512012681210L;
	private Font font = new Font("Segoe UI", Font.PLAIN, 15);
	
	public JarLabel(String title) {
		setText(title);
		setFont(font);
	}
}
