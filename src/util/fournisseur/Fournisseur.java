package util.fournisseur;

public class Fournisseur {
    private int id;
    private String nom;
    private String email;
    private String motDePasse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Fournisseur() {
    }

    public Fournisseur(int id, String nom, String email, String motDePasse) {
        this.setId(id);
        this.setNom(nom);
        this.setEmail(email);
        this.setMotDePasse(motDePasse);
    }



}
