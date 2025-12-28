package emploi;

import java.sql.*;

public class Connexion_BD {
 private static Connection connexion;
 
 public static Connection getConnexion() throws SQLException {
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         connexion = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/emploi_connect",
             "root",
             ""  
         );
         
         System.out.println("✅ Connexion à la base de données réussie!");
         return connexion;
         
     } catch (ClassNotFoundException e) {
         System.out.println("❌ ERREUR: Driver MySQL non trouvé!");
         System.out.println("Solution: Ajouter mysql-connector-java.jar au projet");
         throw new SQLException("Driver MySQL manquant");
         
     } catch (SQLException e) {
         System.out.println("❌ ERREUR de connexion à MySQL:");
         System.out.println(e.getMessage());
         System.out.println("\nVérifier:");
         System.out.println("1. XAMPP est démarré (Apache et MySQL verts)");
         System.out.println("2. La base 'emploi_connect' existe");
         System.out.println("3. Le driver MySQL est dans le classpath");
         throw e;
     }
 }
 
 public static void fermer() {
     try {
         if(connexion != null && !connexion.isClosed()) {
             connexion.close();
             System.out.println("✅ Connexion fermée");
         }
     } catch(SQLException e) {
         e.printStackTrace();
     }
 }
}
