package emploi;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class EcranRecherche extends JPanel {
    
    private EmploiConnect app;
    
    public EcranRecherche(EmploiConnect app) {
        this.app = app;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // Menu
        JPanel panelMenu = creerMenuRecherche();
        add(panelMenu, BorderLayout.NORTH);
        
        // Contenu
        JPanel panelContenu = new JPanel(new BorderLayout());
        
        // Filtres (à gauche)
        JPanel panelFiltres = creerPanelFiltres();
        panelFiltres.setPreferredSize(new Dimension(250, 0));
        panelContenu.add(panelFiltres, BorderLayout.WEST);
        
        // Résultats (à droite)
        JPanel panelResultats = creerPanelResultats();
        panelContenu.add(panelResultats, BorderLayout.CENTER);
        
        add(panelContenu, BorderLayout.CENTER);
    }
    
    private JPanel creerMenuRecherche() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(new Color(0, 102, 204));
        panel.setPreferredSize(new Dimension(0, 50));
        
        JButton btnRetour = new JButton("← Retour");
        btnRetour.setForeground(Color.WHITE);
        btnRetour.setBackground(new Color(0, 102, 204));
        btnRetour.addActionListener(e -> app.afficherEcran("ACCUEIL_CHERCHEUR"));
        panel.add(btnRetour);
        
        JLabel lblTitre = new JLabel("  Recherche d'Offres d'Emploi");
        lblTitre.setFont(new Font("Arial", Font.BOLD, 14));
        lblTitre.setForeground(Color.WHITE);
        panel.add(lblTitre);
        
        return panel;
    }
    
    private JPanel creerPanelFiltres() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(240, 245, 250));
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel lblFiltres = new JLabel("Filtres");
        lblFiltres.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblFiltres);
        
        panel.add(Box.createVerticalStrut(10));
        
        // Secteur
        panel.add(new JLabel("Secteur:"));
        JComboBox<String> cbSecteur = new JComboBox<>(new String[]{
            "Tous", "Informatique", "Finance", "Marketing", "RH"
        });
        panel.add(cbSecteur);
        
        panel.add(Box.createVerticalStrut(10));
        
        // Localité
        panel.add(new JLabel("Localité:"));
        JComboBox<String> cbLocalite = new JComboBox<>(new String[]{
            "Tous", "Alger", "Blida", "Oran", "Constantine"
        });
        panel.add(cbLocalite);
        
        panel.add(Box.createVerticalStrut(10));
        
        // Type contrat
        panel.add(new JLabel("Type contrat:"));
        JCheckBox cbCDI = new JCheckBox("CDI");
        JCheckBox cbCDD = new JCheckBox("CDD");
        JCheckBox cbStage = new JCheckBox("Stage");
        cbCDI.setSelected(true);
        panel.add(cbCDI);
        panel.add(cbCDD);
        panel.add(cbStage);
        
        panel.add(Box.createVerticalStrut(10));
        
        // Expérience
        panel.add(new JLabel("Expérience:"));
        JComboBox<String> cbExp = new JComboBox<>(new String[]{
            "Tous", "Débutant", "0-2 ans", "2-5 ans", "5+ ans"
        });
        panel.add(cbExp);
        
        panel.add(Box.createVerticalStrut(10));
        
        JButton btnFiltrer = new JButton("Appliquer");
        btnFiltrer.setBackground(new Color(0, 102, 204));
        btnFiltrer.setForeground(Color.WHITE);
        panel.add(btnFiltrer);
        
        panel.add(Box.createVerticalGlue());
        
        return panel;
    }
    
    private JPanel creerPanelResultats() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        JLabel lblResultats = new JLabel("Résultats: 45 offres trouvées");
        lblResultats.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(lblResultats, BorderLayout.NORTH);
        
        JPanel panelListe = new JPanel();
        panelListe.setLayout(new BoxLayout(panelListe, BoxLayout.Y_AXIS));
        
        // Offre 1
        panelListe.add(creerLigneResultat(
            "Développeur Java Senior",
            "TechCorp Solutions",
            "Alger",
            "CDI | 2-3 ans exp",
            "80-100K DA"
        ));
        
        panelListe.add(Box.createVerticalStrut(10));
        
        // Offre 2
        panelListe.add(creerLigneResultat(
            "Data Analyst",
            "DataPro",
            "Blida",
            "CDI | 3-5 ans exp",
            "100-120K DA"
        ));
        
        panelListe.add(Box.createVerticalStrut(10));
        
        // Offre 3
        panelListe.add(creerLigneResultat(
            "Product Manager",
            "InnovateTech",
            "Alger",
            "CDI | 5+ ans exp",
            "120-150K DA"
        ));
        
        JScrollPane scrollPane = new JScrollPane(panelListe);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel creerLigneResultat(String titre, String entreprise, String lieu, String details, String salaire) {
        JPanel ligne = new JPanel(new BorderLayout());
        ligne.setBorder(new LineBorder(new Color(220, 220, 220), 1));
        ligne.setBackground(Color.WHITE);
        ligne.setPreferredSize(new Dimension(0, 80));
        ligne.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(Color.WHITE);
        
        JLabel lblTitre = new JLabel(titre);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 12));
        infoPanel.add(lblTitre);
        
        JLabel lblEntreprise = new JLabel(entreprise + " | " + lieu);
        lblEntreprise.setFont(new Font("Arial", Font.PLAIN, 11));
        infoPanel.add(lblEntreprise);
        
        JLabel lblDetails = new JLabel(details);
        lblDetails.setFont(new Font("Arial", Font.PLAIN, 11));
        infoPanel.add(lblDetails);
        
        JLabel lblSalaire = new JLabel("Salaire: " + salaire);
        lblSalaire.setFont(new Font("Arial", Font.BOLD, 11));
        lblSalaire.setForeground(new Color(76, 175, 80));
        infoPanel.add(lblSalaire);
        
        ligne.add(infoPanel, BorderLayout.CENTER);
        
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));
        actionPanel.setBackground(Color.WHITE);
        
        JButton btnDetails = new JButton("Détails");
        btnDetails.setBackground(new Color(0, 102, 204));
        btnDetails.setForeground(Color.WHITE);
        actionPanel.add(btnDetails);
        
        actionPanel.add(Box.createVerticalStrut(5));
        
        JButton btnCandidater = new JButton("Candidater");
        btnCandidater.setBackground(new Color(76, 175, 80));
        btnCandidater.setForeground(Color.WHITE);
        actionPanel.add(btnCandidater);
        
        ligne.add(actionPanel, BorderLayout.EAST);
        
        return ligne;
    }
}
