package util.fournisseur;

public class Fournisseur {
    private int idFournisseur;
    private String nomFournisseur;
    private String email;
    private String motDePasse;

    public Fournisseur(int idFournisseur, String nomFournisseur, String email, String motDePasse) {
        this.idFournisseur = idFournisseur;
        this.nomFournisseur = nomFournisseur;
        this.email = email;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
