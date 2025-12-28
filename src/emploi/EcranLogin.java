package emploi;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class EcranLogin extends JPanel {
    
    private EmploiConnect app;
    private JTextField tfEmail;
    private JPasswordField tfMotDePasse;
    private JComboBox<String> cbRole;
    
    public EcranLogin(EmploiConnect app) {
        this.app = app;
        setLayout(new GridBagLayout());
        setBackground(new Color(240, 245, 250));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Titre
        JLabel lblTitre = new JLabel("EMPLOI-CONNECT");
        lblTitre.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitre.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lblTitre, gbc);
        
        // Soustitre
        JLabel lblSoustitre = new JLabel("Plateforme de Recherche d'Emploi");
        lblSoustitre.setFont(new Font("Arial", Font.ITALIC, 14));
        gbc.gridy = 1;
        add(lblSoustitre, gbc);
        
        // Email
        gbc.gridwidth = 1;
        gbc.gridy = 3;
        gbc.gridx = 0;
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 12));
        add(lblEmail, gbc);
        
        gbc.gridx = 1;
        tfEmail = new JTextField(20);
        tfEmail.setText("ahmed@email.com");
        add(tfEmail, gbc);
        
        // Mot de passe
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel lblMdp = new JLabel("Mot de passe:");
        lblMdp.setFont(new Font("Arial", Font.PLAIN, 12));
        add(lblMdp, gbc);
        
        gbc.gridx = 1;
        tfMotDePasse = new JPasswordField(20);
        tfMotDePasse.setText("pass123");
        add(tfMotDePasse, gbc);
        
        // Rôle
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel lblRole = new JLabel("Je suis:");
        lblRole.setFont(new Font("Arial", Font.PLAIN, 12));
        add(lblRole, gbc);
        
        gbc.gridx = 1;
        cbRole = new JComboBox<>(new String[]{"Chercheur d'emploi", "Recruteur", "Administrateur"});
        cbRole.setSelectedIndex(0);
        add(cbRole, gbc);
        
        // Bouton Connexion
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        JButton btnConnecter = new JButton("Se connecter");
        btnConnecter.setFont(new Font("Arial", Font.BOLD, 14));
        btnConnecter.setBackground(new Color(0, 102, 204));
        btnConnecter.setForeground(Color.WHITE);
        btnConnecter.setPreferredSize(new Dimension(200, 40));
        
        btnConnecter.addActionListener(e -> {
            String email = tfEmail.getText();
            String role = (String) cbRole.getSelectedItem();
            
            // Simuler connexion
            app.setUtilisateur(email, role);
            
            // Rediriger selon le rôle
            if(role.equals("Chercheur d'emploi")) {
                app.afficherEcran("ACCUEIL_CHERCHEUR");
            } else if(role.equals("Recruteur")) {
                app.afficherEcran("ACCUEIL_RECRUTEUR");
            } else {
                app.afficherEcran("DASHBOARD_ADMIN");
            }
        });
        
        add(btnConnecter, gbc);
    }
}