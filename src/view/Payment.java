package view;

import controller.JarButton;
import controller.JarLabel;
import controller.JarTextField;
import net.miginfocom.swing.MigLayout;
import view.template.MasterFrame;
import javax.swing.JPanel;

/**
 * Created by CHANNATH on 29-Nov-2014.
 */
public class Payment extends MasterFrame {

    /**
     * declare variable
     */
    public JarLabel label[];
    public JarTextField textField[];
    public JarButton button[];
    public JPanel panelForm, panelButton;

    public Payment() {
        setTitle("Form Payment");
        setSize(460, 450);
        setLocationRelativeTo(this);
        setLayout(new MigLayout("inset 20"));

        /**
         * initialize components
         */
        panelForm = new JPanel(new MigLayout("inset 0"));
        panelButton = new JPanel(new MigLayout("inset 0"));
        label = new JarLabel[8];
        textField = new JarTextField[8];
        button = new JarButton[5];
        String textLabel[] = {"Total Amount:","Case Drawer:","Member Name:","Account Code",
                "Account Name:","Pay Amount:","Change:","Card Number:"};
        for (int i=0; i<textLabel.length; i++) {
            label[i] = new JarLabel(textLabel[i]);
            textField[i] = new JarTextField("");

            panelForm.add(label[i], "cell 0 "+(i+1)+"");
            if (i==4) {
                button[i] = new JarButton("Choose Account");
                panelForm.add(textField[i], "cell 1 "+i+", pushx, growx");
                panelForm.add(button[i], "cell 1 "+i+ ", pushx, growx");
            }
            panelForm.add(textField[i], "cell 1 "+(i+1)+", pushx, growx");
        }
        String textButton[] = {"Exchange","Split Account","Pay & Print","Close"};
        for (int i=0; i<textButton.length; i++) {
            button[i] = new JarButton(textButton[i]);
            panelButton.add(button[i], "cell "+i+" 0, pushx, growx");
        }
        getContentPane().add(panelForm, "pushx, growx, wrap");
        getContentPane().add(panelButton, "pushx, growx");
    }
}
