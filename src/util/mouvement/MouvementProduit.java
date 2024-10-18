package util.mouvement;

import java.time.LocalDate;

import util.fournisseur.FournisseurProduit;

public class MouvementProduit {
    private int id;
    private boolean entree;
    private boolean sortie;
    private FournisseurProduit fournisseurProduit;
    private double quantite;
    private LocalDate dateMouvement;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEntree() {
        return entree;
    }

    public void setEntree(boolean entree) {
        this.entree = entree;
    }

    public boolean isSortie() {
        return sortie;
    }

    public void setSortie(boolean sortie) {
        this.sortie = sortie;
    }

    public FournisseurProduit getFournisseurProduit() {
        return fournisseurProduit;
    }

    public void setFournisseurProduit(FournisseurProduit fournisseurProduit) {
        this.fournisseurProduit = fournisseurProduit;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public LocalDate getDateMouvement() {
        return dateMouvement;
    }

    public void setDateMouvement(LocalDate dateMouvement) {
        this.dateMouvement = dateMouvement;
    }

    public MouvementProduit(int id, boolean entree, boolean sortie, FournisseurProduit fournisseurProduit,
            double quantite, LocalDate dateMouvement) {
        this.setId(id);
        this.setEntree(entree);
        this.setSortie(sortie);
        this.setFournisseurProduit(fournisseurProduit);
        this.setQuantite(quantite);
        this.setDateMouvement(dateMouvement);
    }

    public MouvementProduit() {
    }

}