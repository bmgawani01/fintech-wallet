package fintechtraining;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private double balance;
    private List<String> transactions = new ArrayList<>(); 

    public Wallet(double initialBalance){
        this.balance = initialBalance;
        transactions.add("Wallet opened with $" + initialBalance); 
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited $" + amount + " | New Balance: $" + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance){
            throw new InsufficientFundsException("Insufficient Funds");
        }
        balance -= amount;
        transactions.add("Withdrew $" + amount + " | New Balance: $" + balance); 
    }
    
    public void transferTo(Wallet receiver, double amount) throws InsufficientFundsException {
    // 1. Take money from ME - this already checks if I have enough
    this.withdraw(amount);
    // 2. Give money to THEM
    receiver.deposit(amount);
    // 3. Record it in MY history
    transactions.add("Transferred $" + amount + " | New Balance: $" + balance);
}

    public void printStatement(){
        System.out.println("-> Wallet Statement: Balance = $" + balance);
        System.out.println("--- Transaction History ---");
        for (String t : transactions) { 
            System.out.println(t);
        }
    }
}