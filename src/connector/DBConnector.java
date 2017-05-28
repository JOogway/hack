package connector;

import java.sql.*;

/**
 * Created by oogway on 27.05.17.
 */
public class DBConnector {
    Connection conn = null;


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

    public DBConnector() {
    }

    public boolean connect(String function, String login) {
        try {
            String userName = "root";
            String passwordSQL = "";
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/prototyp";
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, passwordSQL);
            Statement stmt = conn.createStatement();
            System.out.println("Database connection established");
            if (function.equals("insert")) {
                insert(stmt, name, surname, bankAccountNumber, cardNumber, expirationDate, cvvCode, phone, email, pesel, address, accountBalance, login, password);
            } else if (function.equals("select")) {
                if (!select(stmt, login))
                    return false;
            }


        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database connection terminated");
                } catch (Exception e) { /* ignore close errors */ }
            }
        }
        return true;
    }

    public void insert(Statement stm, String name, String surname, String bankAccountNumber, long cardNumber, int expirationDate, int cvvCode, long phone,
                       String email, long pesel, String address, int accountBalance, String login, String password) throws SQLException {
        stm.executeUpdate("INSERT INTO uzytkownicy VALUES (DEFAULT, '" + name + "', '" + surname + "', '" + bankAccountNumber + "', '" +
                cardNumber + "', '" + expirationDate + "', '" + cvvCode + "', '" + phone + "', '" + email + "', '" + pesel + "', '" + address + "', '" +
                accountBalance + "', '" + login + "', '" + password + "')");

    }

    public boolean select(Statement stm, String value) throws SQLException {
        ResultSet rs = stm.executeQuery("SELECT * FROM uzytkownicy WHERE login = '" + value + "'");
        while (rs.next()) {

            this.name = rs.getString("imie");
            this.surname = rs.getString("nazwisko");
            this.bankAccountNumber = rs.getString("numer_konta");
            this.cardNumber = rs.getLong("numer_karty");
            this.expirationDate = rs.getInt("data_waznosci");
            this.cvvCode = rs.getInt("3cyfrowy_kod");
            this.phone = rs.getLong("numer_telefonu");
            this.email = rs.getString("email");
            this.pesel = rs.getLong("pesel");
            this.address = rs.getString("adres");
            this.accountBalance = rs.getInt("stan_konta");
            this.login = rs.getString("login");
            this.password = rs.getString("haslo");
            System.out.println(name);
        }

        if (this.name == null) {
            return false;
        }

        return true;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(int cvvCode) {
        this.cvvCode = cvvCode;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String name;
    String surname;
    String bankAccountNumber;
    long cardNumber;
    int expirationDate;
    int cvvCode;
    long phone;
    String email;
    long pesel;
    String address;
    int accountBalance;
    String login;
    String password;

}