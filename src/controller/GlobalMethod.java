package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

public class GlobalMethod {

	/**
	 * @param com the component
	 * this method for checking input only number
	 */
	public void inputNumberOnly(JComponent com) {
		com.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char ch = evt.getKeyChar();
				if (!(Character.isDigit(ch)) || ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
		});
	}
	
	/**
	 * @param st
	 * @return true or false
	 * this method for check dot
	 */
	public boolean checkingDot(String st) {
		boolean b = false;
		char ch[] = st.toCharArray();
		for (int i=0; i<st.length(); i++) {
			if (ch[i] == '.') {
				b = true;
				return b;
			}
		}
		return b;
	}
	
	/**
	 * @param com the component
	 * this method for checking input only number and dot only one
	 */
	public void inputNumberWithDotOnlyOne(JComponent com) {
		com.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char ch = evt.getKeyChar();
				if (ch == '.') {
					JTextComponent txt = (JTextComponent) evt.getSource();
					String st = txt.getText();
					if (st.equals("")) {
						txt.setText("0");
					} else if (checkingDot(st)) {
						evt.consume();
					}
				} else if (!(Character.isDigit(ch)) || ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
		});
	}
}
