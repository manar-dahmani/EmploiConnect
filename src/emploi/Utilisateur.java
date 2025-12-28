// ============================================================
// CLASSE 2 : CLASSE UTILISATEUR
// ============================================================

package emploi;

public class Utilisateur {
    private int id;
    private String email;
    private String motDePasse;
    private String role;
    private String statut;
    
    // Constructeur pour enregistrement
    public Utilisateur(String email, String motDePasse, String role) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
        this.statut = "actif";
    }
    
    // Constructeur pour requête
    public Utilisateur(int id, String email, String role, String statut) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.statut = statut;
    }
    
    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
}

