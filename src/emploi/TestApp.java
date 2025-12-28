// ============================================================
// CLASSE 5 : APPLICATION DE TEST
// ============================================================

package emploi;

import javax.swing.*;

public class TestApp extends JFrame {
    
    public TestApp() {
        setTitle("TEST - Inscription et Connexion");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Test de connexion à la BD
        testConnexionBD();
        
        // Ajouter l'écran de test
        add(new EcranTestInscription());
        
        setVisible(true);
    }
    
    private void testConnexionBD() {
        try {
            ConnexionBD.getConnexion();
            System.out.println("✅ Application prête!");
        } catch (Exception e) {
            System.out.println("❌ IMPOSSIBLE DE DÉMARRER");
            JOptionPane.showMessageDialog(this, 
                "❌ IMPOSSIBLE DE SE CONNECTER À LA BASE DE DONNÉES!\n\n" +
                "Vérifier:\n" +
                "1. XAMPP est démarré (Apache + MySQL = VERT)\n" +
                "2. La base 'emploi_connect' existe\n" +
                "3. Le driver MySQL est importé",
                "Erreur de Connexion",
                JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TestApp());
    }
}