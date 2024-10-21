package util.fournisseur;

public class FournisseurProduit {
    private int id;
    private Fournisseur fournisseur;
    private Produit Produit;
    private double prixUnitaire;
    private String uniteOeuvre;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Produit getProduit() {
        return Produit;
    }

    public void setProduit(Produit produit) {
        Produit = produit;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getUniteOeuvre() {
        return uniteOeuvre;
    }

    public void setUniteOeuvre(String uniteOeuvre) {
        this.uniteOeuvre = uniteOeuvre;
    }

    public FournisseurProduit(int id, Fournisseur fournisseur, util.fournisseur.Produit produit, double prixUnitaire,
            String uniteOeuvre) {
        this.setId(id);
        this.setFournisseur(fournisseur);
        this.setProduit(produit);
        this.setPrixUnitaire(prixUnitaire);
        this.setUniteOeuvre(uniteOeuvre);
    }

    public FournisseurProduit() {
    }

}