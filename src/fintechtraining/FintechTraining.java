
package fintechtraining;

import java.util.HashMap;
import java.util.Map;
        

public class FintechTraining {
    
    public static void main(String[] args) throws Exception {
        Map<String, User> users = new HashMap<>();
        User u1 = new User("Tendai", "0771234567", "1234", 150);
        User u2 = new User("Tyler", "0779998888", "4321", 500);  
        users.put(u1.getPhoneNumber(), u1);
        users.put(u2.getPhoneNumber(), u2);
       
        
        System.out.println("Tendai Balance: " + users.get("0771234567").getWallet().getBalance());
        users.get("0771234567").getWallet().printStatement();
        System.out.println("\nTyler Balance: " + users.get("0779998888").getWallet().getBalance());
        users.get("0779998888").getWallet().printStatement();
        
        u1.sendMoney("0779998888", 100, "0000", users);
        u1.sendMoney("0779998888", 100, "1234", users);
        u1.sendMoney("0779998888", 1000, "1234", users);
       
        
        System.out.println("\n--- AFTER P2P ---");
        System.out.println("Tendai: " + users.get("0771234567").getWallet().getBalance());
        System.out.println("Tyler: " + users.get("0779998888").getWallet().getBalance());
           
    }
       
}
    
