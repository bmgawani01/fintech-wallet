package fintechtraining;

public class User {
    private String name;
    private String phone;
    private Wallet wallet; // EVERY USER HAS A WALLET

    // Constructor - when you create a User, auto-create their Wallet
    public User(String name, String phone, double initialBalance) {
        this.name = name;
        this.phone = phone;
        this.wallet = new Wallet(initialBalance); // <-- THE LINK
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Wallet getWallet() {
        return wallet;
    }

    // Shortcut: you can do user.deposit(50) instead of user.getWallet().deposit(50)
    public void deposit(double amount) {
        wallet.deposit(amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        wallet.withdraw(amount);
    }

    // THE BIG ONE: User to User transfer
    public void sendMoney(User receiver, double amount) throws InsufficientFundsException {
        System.out.println(this.name + " is sending $" + amount + " to " + receiver.getName());
        this.wallet.transferTo(receiver.getWallet(), amount);
    }

    public void printStatement() {
        System.out.println("\n=== Statement for " + name + " (" + phone + ") ===");
        wallet.printStatement();
    }
}