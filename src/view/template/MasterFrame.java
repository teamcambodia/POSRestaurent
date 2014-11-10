package view.template;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import style.JFrameStyle;

public class MasterFrame extends JFrame implements InterfaceJFrame {

	private static final long serialVersionUID = 723173745925716129L;

	public MasterFrame() {
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent evt) {
				frmOpened(evt);
			}
			
			@Override
			public void windowClosing(WindowEvent evt) {
				frmClosing(evt);
			}
		});
	}
	
	@Override
	public void frmOpened(WindowEvent evt) {
		
	}

	@Override
	public void frmClosing(WindowEvent evt) {
		int close = JOptionPane.showConfirmDialog(this, "Do you want to close "+getTitle()+"?", getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (close == JOptionPane.YES_OPTION) {
			beforeClose();
			System.exit(0);
		}
	}

	@Override
	public void beforeClose() {	}

	/**
	 * @declare variable
	 */
	public Dimension sizeScreen = Toolkit.getDefaultToolkit().getScreenSize();
	public int sizeWidth = sizeScreen.width, sizeHeight = sizeScreen.height;
	public JFrameStyle frmStyle = new JFrameStyle();
}
