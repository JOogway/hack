package GUI.components.panels;

import GUI.components.Panels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class UserPanel extends Panels {
    double debtValue = 0;
    JLabel userNameLabel, appDebitLabel, friendDebitLabel;
    JButton changeStatusButton, addFriendsButton, newAppLoanButton;
    JPanel panelOfNeed;

    public UserPanel(int width, int height, int x, int y) {
        super(width, height, x, y);
        userNameLabel = new JLabel("Joseph Stalin");//TODO get userName from User
        userNameLabel.setLocation(10, 10);
        userNameLabel.setSize(150, 30);
        userNameLabel.setVisible(true);

        appDebitLabel = new JLabel("You have a debt of: " + debtValue);//TODO get debtValue from User
        appDebitLabel.setLocation(10, 50);
        appDebitLabel.setSize(400, 30);
        appDebitLabel.setVisible(true);

        friendDebitLabel = new JLabel("You have unfinished transactions with: ");//TODO get users that owes current user or user owes to or
        friendDebitLabel.setLocation(10, 90);
        friendDebitLabel.setSize(400, 30);
        friendDebitLabel.setVisible(true);

        changeStatusButton = new JButton("Make new help request");
        changeStatusButton.setLocation(10, 150);
        changeStatusButton.setSize(325, 50);
        changeStatusButton.setVisible(true);
        changeStatusButton.setBackground(new Color(132, 215, 118, 156));
        changeStatusButton.addActionListener(e -> {
            ChangeStatus changeStatus = new ChangeStatus(350, 555, 25, 25);
            this.getParent().add(changeStatus);
            this.getParent().repaint();
            this.getParent().remove(this);
        });

        addFriendsButton = new JButton("Add new contact");
        addFriendsButton.setLocation(10, 210);
        addFriendsButton.setSize(325, 50);
        addFriendsButton.setVisible(true);
        addFriendsButton.setBackground(new Color(138, 169, 225, 252));
        addFriendsButton.addActionListener(e -> {
            JFrame addFriendFrame = new JFrame("Add friend");
            addFriendFrame.setSize(350, 200);
            addFriendFrame.setLocationRelativeTo(null);
            addFriendFrame.setLayout(null);

            JTextField tel_number = new JTextField();
            tel_number.setSize(250, 70);
            tel_number.setFont(new Font("Times New Roman", Font.BOLD, 20));
            tel_number.setLocation(50, 10);
            tel_number.setBorder(BorderFactory.createTitledBorder("Input friend number"));
            tel_number.setVisible(true);

            JButton tryFind = new JButton("Add");
            tryFind.setSize(100, 50);
            tryFind.setLocation(125, 120);
            tryFind.setVisible(true);
            tryFind.addActionListener(e1 -> {
                //TODO z okna do bazy -> query, czy jest użytkownik o danym numerze, jeśli tak, dodaj go do znajomych

                addFriendFrame.getParent().remove(addFriendFrame);
            });
            addFriendFrame.add(tel_number);
            addFriendFrame.add(tryFind);
            addFriendFrame.setVisible(true);
        });

        newAppLoanButton = new JButton("Add funds from TITLE");
        newAppLoanButton.setLocation(10, 270);
        newAppLoanButton.setSize(325, 50);
        newAppLoanButton.setVisible(true);
        newAppLoanButton.setBackground(new Color(255, 220, 26, 134));
        newAppLoanButton.addActionListener(e -> {
            GetLoanPanel getLoanPanel = new GetLoanPanel(350, 555, 25, 25);
            this.getParent().add(getLoanPanel);
            this.getParent().repaint();
            this.getParent().remove(this);

        });

        JButton logout = new JButton("Logout");
        logout.setSize(100, 30);
        logout.setLocation(30, 510);
        logout.setVisible(true);
        logout.addActionListener(e -> {

        });

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
        this.add(logout);
        this.repaint();

    }

    public void modifyNameLabel(String nameOfUser) {
        userNameLabel.setText(nameOfUser);
    }

    public void modifyAppDebitLabel(int valueOfDebt) {
        appDebitLabel.setText(String.valueOf(valueOfDebt));
    }
}