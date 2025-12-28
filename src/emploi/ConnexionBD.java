package emploi;

import java.sql.*;

public class ConnexionBD {
    private static Connection connexion;
    
    public static Connection getConnexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/emploi_connect",
                "root",
                ""  // mot de passe vide par défaut dans XAMPP
            );
            return connexion;
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur: MySQL JDBC Driver non trouvé");
            throw new SQLException("Driver MySQL manquant");
        }
    }
    
    public static void fermer() {
        try {
            if(connexion != null && !connexion.isClosed()) {
                connexion.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}	