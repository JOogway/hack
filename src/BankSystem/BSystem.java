package BankSystem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dmacho on 27.05.17.
 */
public class BSystem {
    public BSystem(int accountBalance, List<Client> listOfClients, double interestRate) {
        this.accountBalance = accountBalance;
        this.listOfClients = listOfClients;
        this.interestRate = interestRate;
    }

    public void calculateInterestRate(){

    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<Client> getListOfClients() {
        return listOfClients;
    }

    public void setListOfClients(List<Client> listOfClients) {
        this.listOfClients = listOfClients;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    private int accountBalance;
    private List<Client> listOfClients = new LinkedList<>();
    private double interestRate;
}
