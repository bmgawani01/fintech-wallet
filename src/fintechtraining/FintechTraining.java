package fintechtraining;

public class FintechTraining {
    public static void main(String[] args) {
        User bright = new User("Bright", "0771234567", 200);
        User tendai = new User("Tendai", "0777654321", 50);

        try {
            bright.sendMoney(tendai, 70);
            System.out.println("Transfer SUCCESS!");
        } catch (InsufficientFundsException e) {
            System.out.println("Transfer FAILED: " + e.getMessage());
        }

        // SAVE TO MYSQL
        Database.saveUser(bright);
        Database.saveUser(tendai);

        // PROVE IT'S SAVED - Load from DB fresh
        System.out.println("\nReloaded from DB:");
        System.out.println("Bright in DB: $" + Database.loadBalance("0771234567"));
        System.out.println("Tendai in DB: $" + Database.loadBalance("0777654321"));

        Database.printAllUsers();
    }
}