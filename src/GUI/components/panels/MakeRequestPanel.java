package GUI.components.panels;

import GUI.components.Panels;

import javax.swing.*;

/**
 * Created by oogway on 28.05.17.
 */
public class MakeRequestPanel extends Panels {
    public MakeRequestPanel(int width, int height, int x, int y) {
        super(width, height, x, y);
        JLabel howMuchNeed_label = new JLabel("How much do you need?");
        howMuchNeed_label.setLocation(50, 50);
        howMuchNeed_label.setSize(200, 40);
        howMuchNeed_label.setVisible(true);

        JTextField moneyRequested_field = new JTextField();
        moneyRequested_field.setLocation(50, 100);
        moneyRequested_field.setSize(200, 40);
        moneyRequested_field.setVisible(true);

        JLabel pln = new JLabel("PLN");
        pln.setLocation(260, 100);
        pln.setSize(100, 40);
        pln.setVisible(true);

        this.add(howMuchNeed_label);
        this.add(moneyRequested_field);
        this.add(pln);

    }
}
