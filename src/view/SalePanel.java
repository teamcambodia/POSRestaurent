package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JPopupMenu.Separator;
import javax.swing.KeyStroke;
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
	
	@Override
	public void frmOpened(WindowEvent evt) {
		super.frmOpened(evt);
		th.start();
	}

	private JPanel createTop() {
		panelToolBar = new JPanel(new MigLayout("inset 0"));
		panelToolBar.setPreferredSize(new Dimension(sizeWidth, 200));
//		panelToolBar.setBackground(new Color(67, 136, 204));
		JLabel lbl = new JLabel(new ImageIcon(getClass().getResource("/images/banner.jpg")));
		panelToolBar.add(lbl, "right, push, grow");
		/**
		 * create JPopup
		 */
		final JPopupMenu popUp = createMenuPopup();
		panelToolBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				showPopupMenu(evt, popUp);
			}
			
			@Override
			public void mouseReleased(MouseEvent evt) {
				showPopupMenu(evt, popUp);
			}
		});
		return panelToolBar;
	}
	
	@Override
	public void frmClosing(WindowEvent evt) {
		this.dispose();
		new MainForm().setVisible(true);
	}
	
	private JPanel createContent() {
		panelCenter = new JPanel(new MigLayout("inset 20"));
		/**
		 * 3 = number of row, 6 = number of column
		 * 20, 20 = Padding of Horizontal and Vertical
		 */
		JPanel panelMiddle = new JPanel(new GridLayout(3, 6, 20, 20)); 
		int num = 1;
		JButton btn[] = new JButton[18];
		for (int i=0; i<18; i++) {
			btn[i] = new JButton("Table "+(num++));
			btn[i].setFont(new Font("Ubuntu Mono", Font.PLAIN, 25));
			btn[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent evt) {
					addMouseClickButton(evt);
				}

				@Override
				public void mouseEntered(MouseEvent evt) {
					((JButton) evt.getSource()).setBackground(new Color(67, 136, 204).darker());
				}

				@Override
				public void mouseExited(MouseEvent evt) {
					((JButton) evt.getSource()).setBackground(getBackground());
				}
			});
			btn[i].addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent evt) {
					addKeyPressedButton(evt);
				}
			});
			panelMiddle.add(btn[i]);
		}
		panelCenter.add(panelMiddle, "push, grow");
		/**
		 * create JPopup
		 */
		final JPopupMenu popUp = createMenuPopup();
		panelCenter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				showPopupMenu(evt, popUp);
			}
			
			@Override
			public void mouseReleased(MouseEvent evt) {
				showPopupMenu(evt, popUp);
			}
		});
		return panelCenter;
	}
	
	private JPanel createStatusBar() {
		panelStatusBar = new JPanel(new MigLayout("inset 5"));
		lblStatusL = new JLabel("Current user: Developer");
		lblStatusR = new JLabel();
		lblStatusR.setHorizontalAlignment(JLabel.RIGHT);
		panelStatusBar.setBackground(new Color(240,240,240));
		panelStatusBar.add(lblStatusL, "cell 0 0, pushx, growx");
		panelStatusBar.add(lblStatusR, "cell 1 0, pushx, growx");
		frmStyle.formatStyle(new JLabel[]{lblStatusL,lblStatusR});
		return panelStatusBar;
	}
	
	Runnable run = new Runnable() {		
		@Override
		public void run() {
			do {
				long time = System.currentTimeMillis();
				DateFormat dfTime = new SimpleDateFormat("hh:mm:ss a");
				DateFormat dfDay = new SimpleDateFormat("EEEE, dd-MMM-yyy");
				lblStatusR.setText("Date: " + dfDay.format(time) + " " + dfTime.format(time));
			} while (true);			
		}
	};
	
	Thread th = new Thread(run);
	
	private void addMouseClickButton(MouseEvent me) {
		JButton btn = (JButton) me.getSource();
		JOptionPane.showMessageDialog(null, btn.getText().replace("Table ", ""));
	}
	
	private void addKeyPressedButton(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
			JButton btn = (JButton) ke.getSource();
			JOptionPane.showMessageDialog(null, btn.getText());
		}
	}
	
	private void showPopupMenu(MouseEvent evt, JPopupMenu popUp) {
		if (evt.isPopupTrigger()) {
			popUp.show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}
	
	private JPopupMenu createMenuPopup() {
		JPopupMenu popUp = new JPopupMenu();
		JMenuItem itemNew = new JMenuItem("Create New Item");
		itemNew.setMnemonic(KeyEvent.VK_I);
		itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		itemNew.getAccessibleContext().setAccessibleDescription("It will be created new item.");
		itemNew.setIcon(new ImageIcon(getClass().getResource("/images/new-item.png")));
		itemNew.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent evt) {
				new SalePanel().setVisible(true);
			}
		});
		popUp.add(itemNew);
		
		JMenuItem itemExit = new JMenuItem("Exit");
		itemExit.setMnemonic(KeyEvent.VK_X);
		itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
		itemExit.setIcon(new ImageIcon(getClass().getResource("/images/exit.png")));
		itemExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent evt) {
				frmClosing(null);				
			}
		});
		popUp.add(new Separator());
		popUp.add(itemExit);
		return popUp;
	}
	
	/**
	 * declare variable
	 */
	public JPanel panelToolBar, panelCenter, panelStatusBar;
    public JButton btnSalePanel,btnTable,btnMenu,btnReport;
    public JLabel lblStatusL,lblStatusR;
}
