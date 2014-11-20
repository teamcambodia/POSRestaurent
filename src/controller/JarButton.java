package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class JarButton extends JButton {

	private static final long serialVersionUID = -3825755188636465295L;
	public Font font = new Font("Ubuntu Mono", Font.PLAIN, 15);
	public Color bgColor = new Color(0, 119, 201);
	public Color fontColor = new Color(255, 255, 255);

	public JarButton(String title) {
		setText(title);
		setFont(font);
		setBackground(bgColor);
		setForeground(fontColor);
		setPreferredSize(new Dimension(this.getSize().width, 40));
		setFocusable(false);
		addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent evt) {
				actionClicked(evt);		
			}
		});
	}
	
	public void actionClicked(ActionEvent evt) {
		JButton button = (JButton) evt.getSource();
		JOptionPane.showMessageDialog(this, button.getText());
	}
}
