package emploi;

import java.sql.*;

public class UtilisateurDAO {
    
    // CRÉER un nouvel utilisateur (ENREGISTREMENT)
    public static boolean creerUtilisateur(Utilisateur user) {
        String sql = "INSERT INTO users (email, password, role, statut) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConnexionBD.getConnexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Remplacer les ? par les valeurs
            stmt.setString(1, user.getEmail());
            stmt.setString(2, hashPassword(user.getMotDePasse())); // Hasher le mot de passe
            stmt.setString(3, user.getRole());
            stmt.setString(4, "actif");
            
            // Exécuter la requête
            int rowsInserted = stmt.executeUpdate();
            
            if (rowsInserted > 0) {
                System.out.println("✅ Utilisateur créé avec succès!");
                return true;
            }
            
        } catch (SQLException e) {
            System.out.println("❌ ERREUR lors de la création de l'utilisateur:");
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    // VÉRIFIER l'email (éviter les doublons)
    public static boolean emailExiste(String email) {
        String sql = "SELECT id FROM users WHERE email = ?";
        
        try (Connection conn = ConnexionBD.getConnexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return true; // Email existe déjà
            }
            
        } catch (SQLException e) {
            System.out.println("❌ ERREUR lors de la vérification de l'email:");
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    // VÉRIFIER la connexion (LOGIN)
    public static Utilisateur verifierConnexion(String email, String motDePasse) {
        String sql = "SELECT id, email, role, statut FROM users WHERE email = ? AND password = ?";
        
        try (Connection conn = ConnexionBD.getConnexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            stmt.setString(2, hashPassword(motDePasse));
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("✅ Connexion réussie!");
                return new Utilisateur(
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("role"),
                    rs.getString("statut")
                );
            } else {
                System.out.println("❌ Email ou mot de passe incorrect");
            }
            
        } catch (SQLException e) {
            System.out.println("❌ ERREUR lors de la vérification:");
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    // OBTENIR tous les utilisateurs (pour test admin)
    public static void afficherTousLesUtilisateurs() {
        String sql = "SELECT id, email, role, statut FROM users";
        
        try (Connection conn = ConnexionBD.getConnexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n📋 === TOUS LES UTILISATEURS ===");
            System.out.println(String.format("%-5s %-25s %-15s %-10s", "ID", "EMAIL", "ROLE", "STATUT"));
            System.out.println("─".repeat(60));
            
            while (rs.next()) {
                System.out.println(String.format(
                    "%-5d %-25s %-15s %-10s",
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("role"),
                    rs.getString("statut")
                ));
            }
            
        } catch (SQLException e) {
            System.out.println("❌ ERREUR lors de la lecture:");
            System.out.println(e.getMessage());
        }
    }
    
    // Hash simple du mot de passe (à remplacer par BCrypt en production!)
    private static String hashPassword(String password) {
        // ATTENTION: C'est juste un test! En production, utiliser BCrypt
        return password; // Pour le test, pas de hash (à changer!)
    }
}
