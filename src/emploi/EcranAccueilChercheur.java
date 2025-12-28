package emploi;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class EcranAccueilChercheur extends JPanel {
    
    private EmploiConnect app;
    
    public EcranAccueilChercheur(EmploiConnect app) {
        this.app = app;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // MENU HAUT
        JPanel panelMenu = creerMenuSup();
        add(panelMenu, BorderLayout.NORTH);
        
        // CONTENU PRINCIPAL
        JPanel panelContenu = new JPanel(new BorderLayout());
        panelContenu.setBackground(Color.WHITE);
        
        // Banneau de recherche
        JPanel panelBanneau = creerBanneauRecherche();
        panelContenu.add(panelBanneau, BorderLayout.NORTH);
        
        // Offres recommandées
        JPanel panelOffres = creerOffresRecommandees();
        panelContenu.add(panelOffres, BorderLayout.CENTER);
        
        add(panelContenu, BorderLayout.CENTER);
    }
    
    private JPanel creerMenuSup() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(0, 102, 204));
        panel.setPreferredSize(new Dimension(0, 60));
        
        JLabel lblLogo = new JLabel("🏢 EMPLOI-CONNECT");
        lblLogo.setFont(new Font("Arial", Font.BOLD, 16));
        lblLogo.setForeground(Color.WHITE);
        panel.add(lblLogo);
        
        panel.add(Box.createHorizontalGlue());
        
        JButton btnAccueil = new JButton("Accueil");
        JButton btnRecherche = new JButton("Recherche");
        JButton btnMesCandidat = new JButton("Mes Candidatures");
        JButton btnProfil = new JButton("Mon Profil");
        JButton btnDeconnexion = new JButton("Déconnexion");
        
        btnRecherche.addActionListener(e -> app.afficherEcran("RECHERCHE"));
        btnProfil.addActionListener(e -> app.afficherEcran("PROFIL_CHERCHEUR"));
        btnDeconnexion.addActionListener(e -> app.afficherEcran("LOGIN"));
        
        for(JButton btn : new JButton[]{btnAccueil, btnRecherche, btnMesCandidat, btnProfil, btnDeconnexion}) {
            btn.setBackground(Color.WHITE);
            btn.setForeground(new Color(0, 102, 204));
            btn.setBorder(new EmptyBorder(5, 10, 5, 10));
            panel.add(btn);
        }
        
        return panel;
    }
    private JPanel creerBanneauRecherche() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 245, 250));
        panel.setPreferredSize(new Dimension(0, 100));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JLabel lblRecherche = new JLabel("🔍 Trouver un emploi:");
        panel.add(lblRecherche);
        
        JTextField tfRecherche = new JTextField(20);
        tfRecherche.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(tfRecherche);
        
        JComboBox<String> cbSecteur = new JComboBox<>(new String[]{
            "Tous les secteurs", "Informatique", "Finance", "Marketing", "Ressources Humaines"
        });
        panel.add(cbSecteur);
        
        JButton btnRechercher = new JButton("Rechercher");
        btnRechercher.setBackground(new Color(0, 102, 204));
        btnRechercher.setForeground(Color.WHITE);
        btnRechercher.addActionListener(e -> app.afficherEcran("RECHERCHE"));
        panel.add(btnRechercher);
        
        return panel;
    }
    
    private JPanel creerOffresRecommandees() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JLabel lblTitle = new JLabel("📌 Offres Recommandées");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(lblTitle, BorderLayout.NORTH);
        
        JPanel panelOffres = new JPanel(new GridLayout(1, 3, 15, 0));
        panelOffres.setBackground(Color.WHITE);
        
        // Offre 1
        panelOffres.add(creerCarteOffre(
            "Développeur Java Senior",
            "TechCorp Solutions",
            "Alger",
            "80-100K DA"
        ));
        
        // Offre 2
        panelOffres.add(creerCarteOffre(
            "Data Analyst",
            "DataPro",
            "Blida",
            "100-120K DA"
        ));
        
        // Offre 3
        panelOffres.add(creerCarteOffre(
            "Product Manager",
            "InnovateTech",
            "Alger",
            "120-150K DA"
        ));
        
        panel.add(panelOffres, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel creerCarteOffre(String titre, String entreprise, String lieu, String salaire) {
        JPanel carte = new JPanel(new BorderLayout());
        carte.setBorder(new LineBorder(new Color(200, 200, 200), 1));
        carte.setBackground(Color.WHITE);
        carte.setPreferredSize(new Dimension(250, 150));
        
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(0, 102, 204));
        header.setPreferredSize(new Dimension(0, 50));
        
        JLabel lblTitre = new JLabel(titre);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 12));
        lblTitre.setForeground(Color.WHITE);
        lblTitre.setBorder(new EmptyBorder(5, 10, 5, 10));
        header.add(lblTitre, BorderLayout.CENTER);
        
        carte.add(header, BorderLayout.NORTH);
        
        JPanel contenu = new JPanel(new GridLayout(3, 1));
        contenu.setBackground(Color.WHITE);
        contenu.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        contenu.add(new JLabel("Entreprise: " + entreprise));
        contenu.add(new JLabel("Localité: " + lieu));
        contenu.add(new JLabel("Salaire: " + salaire));
        
        carte.add(contenu, BorderLayout.CENTER);
        
        JButton btnCandidater = new JButton("Candidater");
        btnCandidater.setBackground(new Color(76, 175, 80));
        btnCandidater.setForeground(Color.WHITE);
        carte.add(btnCandidater, BorderLayout.SOUTH);
        
        return carte;
    }
}