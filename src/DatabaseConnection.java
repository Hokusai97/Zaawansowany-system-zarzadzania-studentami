package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:database/students.db";

    // Metoda łącząca się z bazą danych
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL);
            return connection;
        } catch (SQLException e) {
            System.err.println("Error when connecting to the database: " + e.getMessage());
            return null;
        }
    }

    // Metoda inicjalizująca tabelę w bazie danych
    public static void initializeDatabase() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS students (" +
                                  "name TEXT, " +
                                  "age INTEGER, " +
                                  "grade REAL, " +
                                  "studentID TEXT PRIMARY KEY)";
        try (Connection connection = getConnection(); Statement stmt = connection.createStatement()) {
            stmt.execute(createTableQuery);
            System.out.println("Table 'students' initialized.");
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
}
