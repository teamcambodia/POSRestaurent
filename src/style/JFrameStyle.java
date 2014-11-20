package style;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.text.JTextComponent;

public class JFrameStyle {
	// declare variable
	public static File fontEnglish = new File("fonts/SEGOEUI.TTF");
	public static File fontKhmer = new File("fonts/KH-SIEMREAP_2.TTF");
	public static int fontSize = 16;
	
	
	public void setPositionCenterScreen(JFrame frame, int width, int height) {		
		frame.setLocation((width - frame.getWidth())/2, (height - frame.getHeight())/2);
	}
	
	/**
	 * @param com the component, type, size
	 * this method for embed font English
	 */
	public void formatFontEnglish(Component com, float size) {
		try {
			Font fontCreated = Font.createFont(Font.TRUETYPE_FONT, fontEnglish).deriveFont(size);
			com.setFont(fontCreated);
		} catch (FontFormatException e) {
			e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
	/**
	 * @param com the component, type, size
	 * this method for embed font Khmer
	 */
	public void formatFontKhmer(Component com, float size) {
		try {
			Font fontCreated = Font.createFont(Font.TRUETYPE_FONT, fontKhmer).deriveFont(size);
			com.setFont(fontCreated);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
	/**
	 * @param label
	 * this method for format style of JLabel default
	 */
	public void formatStyle(JLabel label[]) {
		for (JLabel lbl : label) {
			formatFontEnglish(lbl, fontSize);
		}
	}
	
	/**
	 * @param label
	 * this method for format style of JLabel with customize size
	 */
	public void formatStyle(JLabel label[], int size) {
		for (JLabel lbl : label) {
			formatFontEnglish(lbl, size);
		}
	}
	
	/**
	 * @param text
	 * this method for format style of JTextComponent default
	 */
	public void formatStyle(JTextComponent text[]) {
		for (JTextComponent txt : text) {
			formatFontEnglish(txt, fontSize);
			txt.setPreferredSize(new Dimension(txt.getSize().width, 35));
		}
	}
	
	/**
	 * @param text
	 * this method for format style of JTextComponent default with customize size
	 */
	public void formatStyle(JTextComponent text[], int size) {
		for (JTextComponent txt : text) {
			formatFontEnglish(txt, size);
			txt.setPreferredSize(new Dimension(txt.getSize().width, 35));
		}
	}
	
	/**
	 * @param cmb
	 * this method for format style of JComboBox default
	 */
	public void formatStyle(JComboBox<?> cmb[]) {
		for (JComboBox<?> combo : cmb) {
			this.formatFontEnglish(combo, fontSize);
			combo.setPreferredSize(new Dimension(combo.getSize().width, 35));
		}
	}
	
	/**
	 * @param button
	 * this method for format style of JButton default
	 */
	public void formatStyle(JButton button[]) {
		for (JButton btn : button) {
			this.formatFontEnglish(btn, fontSize);
			btn.setPreferredSize(new Dimension(btn.getSize().width, 35));
		}
	}
	
	/**
	 * @param button
	 * this method for format style of JButton with customize size
	 */
	public void formatStyle(JButton button[], int height) {
		for (JButton btn : button) {
			this.formatFontEnglish(btn, fontSize);
			btn.setPreferredSize(new Dimension(btn.getSize().width, 60));
		}
	}
	
	/**
	 * @param menu
	 * this method for format style of JMenu default
	 */
	public void formatStyle(JMenu menu[]) {
		for (JMenu mn : menu) {
			this.formatFontEnglish(mn, fontSize);
		}
	}
	
	/**
	 * @param menuItem
	 * this method for format style of JMenuItem default
	 */
	public void formatStyle(JMenuItem menuItem[]) {
		for (JMenuItem mi : menuItem) {
			this.formatFontEnglish(mi, fontSize);
		}
	}
	
	/**
	 * @param toolBar
	 * this method for format style of JMenuItem default
	 */
	public void formatStyle(JToolBar toolBar[]) {
		for (JToolBar tb : toolBar) {
			this.formatFontEnglish(tb, fontSize);
		}
	}
	
	/**
	 * @param btn
	 * this method for format style of ToolBar menu
	 */
	public void formatStyleToolBar(JButton btn[]) {
		for (JButton button : btn) {
			button.setPreferredSize(new Dimension(120, 50));
			this.formatFontEnglish(button, fontSize);
		}
	}
}
