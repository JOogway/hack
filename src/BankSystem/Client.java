package BankSystem;

/**
 * Created by dmacho on 27.05.17.
 */
public class Client {

    public Client(int id_client, String name, String surname, long bankAccountNumber, ClientStatus status, int accountBalance, String login, String password, long cardNumber, int expirationDate, int cvvCode, long phone, String address) {
        this.id_client = id_client;
        this.name = name;
        this.surname = surname;
        this.bankAccountNumber = bankAccountNumber;
        this.clientStatus = status;
        this.accountBalance = accountBalance;
        this.login = login;
        this.password = password;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvvCode = cvvCode;
        this.phone = phone;
        this.address = address;

    }

    public ClientStatus ClientStatusCheck(){
        if(this.accountBalance < 0)
           return this.clientStatus = ClientStatus.Clean;
        else
          return  this.clientStatus = ClientStatus.Debt;
    }

    public void LoginUser(String login, String Password){

    }

    public void LogoutUser(){

    }

    public void LendTheMoney(int value){
        this.accountBalance += value;
    }


    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
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

    public long getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(long bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public ClientStatus getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(ClientStatus clientStatus) {
        this.clientStatus = clientStatus;
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

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private int id_client;
    private String name;
    private String surname;
    private long bankAccountNumber;
    private ClientStatus clientStatus;
    private int accountBalance;
    private String login;
    private String password;
    private long cardNumber;
    private int expirationDate;
    private int cvvCode;
    private long phone;
    private String address;


}
