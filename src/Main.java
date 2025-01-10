package src;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Tworzenie implementacji menedżera studentów
                StudentManagerImpl studentManager = new StudentManagerImpl();

                // Tworzenie GUI i uruchamianie aplikacji
                StudentManagementGUI gui = new StudentManagementGUI(studentManager);
                gui.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
