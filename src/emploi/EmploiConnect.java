package emploi;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EmploiConnect extends JFrame {
    
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private String utilisateurActuel = null;
    private String roleActuel = null;
    
    public EmploiConnect() {
        setTitle("EMPLOI-CONNECT - Site de Recherche d'Emploi");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // CardLayout pour naviguer entre les écrans
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);
        
        // Créer tous les écrans
        panelPrincipal.add(new EcranLogin(this), "LOGIN");
        panelPrincipal.add(new EcranAccueilChercheur(this), "ACCUEIL_CHERCHEUR");
        panelPrincipal.add(new EcranRecherche(this), "RECHERCHE");
        panelPrincipal.add(new EcranProfilChercheur(this), "PROFIL_CHERCHEUR");
        panelPrincipal.add(new EcranAccueilRecruteur(this), "ACCUEIL_RECRUTEUR");
        panelPrincipal.add(new EcranDashboardAdmin(this), "DASHBOARD_ADMIN");
        
        add(panelPrincipal);
        setVisible(true);
        
        // Afficher l'écran de login
        afficherEcran("LOGIN");
    }
    
    public void afficherEcran(String nomEcran) {
        cardLayout.show(panelPrincipal, nomEcran);
    }
    
    public void setUtilisateur(String utilisateur, String role) {
        this.utilisateurActuel = utilisateur;
        this.roleActuel = role;
    }
    
    public String getUtilisateur() {
        return utilisateurActuel;
    }
    
    public String getRole() {
        return roleActuel;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmploiConnect());
    }
}