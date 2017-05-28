package GUI.components.panels;

import GUI.components.Panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ZB on 2017-05-27.
 */
public class CreateAcountPanel extends Panels {

    private JLabel account_label;
    private JTextField firstName_textField, lastName_textField, loginField, phone_textField, email_textField, pesel_textField, address_textField, cardNumber_textField, bankAccountNumber_textField, date_textField, cvvNumber_textField;
    private JPasswordField passwordField;

    public CreateAcountPanel(int width, int height, int x, int y) {
        super(width, height, x, y);
        this.setBackground(new Color(225, 225, 225));

        account_label = new JLabel("Create Account");
        account_label.setSize(150, 30);
        account_label.setLocation(140, 5);

        firstName_textField = new JTextField("");
        firstName_textField.setSize(150, 40);
        firstName_textField.setLocation(30, 30);
        firstName_textField.setBorder(BorderFactory.createTitledBorder("First name:"));

        loginField = new JTextField("");
        loginField.setSize(150, 40);
        loginField.setLocation(190, 30);
        loginField.setBorder(BorderFactory.createTitledBorder("Login:"));

        passwordField = new JPasswordField("");
        passwordField.setSize(150, 40);
        passwordField.setLocation(190, 75);
        passwordField.setBorder(BorderFactory.createTitledBorder("Set Password"));

        lastName_textField = new JTextField("");
        lastName_textField.setSize(150, 40);
        lastName_textField.setLocation(30, 75);
        lastName_textField.setBorder(BorderFactory.createTitledBorder("Last name:"));

        phone_textField = new JTextField("");
        phone_textField.setSize(150, 40);
        phone_textField.setLocation(30, 120);
        phone_textField.setBorder(BorderFactory.createTitledBorder("Phone number"));

        email_textField = new JTextField("");
        email_textField.setSize(150, 40);
        email_textField.setLocation(30, 165);
        email_textField.setBorder(BorderFactory.createTitledBorder("E-mail:"));

        pesel_textField = new JTextField("");
        pesel_textField.setSize(150, 40);
        pesel_textField.setLocation(30, 210);
        pesel_textField.setBorder(BorderFactory.createTitledBorder("PESEL"));

        address_textField = new JTextField("");
        address_textField.setSize(150, 40);
        address_textField.setLocation(30, 255);
        address_textField.setBorder(BorderFactory.createTitledBorder("Adress: "));

        JPanel cardPanel = new JPanel();
        cardPanel.setSize(300, 200);
        cardPanel.setLocation(30, 300);
        cardPanel.setBorder(BorderFactory.createTitledBorder("Add new Card:"));
        cardPanel.setVisible(true);

        cardNumber_textField = new JTextField("");
        cardNumber_textField.setSize(150, 30);
        cardNumber_textField.setLocation(130, 20);

        JLabel cardNumber_label = new JLabel("Card Number:");
        cardNumber_label.setSize(120, 30);
        cardNumber_label.setLocation(10, 20);
        cardNumber_label.setVisible(true);

        bankAccountNumber_textField = new JTextField("");
        bankAccountNumber_textField.setSize(150, 30);
        bankAccountNumber_textField.setLocation(130, 70);

        JLabel bankAccountNumber_label = new JLabel("Acount number:");
        bankAccountNumber_label.setSize(120, 30);
        bankAccountNumber_label.setLocation(10, 70);
        bankAccountNumber_label.setVisible(true);

        date_textField = new JTextField("");
        date_textField.setSize(150, 30);
        date_textField.setLocation(130, 120);

        JLabel expirationDate_label = new JLabel("Expiration date:");
        expirationDate_label.setSize(120, 30);
        expirationDate_label.setLocation(10, 120);
        expirationDate_label.setVisible(true);

        cvvNumber_textField = new JTextField("");
        cvvNumber_textField.setSize(150, 30);
        cvvNumber_textField.setLocation(130, 160);

        JLabel cvvNumber_label = new JLabel("CVV number:");
        cvvNumber_label.setSize(120, 30);
        cvvNumber_label.setLocation(10, 160);
        cvvNumber_label.setVisible(true);

        cardPanel.add(cardNumber_label);
        cardPanel.add(cardNumber_textField);
        cardPanel.add(bankAccountNumber_label);
        cardPanel.add(bankAccountNumber_textField);
        cardPanel.add(expirationDate_label);
        cardPanel.add(date_textField);
        cardPanel.add(cvvNumber_label);
        cardPanel.add(cvvNumber_textField);

        JButton accept = new JButton("Accept");
        accept.setSize(100, 30);
        accept.setLocation(230, 510);
        accept.setVisible(true);
        accept.addActionListener(e -> {
            //TODO get data into DB
            LoginPanel lp = new LoginPanel(350, 530, 25, 25);
            this.getParent().add(lp);
            this.getParent().repaint();
            this.getParent().remove(this);
        });

        JButton back = new JButton("Back");
        back.setSize(100, 30);
        back.setLocation(30, 510);
        back.setVisible(true);
        back.addActionListener(e -> {
            LoginPanel lp = new LoginPanel(350, 530, 25, 25);
            this.getParent().add(lp);
            this.getParent().repaint();
            this.getParent().remove(this);
        });

        this.add(account_label);
        this.add(firstName_textField);
        this.add(loginField);
        this.add(passwordField);
        this.add(lastName_textField);
        this.add(phone_textField);
        this.add(email_textField);
        this.add(pesel_textField);
        this.add(address_textField);
        this.add(cardPanel);
        this.add(accept);
        this.add(back);
    }
}