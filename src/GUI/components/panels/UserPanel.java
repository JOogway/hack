package GUI.components.panels;

import GUI.components.Panels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class UserPanel extends Panels {
    double debitValue = 0;
    JLabel userNameLabel, appDebitLabel, friendDebitLabel;
    JButton changeStatusButton, addFriendsButton, newAppLoanButton;
    JPanel panelOfNeed;

    public UserPanel(int width, int height, int x, int y) {
        super(width, height, x, y);
        userNameLabel = new JLabel("Joseph Stalin");//TODO get userName from DB
        userNameLabel.setLocation(10, 10);
        userNameLabel.setSize(150, 30);
        userNameLabel.setVisible(true);

        appDebitLabel = new JLabel("You have a debt of: " + debitValue);
        appDebitLabel.setLocation(10, 50);
        appDebitLabel.setSize(400, 30);
        appDebitLabel.setVisible(true);

        friendDebitLabel = new JLabel("You have unfinished transactions with: ");
        friendDebitLabel.setLocation(10, 90);
        friendDebitLabel.setSize(400, 30);
        friendDebitLabel.setVisible(true);

        changeStatusButton = new JButton("Make new help request");
        changeStatusButton.setLocation(10, 150);
        changeStatusButton.setSize(325, 50);
        changeStatusButton.setVisible(true);
        changeStatusButton.setBackground(new Color(132, 215, 118, 156));

        addFriendsButton = new JButton("Add new contact");
        addFriendsButton.setLocation(10, 210);
        addFriendsButton.setSize(325, 50);
        addFriendsButton.setVisible(true);
        addFriendsButton.setBackground(new Color(138, 169, 225, 252));

        newAppLoanButton = new JButton("Add funds from TITLE");
        newAppLoanButton.setLocation(10, 270);
        newAppLoanButton.setSize(325, 50);
        newAppLoanButton.setVisible(true);
        newAppLoanButton.setBackground(new Color(255, 220, 26, 134));

        panelOfNeed = new JPanel();
        panelOfNeed.setLocation(10, 340);
        panelOfNeed.setSize(325, 180);
        panelOfNeed.setBorder(BorderFactory.createTitledBorder("Friends in need: "));
        panelOfNeed.setVisible(true);
        panelOfNeed.setLayout(new BorderLayout());
        String[] columnNames = {"imie ", "nazwisko ", "email ", "tel"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        ArrayList<String[]> usersCollection = new ArrayList<>();
        panelOfNeed.add(table.getTableHeader(), BorderLayout.PAGE_START);
        panelOfNeed.add(table, BorderLayout.CENTER);
        panelOfNeed.repaint();

        this.add(userNameLabel);
        this.add(appDebitLabel);
        this.add(friendDebitLabel);
        this.add(changeStatusButton);
        this.add(addFriendsButton);
        this.add(newAppLoanButton);
        this.add(panelOfNeed);
        this.repaint();

    }

    public void modifyNameLabel(String nameOfUser) {
        userNameLabel.setText(nameOfUser);
    }

    public void modifyAppDebitLabel(int valueOfDebt) {
        appDebitLabel.setText(String.valueOf(valueOfDebt));
    }
}