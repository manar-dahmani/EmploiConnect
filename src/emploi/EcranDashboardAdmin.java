package emploi;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class EcranDashboardAdmin extends JPanel {
    
    private EmploiConnect app;
    
    public EcranDashboardAdmin(EmploiConnect app) {
        this.app = app;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // Menu
        JPanel panelMenu = creerMenuAdmin();
        add(panelMenu, BorderLayout.NORTH);
        
        // Contenu
        JPanel panelContenu = new JPanel();
        panelContenu.setLayout(new BoxLayout(panelContenu, BoxLayout.Y_AXIS));
        panelContenu.setBorder(new EmptyBorder(15, 15, 15, 15));
        panelContenu.setBackground(Color.WHITE);
        
        // Titre
        JLabel lblTitre = new JLabel("Tableau de Bord Administrateur");
        lblTitre.setFont(new Font("Arial", Font.BOLD, 18));
        panelContenu.add(lblTitre);
        
        panelContenu.add(Box.createVerticalStrut(15));
        
        // Statistiques générales
        panelContenu.add(creerSectionStatistiques());
        
        panelContenu.add(Box.createVerticalStrut(15));
        
        // Modération
        panelContenu.add(creerSectionModeration());
        
        panelContenu.add(Box.createVerticalStrut(15));
        
        // Boutons d'action
        panelContenu.add(creerBoutonsAction());
        
        JScrollPane scrollPane = new JScrollPane(panelContenu);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private JPanel creerMenuAdmin() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(0, 102, 204));
        panel.setPreferredSize(new Dimension(0, 50));
        
        JLabel lblLogo = new JLabel("🔐 ADMIN - EMPLOI-CONNECT");
        lblLogo.setFont(new Font("Arial", Font.BOLD, 16));
        lblLogo.setForeground(Color.WHITE);
        panel.add(lblLogo);
        
        panel.add(Box.createHorizontalGlue());
        
        JButton btnDeconnexion = new JButton("Déconnexion");
        btnDeconnexion.setBackground(Color.WHITE);
        btnDeconnexion.setForeground(new Color(0, 102, 204));
        btnDeconnexion.addActionListener(e -> app.afficherEcran("LOGIN"));
        panel.add(btnDeconnexion);
        
        return panel;
    }
    
    private JPanel creerSectionStatistiques() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 15, 15));
        panel.setBackground(Color.WHITE);
        
        panel.add(creerCarteStatAdmin("Utilisateurs", "5,432", new Color(33, 150, 243)));
        panel.add(creerCarteStatAdmin("Offres Publiées", "834", new Color(76, 175, 80)));
        panel.add(creerCarteStatAdmin("Candidatures", "25,123", new Color(255, 152, 0)));
        panel.add(creerCarteStatAdmin("Satisfaction", "4.2/5 ⭐", new Color(156, 39, 176)));
        
        return panel;
    }
    
    private JPanel creerCarteStatAdmin(String titre, String valeur, Color couleur) {
        JPanel carte = new JPanel(new BorderLayout());
        carte.setBackground(couleur);
        carte.setPreferredSize(new Dimension(0, 100));
        carte.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JLabel lblTitre = new JLabel(titre);
        lblTitre.setFont(new Font("Arial", Font.PLAIN, 12));
        lblTitre.setForeground(Color.WHITE);
        carte.add(lblTitre, BorderLayout.NORTH);
        
        JLabel lblValeur = new JLabel(valeur);
        lblValeur.setFont(new Font("Arial", Font.BOLD, 28));
        lblValeur.setForeground(Color.WHITE);
        lblValeur.setHorizontalAlignment(JLabel.CENTER);
        carte.add(lblValeur, BorderLayout.CENTER);
        
        return carte;
    }
    
    private JPanel creerSectionModeration() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new TitledBorder("Modération"));
        panel.setBackground(Color.WHITE);
        
        JLabel lblOffres = new JLabel("⚠️  Offres en attente de validation: 3");
        JLabel lblSignalements = new JLabel("⚠️  Profils signalés: 2");
        JLabel lblCommentaires = new JLabel("⚠️  Commentaires signalés: 15");
        
        for(JLabel lbl : new JLabel[]{lblOffres, lblSignalements, lblCommentaires}) {
            lbl.setFont(new Font("Arial", Font.PLAIN, 12));
            panel.add(lbl);
            panel.add(Box.createVerticalStrut(5));
        }
        
        return panel;
    }
    
    private JPanel creerBoutonsAction() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        panel.setBackground(Color.WHITE);
        
        JButton btnUtilisateurs = new JButton("Gérer Utilisateurs");
        btnUtilisateurs.setBackground(new Color(0, 102, 204));
        btnUtilisateurs.setForeground(Color.WHITE);
        panel.add(btnUtilisateurs);
        
        JButton btnOffres = new JButton("Valider Offres");
        btnOffres.setBackground(new Color(255, 152, 0));
        btnOffres.setForeground(Color.WHITE);
        panel.add(btnOffres);
        
        JButton btnRapport = new JButton("Générer Rapport");
        btnRapport.setBackground(new Color(76, 175, 80));
        btnRapport.setForeground(Color.WHITE);
        panel.add(btnRapport);
        
        return panel;
    }
}