package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Klasa obsługująca połączenie z bazą danych oraz jej inicjalizację i ścieżka do bazy danych SQLite znajdującym się w folderze database
public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:database/students.db";

    // Metoda łącząca się z bazą danych
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL);

            // Inicjalizacja bazy danych (tworzenie tabeli, jeśli nie istnieje)
            initializeDatabase(connection);

            return connection;
        } catch (SQLException e) {
            // Obsługa błędu jeśli będzie jakiś błąd połączenia
            System.err.println("Error when connecting to the database: " + e.getMessage());
            return null; // Zwraca null w przypadku błędu
        }
    }

    // Prywatna metoda do inicjalizacji bazy danych
    private static void initializeDatabase(Connection connection) {
        // Zapytanie SQL do tworzenia tabeli "students", jeśli nie istnieje
        String createTableQuery = "CREATE TABLE IF NOT EXISTS students (" +
                "name TEXT NOT NULL, " +
                "age INTEGER NOT NULL, " +
                "grade REAL NOT NULL, " +
                "studentID TEXT PRIMARY KEY NOT NULL)";

        try (Statement stmt = connection.createStatement()) {
            // Wykonanie zapytania SQL
            stmt.execute(createTableQuery);

            // Informacaj o pomyślnym zainicjalizwoaniu tabeli
            System.out.println("Table 'students' initialized.");
        } catch (SQLException e) {
            // Obsługa błędu
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
}
