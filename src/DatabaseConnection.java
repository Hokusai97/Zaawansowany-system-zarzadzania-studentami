package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:database/students.db";

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL);
            initializeDatabase(connection); 
            return connection;
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            return null;
        }
    }

    private static void initializeDatabase(Connection connection) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS students (" +
                "name TEXT NOT NULL, " +
                "age INTEGER NOT NULL, " +
                "grade REAL NOT NULL, " +
                "studentID TEXT PRIMARY KEY NOT NULL)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableQuery);
            System.out.println("Table 'students' initialized.");
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
}
