package src;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                StudentManager studentManager = new StudentManagerImpl();
                StudentManagementGUI gui = new StudentManagementGUI(studentManager);
                gui.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
