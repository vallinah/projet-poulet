package util.mouvement;

import java.time.LocalDate;

import util.fournisseur.Fournisseur;
import util.fournisseur.Produit;

public class MouvementProduit {
    private Mouvement mouvement;
    private Fournisseur fournisseur;
    private Produit produit;
    private double quantite;
    private double prix_unitaire;
    private LocalDate date_mouvement;

    public MouvementProduit(Mouvement mouvement, Fournisseur fournisseur, Produit produit, double quantite,
            double prix_unitaire, LocalDate date_mouvement) {
        this.setMouvement(mouvement);
        this.setFournisseur(fournisseur);
        this.setProduit(produit);
        this.setQuantite(quantite);
        this.setPrix_unitaire(prix_unitaire);
        this.setDate_mouvement(date_mouvement);
    }

    public Mouvement getMouvement() {
        return mouvement;
    }

    public void setMouvement(Mouvement mouvement) {
        this.mouvement = mouvement;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public LocalDate getDate_mouvement() {
        return date_mouvement;
    }

    public void setDate_mouvement(LocalDate date_mouvement) {
        this.date_mouvement = date_mouvement;
    }

}
