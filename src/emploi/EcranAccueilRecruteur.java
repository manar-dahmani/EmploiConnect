package emploi;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class EcranAccueilRecruteur extends JPanel {
    
    private EmploiConnect app;
    
    public EcranAccueilRecruteur(EmploiConnect app) {
        this.app = app;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // Menu
        JPanel panelMenu = creerMenuRecruteur();
        add(panelMenu, BorderLayout.NORTH);
        
        // Contenu
        JPanel panelContenu = new JPanel();
        panelContenu.setLayout(new BoxLayout(panelContenu, BoxLayout.Y_AXIS));
        panelContenu.setBorder(new EmptyBorder(15, 15, 15, 15));
        panelContenu.setBackground(Color.WHITE);
        
        // Titre
        JLabel lblTitre = new JLabel("Espace Recruteur");
        lblTitre.setFont(new Font("Arial", Font.BOLD, 18));
        panelContenu.add(lblTitre);
        
        panelContenu.add(Box.createVerticalStrut(15));
        
        // Statistiques
        panelContenu.add(creerSectionStatistiques());
        
        panelContenu.add(Box.createVerticalStrut(15));
        
        // Mes offres
        panelContenu.add(creerSectionMesOffres());
        
        panelContenu.add(Box.createVerticalStrut(15));
        
        // Bouton créer offre
        JButton btnNouvelle = new JButton("+ Créer une nouvelle offre");
        btnNouvelle.setBackground(new Color(76, 175, 80));
        btnNouvelle.setForeground(Color.WHITE);
        btnNouvelle.setFont(new Font("Arial", Font.BOLD, 12));
        panelContenu.add(btnNouvelle);
        
        JScrollPane scrollPane = new JScrollPane(panelContenu);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private JPanel creerMenuRecruteur() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(0, 102, 204));
        panel.setPreferredSize(new Dimension(0, 50));
        
        JLabel lblLogo = new JLabel("🏢 EMPLOI-CONNECT");
        lblLogo.setFont(new Font("Arial", Font.BOLD, 16));
        lblLogo.setForeground(Color.WHITE);
        panel.add(lblLogo);
        
        panel.add(Box.createHorizontalGlue());
        
        JButton btnMesOffres = new JButton("Mes Offres");
        JButton btnCandidatures = new JButton("Candidatures");
        JButton btnDeconnexion = new JButton("Déconnexion");
        
        btnDeconnexion.addActionListener(e -> {
            if(app != null) app.afficherEcran("LOGIN");
        });
        
        for(JButton btn : new JButton[]{btnMesOffres, btnCandidatures, btnDeconnexion}) {
            btn.setBackground(Color.WHITE);
            btn.setForeground(new Color(0, 102, 204));
            btn.setBorder(new EmptyBorder(5, 10, 5, 10));
            panel.add(btn);
        }
        
        return panel;
    }
    
    private JPanel creerSectionStatistiques() {
        JPanel panel = new JPanel(new GridLayout(1, 3, 15, 0));
        panel.setBackground(Color.WHITE);
        
        panel.add(creerCarteStatistique("Offres Publiées", "5", new Color(33, 150, 243)));
        panel.add(creerCarteStatistique("Candidatures", "127", new Color(76, 175, 80)));
        panel.add(creerCarteStatistique("Embauches", "12", new Color(255, 152, 0)));
        
        return panel;
    }
    
    private JPanel creerCarteStatistique(String titre, String valeur, Color couleur) {
        JPanel carte = new JPanel(new BorderLayout());
        carte.setBackground(couleur);
        carte.setPreferredSize(new Dimension(0, 80));
        
        JLabel lblTitre = new JLabel(titre);
        lblTitre.setFont(new Font("Arial", Font.PLAIN, 12));
        lblTitre.setForeground(Color.WHITE);
        lblTitre.setBorder(new EmptyBorder(5, 10, 5, 10));
        carte.add(lblTitre, BorderLayout.NORTH);
        
        JLabel lblValeur = new JLabel(valeur);
        lblValeur.setFont(new Font("Arial", Font.BOLD, 24));
        lblValeur.setForeground(Color.WHITE);
        lblValeur.setHorizontalAlignment(JLabel.CENTER);
        carte.add(lblValeur, BorderLayout.CENTER);
        
        return carte;
    }
    
    private JPanel creerSectionMesOffres() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new TitledBorder("Mes Offres (5 publiées)"));
        panel.setBackground(Color.WHITE);
        
        panel.add(creerLigneOffre("Développeur Java Senior", "45 candidatures", "8 en attente"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(creerLigneOffre("Data Analyst", "32 candidatures", "5 en attente"));
        
        return panel;
    }
    
    private JPanel creerLigneOffre(String titre, String stats, String enAttente) {
        JPanel ligne = new JPanel(new BorderLayout());
        ligne.setBorder(new LineBorder(new Color(220, 220, 220), 1));
        ligne.setBackground(Color.WHITE);
        ligne.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setBackground(Color.WHITE);
        
        JLabel lblTitre = new JLabel(titre);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 12));
        info.add(lblTitre);
        
        JLabel lblStats = new JLabel(stats + " | " + enAttente);
        lblStats.setFont(new Font("Arial", Font.PLAIN, 11));
        info.add(lblStats);
        
        ligne.add(info, BorderLayout.CENTER);
        
        JPanel actions = new JPanel();
        actions.setLayout(new BoxLayout(actions, BoxLayout.Y_AXIS));
        actions.setBackground(Color.WHITE);
        
        JButton btnGerer = new JButton("Gérer");
        btnGerer.setBackground(new Color(0, 102, 204));
        btnGerer.setForeground(Color.WHITE);
        actions.add(btnGerer);
        
        ligne.add(actions, BorderLayout.EAST);
        
        return ligne;
    }
}