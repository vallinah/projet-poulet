package util.fournisseur;

public class Fournisseur {
    private int id;
    private String nom;
    private String email;
    private String motDePasse;

    public Fournisseur() {
    }

    public Fournisseur(int id, String nom, String email, String motDePasse) {
        this.setId(id);
        this.setNom(nom);
        this.setEmail(email);
        this.setMotDePasse(motDePasse);
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

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
