package util.fournisseur;

public class Demande {
    private int idCharge;
    private double quantite;
    private int idFournisseur;
    private java.sql.Date dateDemande;

    public Demande() {
    }

    // Constructeur avec paramètres
    public Demande(int idCharge, double quantite, int idFournisseur, java.sql.Date dateDemande) {
        this.idCharge = idCharge;
        this.quantite = quantite;
        this.idFournisseur = idFournisseur;
        this.dateDemande = dateDemande;
    }

    // Getters et Setters
    public int getIdCharge() {
        return idCharge;
    }

    public void setIdCharge(int idCharge) {
        this.idCharge = idCharge;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public java.sql.Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(java.sql.Date dateDemande) {
        this.dateDemande = dateDemande;
    }
}

