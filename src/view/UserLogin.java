package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import model.ConnectionMySQL;
import net.miginfocom.swing.MigLayout;
import view.template.MasterFrame;

public class UserLogin extends MasterFrame {

	private static final long serialVersionUID = -2629617272401661541L;

	public UserLogin() {
		setTitle("Login");
		setSize(450, 380);
		setLocationRelativeTo(this);
		setLayout(new MigLayout("inset 20, center"));
		getContentPane().add(userLogin(), "cell 0 0, push, grow");
	}
	
	private JPanel userLogin() {
		JPanel panel = new JPanel(new MigLayout());
		/**
		 * initialize components
		 */
		lblPOS = new JLabel("POS");
		lblMS = new JLabel("Management System");
		lblUsername = new JLabel("Username:");
		lblPassword = new JLabel("Password:");
		lblOutlet = new JLabel("Outlet:");
		txtUsername = new JTextField(15);
		txtPassword = new JPasswordField(15);
		cmbOutlet = new JComboBox<Object>();
		btnLogin = new JButton("Login");
		btnCancel = new JButton("Cancel");

		/**
		 * add component into panel
		 */
		panel.add(lblPOS, "cell 0 0 2 0, center");
		panel.add(lblMS, "cell 0 1 2 0, center");
		panel.add(lblUsername, "cell 0 2, gaptop 30");
		panel.add(txtUsername, "cell 1 2, pushx, growx");
		panel.add(lblPassword, "cell 0 3, gaptop 2");
		panel.add(txtPassword, "cell 1 3, pushx, growx, gaptop 2");
		panel.add(lblOutlet, "cell 0 4, gaptop 2");
		panel.add(cmbOutlet, "cell 1 4, pushx, growx, gaptop 2");
		panel.add(btnLogin, "cell 1 5, gaptop 10, right");
		panel.add(btnCancel, "cell 1 5, right");
		
		/**
		 * add text into combo 
		 */
		cmbOutlet.addItem("Default");
		
		/* format style */
		frmStyle.formatStyle(new JLabel[]{lblPOS}, 30);
		frmStyle.formatStyle(new JLabel[]{lblMS}, 20);
		frmStyle.formatStyle(new JLabel[]{lblUsername,lblPassword,lblOutlet});
		frmStyle.formatStyle(new JTextComponent[]{txtUsername,txtPassword});
		frmStyle.formatStyle(new JComboBox<?>[]{cmbOutlet});
		frmStyle.formatStyle(new JButton[]{btnLogin,btnCancel});
		/* end of format style */
		
		/**
		 * implement action listener
		 */
		btnLogin.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnLoginActionPerformed(evt);				
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent evt) {
				frmClosing(null);				
			}
		});
		return panel;
	}
	
	public void btnLoginActionPerformed(ActionEvent evt) {
		String username = txtUsername.getText();
		String password = String.valueOf(txtPassword.getPassword());
		if (username.trim().length()==0) {
			JOptionPane.showMessageDialog(this, "Please input username.");
			txtUsername.grabFocus();
		} else if (password.trim().length()==0) {
			JOptionPane.showMessageDialog(this, "Please input password.");
			txtPassword.grabFocus();
		} else {
			try {
				String query = "SELECT * FROM user WHERE user_name=? AND user_pass=?";
				PreparedStatement ps = ConnectionMySQL.dataConn.prepareStatement(query);
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if (rs.first()) {
					JOptionPane.showMessageDialog(null, "Success ful.");
					this.dispose();
					new MainForm().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Not found.");
				}
				rs.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void frmOpened(WindowEvent evt) {
		frmStyle.setPositionCenterScreen(this, sizeWidth, sizeHeight);
		try {
			new ConnectionMySQL("localhost","pharmacy192.168.0.20","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// testing command
		try {
			UIManager.put("Synthetica.window.decoration", Boolean.FALSE);
			UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel");
		} catch (Exception e) {}
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				new UserLogin().setVisible(true);
			}
		});
	}
	
	/**
	 * declare variable
	 */
	public JLabel lblPOS,lblMS,lblUsername,lblPassword,lblOutlet;
	public JTextField txtUsername;
	public JPasswordField txtPassword;
	public JComboBox<Object> cmbOutlet;
	public JButton btnLogin, btnCancel;
}
