package fintechtraining;

import java.sql.*;

public class Database {
    
    private static final String URL = "jdbc:mysql://localhost:3306/fintech_db?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASS = "#Brightgawani2006";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Save a User to DB - if phone exists, UPDATE balance, if not, INSERT
    public static void saveUser(User user) {
        String sql = "INSERT INTO users (name, phone, balance) VALUES (?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE name=?, balance=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPhone());
            ps.setDouble(3, user.getWallet().getBalance());
            ps.setString(4, user.getName());
            ps.setDouble(5, user.getWallet().getBalance());
            ps.executeUpdate();
            System.out.println("Saved to DB: " + user.getName() + " = $" + user.getWallet().getBalance());
        } catch (SQLException e) {
            System.out.println("DB SAVE ERROR: " + e.getMessage());
        }
    }

    // Load balance from DB by phone
    public static double loadBalance(String phone) {
        String sql = "SELECT balance FROM users WHERE phone = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
        } catch (SQLException e) {
            System.out.println("DB LOAD ERROR: " + e.getMessage());
        }
        return 0;
    }

    // Show all users in DB
    public static void printAllUsers() {
        String sql = "SELECT * FROM users";
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.println("\n=== USERS IN DATABASE ===");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") 
                    + " | " + rs.getString("phone") 
                    + " | Balance: $" + rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            System.out.println("DB READ ERROR: " + e.getMessage());
        }
    }
}