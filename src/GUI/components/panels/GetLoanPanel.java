package GUI.components.panels;

import GUI.components.Panels;

import javax.swing.*;

public class GetLoanPanel extends Panels {

    JLabel getLoan_label;
    JTextField getLoan_textField;
    JButton getLoan_button;

    public GetLoanPanel(int width, int height, int x, int y) {
        super(width, height, x, y);

        getLoan_label = new JLabel("How much money do you need? (max. 100 zl)");
        getLoan_label.setSize(410, 30);
        getLoan_label.setLocation(30, 60);

        getLoan_textField = new JTextField();
        getLoan_textField.setSize(100, 30);
        getLoan_textField.setLocation(150, 100);

        getLoan_button = new JButton("Accept");
        getLoan_button.setSize(100, 30);
        getLoan_button.setLocation(150, 150);
        getLoan_button.addActionListener(e -> {
            //TODO get from User
            UserPanel userPanel = new UserPanel(350, 555, 25, 25);
            this.getParent().add(userPanel);
            this.getParent().repaint();
            this.getParent().remove(this);
        });


        this.add(getLoan_label);
        this.add(getLoan_textField);
        this.add(getLoan_button);

    }
}
