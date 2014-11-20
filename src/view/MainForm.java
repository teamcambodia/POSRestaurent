package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import net.miginfocom.swing.MigLayout;
import view.template.MasterFrame;

public class MainForm extends MasterFrame {

	private static final long serialVersionUID = -3155516309403288519L;

	public MainForm() {
		setTitle("POS Restaurant Management System");
		setSize(1100, 700);
		setLocation((sizeWidth - this.getWidth())/2, (sizeHeight - this.getHeight())/2);
		setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setJMenuBar(createMenuBar());
		getContentPane().add(createToolBar(), BorderLayout.NORTH);
		getContentPane().add(createContent(), BorderLayout.CENTER);
		getContentPane().add(createStatusBar(), BorderLayout.SOUTH);
	}
	
	public JMenuBar createMenuBar() { 
        //Create the menu bar.
        menuBar = new JMenuBar();
        //Build the File Menu.
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuFile.getAccessibleContext().setAccessibleDescription("Dealing with Files");
        menuBar.add(menuFile);
 
        //a group of JMenuItems
        mFilePro = new JMenuItem("New Project...");
        mFilePro.setMnemonic(KeyEvent.VK_P);
        mFilePro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        mFilePro.getAccessibleContext().setAccessibleDescription("New Project");
        menuFile.add(mFilePro);
 
        mFileNew = new JMenuItem("New File...");
        mFileNew.setMnemonic(KeyEvent.VK_F);
        menuFile.add(mFileNew);
 
        menuFile.addSeparator();
        mFileExit = new JMenuItem("Exit");
        mFileExit.setMnemonic(KeyEvent.VK_X);
        menuFile.add(mFileExit);
        
        //Build Management menu in the menu bar.
        menuManagement = new JMenu("Management");
        menuManagement.setMnemonic(KeyEvent.VK_M);
        menuManagement.getAccessibleContext().setAccessibleDescription("Management");
        menuBar.add(menuManagement);
        
        //Build Setup menu in the menu bar.
        menuSetup = new JMenu("Setup");
        menuSetup.setMnemonic(KeyEvent.VK_U);
        menuSetup.getAccessibleContext().setAccessibleDescription("Setup");
        menuBar.add(menuSetup);
        
        //Build Window menu in the menu bar.
        menuWindow = new JMenu("Window");
        menuWindow.setMnemonic(KeyEvent.VK_W);
        menuWindow.getAccessibleContext().setAccessibleDescription("Window");
        menuBar.add(menuWindow);
        
        /* format style */
        frmStyle.formatStyle(new JMenu[]{menuFile,menuManagement,menuSetup,menuWindow});
        frmStyle.formatStyle(new JMenuItem[]{mFilePro,mFileNew,mFileExit});
        /* end of format style */
        
        /**
         * implement action on menu
         */
        mFileExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				frmClosing(null);				
			}
		});
        return menuBar;
    }

	@Override
	public void frmClosing(WindowEvent evt) {
		this.dispose();
		new SalePanel().setVisible(true);
	}
	
	public JPanel createToolBar() {
		panelToolBar = new JPanel(new MigLayout("inset 0"));
		btnSalePanel = new JButton("Sale Panel");
		panelToolBar.setBackground(new Color(240, 240, 240));
		btnSalePanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sale Panel clicked");
            }
        });
 
        btnTable = new JButton("Table");
        btnTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Table clicked");
            }
        });
 
        btnMenu = new JButton("Menu");
        btnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Menu clicked");
            }
        });
        
        btnReport = new JButton("Report");
        btnReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Report clicked");
            }
        });
        
        /**
         * add button into toolBar
         */
        panelToolBar.add(btnSalePanel);
        panelToolBar.add(btnTable);
        panelToolBar.add(btnMenu);
        panelToolBar.add(btnReport);
        
        /* format style */
        JButton button[] = {btnSalePanel,btnTable,btnMenu,btnReport};
        frmStyle.formatStyleToolBar(button);
        /* end of format style */
		return panelToolBar;
	}
	
	public JPanel createContent() {
		panelCenter = new JPanel(new MigLayout());
		panelCenter.setBackground(new Color(237, 233, 227));
		return panelCenter;
	}
	
	public JPanel createStatusBar() {
		panelStatusBar = new JPanel(new MigLayout("inset 5"));
		lblStatus = new JLabel("Current user: Developer");
		panelStatusBar.setBackground(new Color(240,240,240));
		panelStatusBar.add(lblStatus);
		frmStyle.formatStyle(new JLabel[]{lblStatus});
		return panelStatusBar;
	}
	
	/**
	 * declare variable
	 */
	public JMenuBar menuBar;
	public JPanel panelToolBar, panelCenter, panelStatusBar;
    public JMenu menuFile,menuManagement,menuSetup,menuWindow,subMenuFile;
    public JMenuItem mFilePro,mFileNew,mFileExit;
    public JButton btnSalePanel,btnTable,btnMenu,btnReport;
    public JLabel lblStatus;
}
