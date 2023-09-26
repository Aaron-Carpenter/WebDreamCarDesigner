
/**
 * @author Aaron Carpenter - acarpenter5@dmacc.edu
 * CIS175 - Fall 2023
 * Sep 9, 2023
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarDatabase {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cars";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Ghost404";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String insertQuery = "INSERT INTO cars (make, model, color, custom_modifications) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, "Toyota");
                preparedStatement.setString(2, "Camry");
                preparedStatement.setString(3, "Blue");
                preparedStatement.setString(4, "Custom tires, tinted windows");

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Data inserted successfully.");
                } else {
                    System.out.println("Insertion failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}