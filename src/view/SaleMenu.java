package view;

import view.template.MasterFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nimol on 11/21/14.
 */
public class SaleMenu extends MasterFrame {

    public SaleMenu() {
        setTitle("Sale Menu");
        setSize(1100, 700);
        setLocation((sizeWidth - this.getWidth()) / 2, (sizeHeight - this.getHeight()) / 2);
        setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

    }


    public static void main(String[] args) {
        try {
            UIManager.put("Synthetica.window.decoration", Boolean.FALSE);
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel");
        } catch (Exception e) {
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SaleMenu().setVisible(true);
            }
        });
    }
}
