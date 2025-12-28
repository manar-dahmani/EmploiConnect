// ============================================================
// CLASSE 4 : ÉCRAN DE TEST (INSCRIPTION + CONNEXION)
// ============================================================

package emploi;

import javax.swing.*;
import java.awt.*;

public class EcranTestInscription extends JPanel {
    
    private JTextField tfEmail;
    private JPasswordField tfMotDePasse;
    private JComboBox<String> cbRole;
    private JTextArea taResultat;
    
    public EcranTestInscription() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // FORMULAIRE D'INSCRIPTION
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridBagLayout());
        panelForm.setBorder(BorderFactory.createTitledBorder("TEST INSCRIPTION"));
        panelForm.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Email
        gbc.gridx = 0; gbc.gridy = 0;
        panelForm.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        tfEmail = new JTextField(20);
        tfEmail.setText("test@email.com");
        panelForm.add(tfEmail, gbc);
        
        // Mot de passe
        gbc.gridx = 0; gbc.gridy = 1;
        panelForm.add(new JLabel("Mot de passe:"), gbc);
        gbc.gridx = 1;
        tfMotDePasse = new JPasswordField(20);
        tfMotDePasse.setText("password123");
        panelForm.add(tfMotDePasse, gbc);
        
        // Rôle
        gbc.gridx = 0; gbc.gridy = 2;
        panelForm.add(new JLabel("Rôle:"), gbc);
        gbc.gridx = 1;
        cbRole = new JComboBox<>(new String[]{"chercheur", "recruteur", "admin"});
        panelForm.add(cbRole, gbc);
        
        // Boutons d'action
        JPanel panelBoutons = new JPanel();
        
        JButton btnInscrire = new JButton("📝 S'inscrire");
        btnInscrire.setBackground(new Color(76, 175, 80));
        btnInscrire.setForeground(Color.WHITE);
        btnInscrire.addActionListener(e -> inscrireUtilisateur());
        panelBoutons.add(btnInscrire);
        
        JButton btnConnexion = new JButton("🔓 Se connecter");
        btnConnexion.setBackground(new Color(0, 102, 204));
        btnConnexion.setForeground(Color.WHITE);
        btnConnexion.addActionListener(e -> testConnexion());
        panelBoutons.add(btnConnexion);
        
        JButton btnAfficherAll = new JButton("📋 Voir tous les users");
        btnAfficherAll.setBackground(new Color(255, 152, 0));
        btnAfficherAll.setForeground(Color.WHITE);
        btnAfficherAll.addActionListener(e -> UtilisateurDAO.afficherTousLesUtilisateurs());
        panelBoutons.add(btnAfficherAll);
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        panelForm.add(panelBoutons, gbc);
        
        // ZONE DE RÉSULTATS
        JPanel panelResultats = new JPanel();
        panelResultats.setLayout(new BorderLayout());
        panelResultats.setBorder(BorderFactory.createTitledBorder("RÉSULTATS"));
        panelResultats.setBackground(Color.WHITE);
        
        taResultat = new JTextArea(15, 50);
        taResultat.setEditable(false);
        taResultat.setFont(new Font("Monospaced", Font.PLAIN, 11));
        taResultat.setText("Les résultats apparaîtront ici et dans la console...\n");
        
        JScrollPane scrollPane = new JScrollPane(taResultat);
        panelResultats.add(scrollPane, BorderLayout.CENTER);
        
        // Layout principal
        add(panelForm, BorderLayout.NORTH);
        add(panelResultats, BorderLayout.CENTER);
    }
    
    private void inscrireUtilisateur() {
        String email = tfEmail.getText();
        String motDePasse = new String(tfMotDePasse.getPassword());
        String role = (String) cbRole.getSelectedItem();
        
        if(email.isEmpty() || motDePasse.isEmpty()) {
            afficherResultat("❌ Email et mot de passe obligatoires!");
            return;
        }
        
        // Vérifier si l'email existe déjà
        if(UtilisateurDAO.emailExiste(email)) {
            afficherResultat("❌ Cet email existe déjà!");
            return;
        }
        
        // Créer l'utilisateur
        Utilisateur user = new Utilisateur(email, motDePasse, role);
        
        if(UtilisateurDAO.creerUtilisateur(user)) {
            afficherResultat("✅ Inscription réussie!\n📧 Email: " + email + "\n👤 Rôle: " + role);
            tfEmail.setText("test@email.com");
            tfMotDePasse.setText("password123");
        } else {
            afficherResultat("❌ Erreur lors de l'inscription!");
        }
    }
    
    private void testConnexion() {
        String email = tfEmail.getText();
        String motDePasse = new String(tfMotDePasse.getPassword());
        
        if(email.isEmpty() || motDePasse.isEmpty()) {
            afficherResultat("❌ Email et mot de passe obligatoires!");
            return;
        }
        
        Utilisateur user = UtilisateurDAO.verifierConnexion(email, motDePasse);
        
        if(user != null) {
            afficherResultat("✅ CONNEXION RÉUSSIE!\n" +
                "ID: " + user.getId() + "\n" +
                "Email: " + user.getEmail() + "\n" +
                "Rôle: " + user.getRole() + "\n" +
                "Statut: " + user.getStatut());
        } else {
            afficherResultat("❌ ERREUR: Identifiants invalides!");
        }
    }
    
    private void afficherResultat(String message) {
        taResultat.append("\n" + message);
    }
}

