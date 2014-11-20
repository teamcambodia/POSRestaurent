package view;

import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Created by PONNIMOL on 11/15/2014.
 */
public class PaxNumber extends JDialog {
    
	private static final long serialVersionUID = 7056488304448756384L;
	
	public PaxNumber(){
        setTitle("Number of PAX");
        setSize(400,300);
        setLocationRelativeTo(this);
        setLayout(new MigLayout("inset 0, center"));
        getContentPane().add(PAX(),"cell 0 0, push,grow");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    public JPanel PAX(){
        JPanel panel = new JPanel(new MigLayout());
        JPanel panelTop = new JPanel(new MigLayout());
        //JPanel panelMiddle = new JPanel(new MigLayout());
        JPanel panelBottom = new JPanel(new MigLayout());

        /*
        Initialize Component
         */
        lblPax = new JLabel("Enter Nubmer of PAX");
        txtPax = new JTextField();
        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btnOK = new JButton("OK");
        btnCancel = new JButton("Cancel");
        btnBackSpace = new JButton("<-");


        /*
        Add Component to Panel
         */
        panelTop.add(lblPax,"cell 0 0,growy");
        panelTop.add(txtPax,"cell 1 0,push,grow");

        panelBottom.add(btn1,"cell 0 0,push,grow");
        panelBottom.add(btn2,"cell 1 0,push,grow");
        panelBottom.add(btn3,"cell 2 0,push,grow");
        panelBottom.add(btn4,"cell 0 1,push,grow");
        panelBottom.add(btn5,"cell 1 1,push,grow");
        panelBottom.add(btn6,"cell 2 1,push,grow");
        panelBottom.add(btnOK,"cell 3 0 1 2,pushx,grow");

        panelBottom.add(btn7,"cell 0 2,push,grow");
        panelBottom.add(btn8,"cell 1 2,push,grow");
        panelBottom.add(btn9,"cell 2 2,push,grow");
        panelBottom.add(btn0,"cell 0 3 2 1,push,grow");
        panelBottom.add(btnBackSpace,"cell 2 3,push,grow");
        panelBottom.add(btnCancel,"cell 3 2 1 2,pushx,grow");

        /*
        Event Button
         */
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtPax.setText(txtPax.getText()+"0");
            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtPax.setText(txtPax.getText() + "1");
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtPax.setText(txtPax.getText() + "2");
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtPax.setText(txtPax.getText() + "3");
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtPax.setText(txtPax.getText() + "4");
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtPax.setText(txtPax.getText() + "5");
            }
        });

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtPax.setText(txtPax.getText() + "6");
            }
        });

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtPax.setText(txtPax.getText()+"7");
            }
        });

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtPax.setText(txtPax.getText() + "8");
            }
        });

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtPax.setText(txtPax.getText()+"9");
            }
        });

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(btnOK,"OK");
            }
        });

        btnBackSpace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String pax = txtPax.getText();
                if(pax.length()>0){
                    pax= pax.substring(0,pax.length()-1);
                    txtPax.setText(pax);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(btnCancel,"Cancel");
            }
        });

        /* End Block Event Button */

        panel.add(panelTop,"cell 0 0, push, grow");
        //panel.add(panelMiddle,"cell 0 1, push, grow");
        panel.add(panelBottom,"cell 0 1, push, grow");
        return panel;
    }

    public static void main(String[] args) {
        try {
            UIManager.put("Synthetica.window.decoration",Boolean.FALSE);
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel");
        } catch (Exception e){}
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaxNumber().setVisible(true);
            }
        });
    }
    
    /**
     * declare variable
     */
    private JLabel lblPax;
    private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnOK,btnCancel,btnBackSpace;
    private JTextField txtPax;
}
