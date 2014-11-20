package controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JarDefaultTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1651733059563822226L;
	private boolean b = false;

	/**
	 * this method for remove all data on Model
	 */
	public void removeAllRows() {
		while (this.getRowCount() > 0) {
			this.removeRow(0);
		}
	}
	
	/**
	 * @param table
	 * this method for remove value from selected row
	 */
	public void removeSelectedRows(JTable table) {
		int index[];
		index = table.getSelectedRows();
		int j = 0;
		for (int i=0; i<index.length; i++) {
			this.removeRow(index[i] - j);
			j++;
		}
	}
	
	public boolean isCellEditable(int r, int c) {
		return b;
	}
	
	public boolean isCellEditable() {
		return b;
	}
	
	public void setCellEditable(boolean b) {
		this.b = b;
	}
}
