package util.fournisseur;

import java.math.BigDecimal;

public class FournisseurProduit {
    private int id;
    private String nom;
    private int idFournisseur;
    private BigDecimal prixUnitaire;
    private String descriptionProduit;

    public FournisseurProduit(int id, String nom, int idFournisseur, BigDecimal prixUnitaire, String descriptionProduit) {
        this.id = id;
        this.nom = nom;
        this.idFournisseur = idFournisseur;
        this.prixUnitaire = prixUnitaire;
        this.descriptionProduit = descriptionProduit;
    }

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

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getDescriptionProduit() {
        return descriptionProduit;
    }

    public void setDescriptionProduit(String descriptionProduit) {
        this.descriptionProduit = descriptionProduit;
    }
}

