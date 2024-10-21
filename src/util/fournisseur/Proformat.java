package util.fournisseur;

public class Proformat {
    private Produit produit;           // Attribut pour l'objet Produit
    private Fournisseur fournisseur;    // Attribut pour l'objet Fournisseur
    private double quantite;            // Attribut pour la quantité
    private double prixUnitaire;        // Attribut pour le prix unitaire

    // Constructeur
    public Proformat(Produit produit, Fournisseur fournisseur, double quantite, double prixUnitaire) {
        this.produit = produit;
        this.fournisseur = fournisseur;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
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

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
