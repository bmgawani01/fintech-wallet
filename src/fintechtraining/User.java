package fintechtraining;

import java.util.Map;


public class User {
    private String name;
    private String phoneNumber;
    private String pin;
    private Wallet wallet;
    
    public User(String name, String phoneNumber, String pin, double initialBalance) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.pin = pin;        
        this.wallet = new Wallet(initialBalance);
    }
    
    
    public String getPhoneNumber(){ 
        return phoneNumber;
    }
    
    public String getName(){
        return name;
    }
      
    public Wallet getWallet(){
        return wallet; 
    }
    
  
    public void sendMoney(String toPhone, double amount, String inputPin, Map<String, User> users) throws Exception {
        if (!this.pin.equals(inputPin)) {
            System.out.println("FAILED: Wrong PIN for " + getName());
            return;
        }
        User receiver = users.get(toPhone);
        if(receiver == null){
            System.out.println("FAILED: Receiver not found ");
            return;
        }
        try {
             this.wallet.withdraw(amount); 
             receiver.getWallet().deposit(amount);
             System.out.println(this.name + " sent $ " + amount + " to " + receiver.getName());
        }catch (InsufficientFundsException e){
             System.out.println("FAILED: " + e.getMessage() + " for " + getName());
            
        }
    }
}
        
    

    
 



