package util.fournisseur;

import java.sql.Date;

public class FactureProduit {
    private String nomFournisseur;
    private String nomProduit;
    private double quantiteTotale;
    private double totalFacture;
    private Date datePremiereLivraison;
    private Date dateDerniereLivraison;

    public FactureProduit(String nomFournisseur, String nomProduit, double quantiteTotale, double totalFacture, Date datePremiereLivraison, Date dateDerniereLivraison) {
        this.nomFournisseur = nomFournisseur;
        this.nomProduit = nomProduit;
        this.quantiteTotale = quantiteTotale;
        this.totalFacture = totalFacture;
        this.datePremiereLivraison = datePremiereLivraison;
        this.dateDerniereLivraison = dateDerniereLivraison;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getQuantiteTotale() {
        return quantiteTotale;
    }

    public void setQuantiteTotale(double quantiteTotale) {
        this.quantiteTotale = quantiteTotale;
    }

    public double getTotalFacture() {
        return totalFacture;
    }

    public void setTotalFacture(double totalFacture) {
        this.totalFacture = totalFacture;
    }

    public Date getDatePremiereLivraison() {
        return datePremiereLivraison;
    }

    public void setDatePremiereLivraison(Date datePremiereLivraison) {
        this.datePremiereLivraison = datePremiereLivraison;
    }

    public Date getDateDerniereLivraison() {
        return dateDerniereLivraison;
    }

    public void setDateDerniereLivraison(Date dateDerniereLivraison) {
        this.dateDerniereLivraison = dateDerniereLivraison;
    }

    // Getters et Setters
    // ...

    // Vous pouvez également ajouter des méthodes pour afficher ou formater la facture
}
