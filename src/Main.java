import GUI.MainFrame;
import connector.DBConnector;

public class Main {

    public static void main(String[] args) {
        String name = "Maksym";
        String surname = "Zieliński";
        String bankAccountNumber = "4659871234569874586934";
        long cardNumber = 312321;
        int expirationDate = 11;
        int cvvCode = 333;
        long phone = 132321321;
        String email = "a123daad";
        long pesel = 9823233;
        String address = "asdadsdsa";
        int accountBalance = 122;
        String login = "dad";
        String password = "fsfs";


        MainFrame m = new MainFrame();
        DBConnector connector = new DBConnector(name, surname, bankAccountNumber, cardNumber, expirationDate, cvvCode, phone, email, pesel, address, accountBalance, login, password);
        connector.connect("select", 2);
    }
}