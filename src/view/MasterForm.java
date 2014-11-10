package view;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.lang.Runnable;

public class MasterForm extends JFrame {

	private static final long serialVersionUID = -4605512809806631176L;

	public MasterForm() {
        // comment top testing
        setTitle("Master Form");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500,200);
        setLocationRelativeTo(this);
        // testing
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MasterForm().setVisible(true);
            }
        });
    }
}