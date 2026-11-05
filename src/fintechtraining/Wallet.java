package fintechtraining;

public class Wallet {
    private double balance;
    public Wallet(double initialBalance){
        this.balance = initialBalance;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount)throws InsufficientFundsException {
            
           if (amount > balance){
               throw new InsufficientFundsException("Insufficient Funds");
           }
            balance -= amount;
    }
    
       public void printStatement(){
        System.out.println(" -> Wallet Statement: Balance = $" + balance);
       
    }
}
