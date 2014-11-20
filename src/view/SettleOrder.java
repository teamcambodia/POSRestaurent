package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import view.template.MasterFrame;
import controller.JarButton;
import controller.JarLabel;
import controller.JarTextField;

public class SettleOrder extends MasterFrame {

	private static final long serialVersionUID = 1096247142339773722L;
	private JarButton button[];
	private JarTextField text[];
	private JarLabel label[];
	private JTable table;
	private JScrollPane spPane;
	private DefaultTableModel model;

	public SettleOrder() {
		setTitle("Settle Order");
		setSize(1098, 500);
		setLocation((sizeWidth - this.getWidth())/2, (sizeHeight - this.getHeight())/2);
		setResizable(false);
		setLayout(new MigLayout());
		add(panelLeft(), "cell 0 0 1 2, pushx, growx");
		add(panelRightTop(), "cell 1 0, pushx, growx");
		add(panelRightBottom(), "cell 1 1, pushx, growx");
	}
	
	public JPanel panelLeft() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder(null, "Item List Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", Font.PLAIN, 15), Color.BLACK));
		table = new JTable();
		model = new DefaultTableModel();
		spPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		model.setColumnIdentifiers(new String[]{"Menu Name","Qty","Price"});
		table.setModel(model);
		table.setRowHeight(35);
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
		return panel;
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
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
