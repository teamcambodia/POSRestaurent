package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class JarTable extends JTable {

	private static final long serialVersionUID = 7636237936797838909L;
	private Color colorRowOdd = getBackground();
	private Color colorRowEven = getBackground();
	private Color colorRowSelected = getBackground();
	
	public void setAlignmentColumnCenter(int index) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        getColumnModel().getColumn(index).setCellRenderer(centerRenderer);
	}
	
	public void setAlignmentColumnRight(int index) {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        getColumnModel().getColumn(index).setCellRenderer(rightRenderer);
	}
	
	public void setWidthColumn(int index, int width) {
		getColumnModel().getColumn(index).setPreferredWidth(width);
	}
	
	public void addComponent(int index, JTextField txt) {
		getColumnModel().getColumn(index).setCellEditor(new DefaultCellEditor(txt));
	}
	
	public void addComponent(int index, JComboBox<String> comb) {
		getColumnModel().getColumn(index).setCellEditor(new DefaultCellEditor(comb));
	}
	
	public void addComponent(int index, JCheckBox cb) {
		getColumnModel().getColumn(index).setCellEditor(new DefaultCellEditor(cb));
	}
	
	public void setBackgroundTableHeader(Color color) {
		this.getTableHeader().setBackground(color);
	}
	
	public void setForegroundTableHeader(Color color) {
		this.getTableHeader().setForeground(color);
	}
	
	public void setFontTableHeader(Font font) {
		this.getTableHeader().setFont(font);
	}
	
	public void setColorRowOdd(Color colorRowOdd) {
		this.colorRowOdd = colorRowOdd;
	}
	
	public Color getColorRowOdd() {
		return colorRowOdd;
	}
	
	public void setColorRowEven(Color colorRowEven) {
		this.colorRowEven = colorRowEven;
	}
	
	public Color getColorRowEven() {
		return colorRowEven;
	}
	
	public void setColorRowSelected(Color colorRowSelected) {
		this.colorRowSelected = colorRowSelected;
	}
	
	public Color getColorRowSelected() {
		return colorRowSelected;
	}
	
	public Component prepareRenderer(TableCellRenderer ren, int r, int c) {
		Component com = super.prepareRenderer(ren, r, c);
		if (r%2==0&&!isCellSelected(r, c)) {
			com.setBackground(colorRowOdd);
		} else if (!isCellSelected(r, c)) {
			com.setBackground(colorRowEven);
		} else {
			com.setBackground(colorRowSelected);
		}
		return com;
	}
}
