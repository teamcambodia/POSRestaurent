package view.template;

import java.awt.event.WindowEvent;

public interface InterfaceJFrame {
	public void frmOpened(WindowEvent evt);
	public void frmClosing(WindowEvent evt);
	public void beforeClose();
}
