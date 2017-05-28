package connector;

import java.sql.*;
import java.util.Objects;

/**
 * Created by oogway on 27.05.17.
 */
public class DBConnector {
    Connection conn = null;

    String name, surname, login, password, email, address, bankAccountNumber;
    long cardNumber, phone, pesel;
    int accountBalance, expirationDate, cvvCode;

    public DBConnector(String name, String surname, String bankAccountNumber, long cardNumber, int expirationDate, int cvvCode, long phone,
                       String email, long pesel, String address, int accountBalance, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.bankAccountNumber = bankAccountNumber;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvvCode = cvvCode;
        this.phone = phone;
        this.email = email;
        this.pesel = pesel;
        this.address = address;
        this.accountBalance = accountBalance;
        this.login = login;
        this.password = password;
    }

    public void connect(String function, int id) {
        try {
            String userName = "root";
            String passwordSQL = "";
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/prototyp?autoReconnect=true&useSSL=false";
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, passwordSQL);
            Statement stmt = conn.createStatement();
            System.out.println("Database connection established");
            if (Objects.equals(function, "insert")) {
                insert(stmt, name, surname, bankAccountNumber, cardNumber, expirationDate, cvvCode, phone, email, pesel, address, accountBalance, login, password);
            } else if (Objects.equals(function, "select")) {
                select(stmt, "id_uzytk", id);
            }

        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database connection terminated");
                } catch (Exception e) { /* ignore close errors */ }
            }
        }
    }

    public void insert(Statement stm, String name, String surname, String bankAccountNumber, long cardNumber, int expirationDate, int cvvCode, long phone,
                       String email, long pesel, String address, int accountBalance, String login, String password) throws SQLException {
        stm.executeUpdate("INSERT INTO uzytkownicy VALUES (DEFAULT, '" + name + "', '" + surname + "', '" + bankAccountNumber + "', '" +
                cardNumber + "', '" + expirationDate + "', '" + cvvCode + "', '" + phone + "', '" + email + "', '" + pesel + "', '" + address + "', '" +
                accountBalance + "', '" + login + "', '" + password + "')");

    }

    public void select(Statement stm, String column, int value) throws SQLException {
        ResultSet rs = stm.executeQuery("SELECT * FROM uzytkownicy WHERE " + column + " = " + value + "");
        while (rs.next()) {

            String name = rs.getString("imie");
            String surname = rs.getString("nazwisko");
            String bankAccountNumber = rs.getString("numer_konta");
            long cardNumber = rs.getLong("numer_karty");
            int expirationDate = rs.getInt("data_waznosci");
            int cvvCode = rs.getInt("3cyfrowy_kod");
            long phone = rs.getLong("numer_telefonu");
            String email = rs.getString("email");
            long pesel = rs.getLong("pesel");
            String address = rs.getString("adres");
            int accountBalance = rs.getInt("stan_konta");
            String login = rs.getString("login");
            String password = rs.getString("haslo");
            System.out.println(name);
        }
    }

}