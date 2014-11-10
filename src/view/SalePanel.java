package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import view.template.MasterFrame;

public class SalePanel extends MasterFrame {

	private static final long serialVersionUID = -5929018959677912695L;

	public SalePanel() {
		setTitle("Sale Panel");
		setSize(1100, 700);
		setLocation((sizeWidth - this.getWidth())/2, (sizeHeight - this.getHeight())/2);
		setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		getContentPane().add(createTop(), BorderLayout.NORTH);
		getContentPane().add(createContent(), BorderLayout.CENTER);
		getContentPane().add(createStatusBar(), BorderLayout.SOUTH);
	}

	private JPanel createTop() {
		panelToolBar = new JPanel();
		panelToolBar.setPreferredSize(new Dimension(sizeWidth, 100));
		panelToolBar.setBackground(new Color(67, 136, 204));
		return panelToolBar;
	}
	
	private JPanel createContent() {
		panelCenter = new JPanel();
		return panelCenter;
	}
	
	private JPanel createStatusBar() {
		panelStatusBar = new JPanel(new MigLayout("inset 5, debug"));
		lblStatusL = new JLabel("Current user: Developer");
		lblStatusR = new JLabel("Date: 08-Nov-2014 10:42 PM");
		panelStatusBar.setBackground(new Color(240,240,240));
		panelStatusBar.add(lblStatusL, "dock west, pushx, grow");
		panelStatusBar.add(lblStatusR, "dock east, pushx, grow");
		return panelStatusBar;
	}
	
	/**
	 * @declare variable
	 */
	public JPanel panelToolBar, panelCenter, panelStatusBar;
    public JButton btnSalePanel,btnTable,btnMenu,btnReport;
    public JLabel lblStatusL,lblStatusR;
}
