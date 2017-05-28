package GUI.components.panels;

import GUI.components.Panels;

import javax.swing.*;

public class ChangeStatus extends Panels {

    JLabel need_label, money_label, transportFrom_label, transportTo_label, help_label;

    JPanel panel_money, panel_transport, panel_help;

    JTextField money_textField, transportFrom_textField, transportTo_textField, help_textField;

    JButton transportAccept_button, helpAccept_button, moneyAccept_button;


    public ChangeStatus(int width, int height, int x, int y) {
        super(width, height, x, y);

        need_label = new JLabel("I need:");
        need_label.setSize(100, 30);
        need_label.setLocation(175, 60);
        this.add(need_label);

        String[] choice = new String[]{"Money", "Transport", "Help"};
        JComboBox cb = new JComboBox(choice);
        cb.setSize(100, 40);
        cb.setLocation(150, 100);
        cb.setVisible(true);
        cb.setSelectedIndex(1);
        cb.addActionListener(e -> {
            cb.getSelectedIndex();
            if (cb.getSelectedIndex() == 0) {
                if (panel_money != null) {
                    remove(panel_money);
                    repaint();
                }
                if (panel_transport != null) {
                    remove(panel_transport);
                    repaint();
                }
                if (panel_help != null) {
                    remove(panel_help);
                    repaint();
                }
                makePanelMoney();
                repaint();
            } else if (cb.getSelectedIndex() == 1) {
                if (panel_transport != null) {
                    remove(panel_transport);
                    repaint();
                }
                if (panel_money != null) {
                    remove(panel_money);
                    repaint();
                }
                if (panel_help != null) {
                    remove(panel_help);
                    repaint();
                }
                makePanelTransport();
                repaint();
            } else if (cb.getSelectedIndex() == 2) {
                if (panel_help != null) {
                    remove(panel_help);
                    repaint();
                }
                if (panel_transport != null) {
                    remove(panel_transport);
                    repaint();
                }
                if (panel_money != null) {
                    remove(panel_money);
                    repaint();
                }
                makePanelHelp();
                repaint();
            }
        });
        this.add(cb);


    }

    private void makePanelMoney() {

        panel_money = new JPanel();
        panel_money.setSize(400, 400);
        panel_money.setLocation(0, 200);
        panel_money.setLayout(null);

        money_label = new JLabel("How much do you need? (max. 100 zl)");
        money_label.setSize(220, 30);
        money_label.setLocation(90, 70);

        money_textField = new JTextField("");
        money_textField.setSize(200, 30);
        money_textField.setLocation(100, 100);

        moneyAccept_button = new JButton("Accept");
        moneyAccept_button.setSize(90, 40);
        moneyAccept_button.setLocation(150, 140);
        moneyAccept_button.addActionListener(e -> {
            //TODO get from textField into userDB
        });


        panel_money.add(moneyAccept_button);
        panel_money.add(money_label);
        panel_money.add(money_textField);

        panel_money.setVisible(true);
        this.add(panel_money);


    }


    private void makePanelTransport() {

        panel_transport = new JPanel();
        panel_transport.setSize(400, 400);
        panel_transport.setLocation(0, 200);
        panel_transport.setLayout(null);

        transportFrom_label = new JLabel("Where are you?");
        transportFrom_label.setSize(200, 30);
        transportFrom_label.setLocation(100, 70);

        transportTo_label = new JLabel("Where do you want to go?");
        transportTo_label.setSize(200, 30);
        transportTo_label.setLocation(100, 150);

        transportFrom_textField = new JTextField();
        transportFrom_textField.setSize(200, 30);
        transportFrom_textField.setLocation(100, 100);

        transportTo_textField = new JTextField();
        transportTo_textField.setSize(200, 30);
        transportTo_textField.setLocation(100, 180);

        transportAccept_button = new JButton("Accept");
        transportAccept_button.setSize(90, 40);
        transportAccept_button.setLocation(150, 240);
        transportAccept_button.addActionListener(e -> {
            //TODO get from textField into userDB
        });

        panel_transport.add(transportFrom_label);
        panel_transport.add(transportFrom_textField);
        panel_transport.add(transportTo_textField);
        panel_transport.add(transportTo_label);
        panel_transport.add(transportAccept_button);

        panel_transport.setVisible(true);
        this.add(panel_transport);


    }

    private void makePanelHelp() {

        panel_help = new JPanel();
        panel_help.setSize(400, 400);
        panel_help.setLocation(0, 200);
        panel_help.setLayout(null);

        help_label = new JLabel("What help do you need?");
        help_label.setSize(200, 30);
        help_label.setLocation(100, 70);

        help_textField = new JTextField();
        help_textField.setSize(200, 30);
        help_textField.setLocation(100, 100);

        helpAccept_button = new JButton("Accept");
        helpAccept_button.setSize(90, 40);
        helpAccept_button.setLocation(150, 140);
        helpAccept_button.addActionListener(e -> {

        });

        panel_help.add(help_label);
        panel_help.add(helpAccept_button);
        panel_help.add(help_textField);

        panel_help.setVisible(true);
        this.add(panel_help);


    }
}
