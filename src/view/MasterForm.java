package view;

import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.lang.Override;
import java.lang.Runnable;

public class MasterForm extends JFrame {

    public MasterForm() {
        setTitle("Master Form");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(100,200);
        setLocationRelativeTo(this);
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