package GUI.components.panels;

import GUI.components.Panels;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by oogway on 27.05.17.
 */
public class LoginPanel extends Panels {
    JLabel title = new JLabel("APP TITLE");
    JLabel login_label = new JLabel("Login");
    JTextField loginField = new JTextField();
    JLabel pass_label = new JLabel("Password");
    JPasswordField passField = new JPasswordField();
    JButton logInApp = new JButton("Sign in");
    JButton signUpApp = new JButton("Sign up");

    public LoginPanel(int width, int height, int x, int y) {
        super(width, height, x, y);

        title.setLocation(100, 10);
        title.setSize(150, 100);
        title.setVisible(true);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        login_label.setLocation(30, 100);
        login_label.setSize(60, 30);
        login_label.setVisible(true);

        loginField.setLocation(100, 100);
        loginField.setSize(200, 30);
        loginField.setVisible(true);

        pass_label.setLocation(10, 140);
        pass_label.setSize(100, 30);
        pass_label.setVisible(true);

        passField.setLocation(100, 140);
        passField.setSize(200, 30);
        passField.setVisible(true);

        logInApp.setLocation(100, 340);
        logInApp.setSize(150, 50);
        logInApp.setVisible(true);

        logInApp.addActionListener(e -> {
            checkLoginData();
        });

        signUpApp.setLocation(100, 400);
        signUpApp.setSize(150, 50);
        signUpApp.setVisible(true);
        signUpApp.addActionListener(e -> {
                    signUpPanelInit();
                }
        );

        this.add(title);
        this.add(login_label);
        this.add(loginField);
        this.add(pass_label);
        this.add(passField);
        this.add(logInApp);
        this.add(signUpApp);
        this.setBorder(BorderFactory.createLineBorder(new Color(151, 144, 144)));
        this.repaint();
    }

    public Boolean checkLoginData() {
        String checkString = "";
        if (!Objects.equals(loginField.getText(), "") && !Objects.equals(Arrays.toString(passField.getPassword()), "")) {
            checkString += loginField.getText() + " " + Arrays.toString(passField.getPassword());
            signInPanelInit();
            return true;
        } else {
            JFrame alert = new JFrame("Alert");
            alert.setLocationRelativeTo(null);
            alert.setSize(200, 150);
            alert.setLayout(null);
            alert.repaint();
            alert.setVisible(true);
            JLabel alertLabel = new JLabel("Invalid credentials");
            alertLabel.setSize(150, 40);
            alertLabel.setLocation(10, 10);
            alert.add(alertLabel);
            JButton okButton = new JButton("OK.");
            okButton.setLocation(40, 80);
            okButton.setSize(60, 30);
            okButton.addActionListener(e -> alert.dispose());
            alert.add(okButton);
        }
        return false;
    }

    public void signInPanelInit() {
        UserPanel userPanel = new UserPanel(350, 525, 25, 25);
        this.getParent().add(userPanel);
        this.getParent().repaint();
        this.getParent().remove(this);

    }

    public void signUpPanelInit() {
        CreateAcountPanel createAcountPanel = new CreateAcountPanel(350, 525, 25, 25);
        this.getParent().add(createAcountPanel);
        this.getParent().repaint();
        this.getParent().remove(this);
    }

}

