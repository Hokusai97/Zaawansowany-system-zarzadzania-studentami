package src;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Inicjalizacja bazy danych
        DatabaseConnection.initializeDatabase();

        // Uruchamia GUI w wątku Swing
        SwingUtilities.invokeLater(() -> {
            try {
                StudentManagerImpl studentManager = new StudentManagerImpl();

                StudentManagementGUI gui = new StudentManagementGUI(studentManager);

                gui.show();
            } catch (Exception e) {
                // Obsługuje wszelkie wyjątki i wykonuje print by wyswietlić szczegóły
                e.printStackTrace();
            }
        });
    }
}
