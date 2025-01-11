package src;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                StudentManagerImpl studentManager = new StudentManagerImpl();

                StudentManagementGUI gui = new StudentManagementGUI(studentManager);
                gui.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
