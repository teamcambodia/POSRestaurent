package controller;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;

public class JarTextField extends JTextField {

	private static final long serialVersionUID = -1853107512012681210L;
	private Font font = new Font("Ubuntu Mono", Font.PLAIN, 18);
	
	public JarTextField(String title) {
		setText(title);
		setColumns(20);
		setPreferredSize(new Dimension(this.getSize().width, 30));
		setFont(font);
	}
}
