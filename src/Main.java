package src;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Uruchamia GUI w wątku
        SwingUtilities.invokeLater(() -> {
            try {
                // Tworzy instancję implementacji menedżera studentów
                StudentManagerImpl studentManager = new StudentManagerImpl();

                // Tworzy instancj GUI dla zarządzania studentami
                StudentManagementGUI gui = new StudentManagementGUI(studentManager);

                // Wyświetla GUI
                gui.show();
            } catch (Exception e) {
                // Obsługuje wszelkie wyjątki i drukuje szczegóły 
                e.printStackTrace();
            }
        });
    }
}
