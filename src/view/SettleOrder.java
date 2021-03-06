package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import view.template.MasterFrame;
import controller.GlobalMethod;
import controller.JarButton;
import controller.JarDefaultTableModel;
import controller.JarLabel;
import controller.JarTable;
import controller.JarTextField;

public class SettleOrder extends MasterFrame {

	private static final long serialVersionUID = 1096247142339773722L;
	private JarButton button[];
	private JarTextField text[];
	private JarLabel label[];
	private JarTable table;
	private JScrollPane spPane;
	private JarDefaultTableModel model;
	private GlobalMethod method;

	public SettleOrder() {
		setTitle("Settle Order");
		setSize(1098, 550);
		setLocation((sizeWidth - this.getWidth())/2, (sizeHeight - this.getHeight())/2);
		setResizable(false);
		setLayout(new MigLayout());
		add(panelLeft(), "cell 0 0 1 2, push, grow");
		add(panelRightTop(), "cell 1 0, push, grow");
		add(panelRightBottom(), "cell 1 1, push, grow");
	}
	
	public JPanel panelLeft() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder(null, "Item List Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", Font.PLAIN, 15), Color.BLACK));
		table = new JarTable();
		model = new JarDefaultTableModel();
		spPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		model.setColumnIdentifiers(new String[]{"Menu Name","Qty","Price"});
		table.setModel(model);
		table.setRowHeight(35);
		table.getTableHeader().setReorderingAllowed(false);
		table.setColorRowOdd(new Color(228, 228, 228));
		table.setColorRowEven(new Color(255, 255, 255));
		table.setColorRowSelected(new Color(0, 119, 201));
		table.setWidthColumn(0, 300);
		table.setAlignmentColumnCenter(1);
		model.addRow(new Object[]{"Cocacola",2,"0.50$"});
		model.addRow(new Object[]{"Fanta",3,"0.70$"});
		panel.add(spPane, "Center");
		return panel;
	}
	
	public JPanel panelRightTop() {
		JPanel panel = new JPanel(new MigLayout("inset 15"));
		panel.setBorder(BorderFactory.createTitledBorder(null, "Payment Panel", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", Font.PLAIN, 15), Color.BLACK));
		label = new JarLabel[4];
		panel.add(label[0] = new JarLabel("ID:"), "cell 0 0");
		panel.add(label[1] = new JarLabel("Name:"), "cell 0 1");
		panel.add(label[2] = new JarLabel("Register Date:"), "cell 0 2");
		panel.add(label[3] = new JarLabel("Discount:"), "cell 0 3");
		text = new JarTextField[4];
		panel.add(text[0] = new JarTextField(""), "cell 1 0, pushx, growx");
		panel.add(text[1] = new JarTextField(""), "cell 1 1, pushx, growx");
		panel.add(text[2] = new JarTextField(""), "cell 1 2, pushx, growx");
		panel.add(text[3] = new JarTextField(""), "cell 1 3, pushx, growx");
		button = new JarButton[5];
		JPanel panelButton = new JPanel(new MigLayout("inset 0"));
		panelButton.add(button[0] = new JarButton("Enterainment"), "cell 0 0, pushx, growx");
		panelButton.add(button[1] = new JarButton("Choose Member"), "cell 1 0, pushx, growx");
		panelButton.add(button[2] = new JarButton("Choose Management"), "cell 2 0, pushx, growx");
		panelButton.add(button[3] = new JarButton("Choose Staff"), "cell 3 0, pushx, growx");
		panelButton.add(button[4] = new JarButton("Reset"), "cell 4 0, pushx, growx");
		panel.add(panelButton, "cell 0 4 2 1, center, growx");
		method = new GlobalMethod();
		method.inputNumberWithDotOnlyOne(text[3]);
		return panel;
	}
	
	public JPanel panelRightBottom() {
		JPanel panel = new JPanel(new MigLayout("inset 15"));
		panel.setBorder(BorderFactory.createTitledBorder(null, "Payment Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", Font.PLAIN, 15), Color.BLACK));
		label = new JarLabel[4];
		panel.add(label[0] = new JarLabel("Sub Total:"), "cell 0 0");
		panel.add(label[1] = new JarLabel("Discount 0.00%:"), "cell 0 1");
		panel.add(label[2] = new JarLabel("Service Change:"), "cell 0 2");
		panel.add(label[3] = new JarLabel("Total:"), "cell 0 3");
		text = new JarTextField[4];
		panel.add(text[0] = new JarTextField(""), "cell 1 0, pushx, growx");
		panel.add(text[1] = new JarTextField(""), "cell 1 1, pushx, growx");
		panel.add(text[2] = new JarTextField(""), "cell 1 2, pushx, growx");
		panel.add(text[3] = new JarTextField(""), "cell 1 3, pushx, growx");
		button = new JarButton[4];
		JPanel panelButton = new JPanel(new MigLayout("inset 0"));
		panelButton.add(button[0] = new JarButton("Print"), "cell 0 0, pushx, growx");
		panelButton.add(button[1] = new JarButton("Discount"), "cell 1 0, pushx, growx");
		panelButton.add(button[2] = new JarButton("Settle"), "cell 2 0, pushx, growx");
		panelButton.add(button[3] = new JarButton("Close"), "cell 3 0, pushx, growx");
		panel.add(panelButton, "cell 0 4 2 1, center, growx");
		method = new GlobalMethod();
		method.inputNumberWithDotOnlyOne(text[0]);
		method.inputNumberWithDotOnlyOne(text[1]);
		method.inputNumberWithDotOnlyOne(text[2]);
		method.inputNumberWithDotOnlyOne(text[3]);
		return panel;
	}
	
	public static void main(String[] args) {
		try {
			UIManager.put("Synthetica.window.decoration", Boolean.FALSE);
			UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel");
//			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {			
			@Override
			public void run() {
				new SettleOrder().setVisible(true);
			}
		});
	}

}
