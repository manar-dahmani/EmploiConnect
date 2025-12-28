package emploi;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class EcranProfilChercheur extends JPanel {
    
    private EmploiConnect app;
    
    public EcranProfilChercheur(EmploiConnect app) {
        this.app = app;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // Menu
        JPanel panelMenu = creerMenuProfil();
        add(panelMenu, BorderLayout.NORTH);
        
        // Contenu
        JPanel panelContenu = new JPanel();
        panelContenu.setLayout(new BoxLayout(panelContenu, BoxLayout.Y_AXIS));
        panelContenu.setBorder(new EmptyBorder(15, 15, 15, 15));
        panelContenu.setBackground(Color.WHITE);
        
        // Informations personnelles
        panelContenu.add(creerSectionInfoPersonnelles());
        panelContenu.add(Box.createVerticalStrut(15));
        
        // Compétences
        panelContenu.add(creerSectionCompetences());
        panelContenu.add(Box.createVerticalStrut(15));
        
        // Expériences
        panelContenu.add(creerSectionExperiences());
        panelContenu.add(Box.createVerticalStrut(15));
        
        // Boutons
        panelContenu.add(creerBoutons());
        
        JScrollPane scrollPane = new JScrollPane(panelContenu);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private JPanel creerMenuProfil() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(0, 102, 204));
        panel.setPreferredSize(new Dimension(0, 50));
        
        JButton btnRetour = new JButton("← Retour");
        btnRetour.setForeground(Color.WHITE);
        btnRetour.setBackground(new Color(0, 102, 204));
        btnRetour.addActionListener(e -> app.afficherEcran("ACCUEIL_CHERCHEUR"));
        panel.add(btnRetour);
        
        JLabel lblTitre = new JLabel("  Mon Profil");
        lblTitre.setFont(new Font("Arial", Font.BOLD, 14));
        lblTitre.setForeground(Color.WHITE);
        panel.add(lblTitre);
        
        return panel;
    }
    
    private JPanel creerSectionInfoPersonnelles() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new TitledBorder("Informations Personnelles"));
        panel.setBackground(Color.WHITE);
        
        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));
        form.setBackground(Color.WHITE);
        
        form.add(new JLabel("Nom:"));
        form.add(new JTextField("Benlahcene"));
        
        form.add(new JLabel("Prénom:"));
        form.add(new JTextField("Ahmed"));
        
        form.add(new JLabel("Email:"));
        form.add(new JTextField("ahmed@email.com"));
        
        form.add(new JLabel("Téléphone:"));
        form.add(new JTextField("0698765432"));
        
        form.add(new JLabel("Localité:"));
        form.add(new JTextField("Alger"));
        
        panel.add(form);
        
        return panel;
    }
    
    private JPanel creerSectionCompetences() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new TitledBorder("Compétences"));
        panel.setBackground(Color.WHITE);
        
        JPanel competences = new JPanel(new FlowLayout(FlowLayout.LEFT));
        competences.setBackground(Color.WHITE);
        
        for(String comp : new String[]{"Java", "Python", "SQL", "Git"}) {
            JButton btn = new JButton("✓ " + comp);
            btn.setBackground(new Color(200, 230, 255));
            btn.setForeground(new Color(0, 102, 204));
            competences.add(btn);
        }
        
        JButton btnAjouter = new JButton("+ Ajouter");
        btnAjouter.setBackground(new Color(76, 175, 80));
        btnAjouter.setForeground(Color.WHITE);
        competences.add(btnAjouter);
        
        panel.add(competences);
        
        return panel;
    }
    
    private JPanel creerSectionExperiences() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new TitledBorder("Expériences Professionnelles"));
        panel.setBackground(Color.WHITE);
        
        JLabel exp1 = new JLabel("• Développeur Java - TechCorp (2019-2021)");
        exp1.setFont(new Font("Arial", Font.PLAIN, 11));
        panel.add(exp1);
        
        panel.add(Box.createVerticalStrut(5));
        
        JLabel exp2 = new JLabel("• Stage - DataPro (2018)");
        exp2.setFont(new Font("Arial", Font.PLAIN, 11));
        panel.add(exp2);
        
        panel.add(Box.createVerticalStrut(10));
        
        JButton btnAjouter = new JButton("+ Ajouter expérience");
        btnAjouter.setBackground(new Color(76, 175, 80));
        btnAjouter.setForeground(Color.WHITE);
        panel.add(btnAjouter);
        
        return panel;
    }
    
    private JPanel creerBoutons() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panel.setBackground(Color.WHITE);
        
        JButton btnModifier = new JButton("Modifier");
        btnModifier.setBackground(new Color(0, 102, 204));
        btnModifier.setForeground(Color.WHITE);
        panel.add(btnModifier);
        
        JButton btnSauvegarder = new JButton("Sauvegarder");
        btnSauvegarder.setBackground(new Color(76, 175, 80));
        btnSauvegarder.setForeground(Color.WHITE);
        panel.add(btnSauvegarder);
        
        return panel;
    }
}
