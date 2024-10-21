package util.fournisseur;

import java.sql.Date;


public class ProduitLivrer {
    private Produit produit;      // Référence à l'objet Produit
    private Fournisseur fournisseur; // Référence à l'objet Fournisseur
    private double quantite;      // Quantité livrée
    private Date dateMouvement;   // Date de la livraison

    // Constructeur
    public ProduitLivrer(Produit produit, Fournisseur fournisseur, double quantite, Date dateMouvement) {
        this.produit = produit;
        this.fournisseur = fournisseur;
        this.quantite = quantite;
        this.dateMouvement = dateMouvement;
    }

    // Getters et Setters
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public Date getDateMouvement() {
        return dateMouvement;
    }

    public void setDateMouvement(Date dateMouvement) {
        this.dateMouvement = dateMouvement;
    }
}
