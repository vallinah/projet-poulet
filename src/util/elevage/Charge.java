package util.elevage;

import java.math.BigDecimal;

public class Charge {
    private int id;
    private String nom;
    private BigDecimal prixUnitaire;
    private String uniteOeuvre;
    private int idTypeCharge;
    private int idChargeAnalytique;
    private int idAnalytiqueCout;

    public Charge(int id, String nom, BigDecimal prixUnitaire, String uniteOeuvre, 
                  int idTypeCharge, int idChargeAnalytique, int idAnalytiqueCout) {
        this.id = id;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.uniteOeuvre = uniteOeuvre;
        this.idTypeCharge = idTypeCharge;
        this.idChargeAnalytique = idChargeAnalytique;
        this.idAnalytiqueCout = idAnalytiqueCout;
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

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getUniteOeuvre() {
        return uniteOeuvre;
    }

    public void setUniteOeuvre(String uniteOeuvre) {
        this.uniteOeuvre = uniteOeuvre;
    }

    public int getIdTypeCharge() {
        return idTypeCharge;
    }

    public void setIdTypeCharge(int idTypeCharge) {
        this.idTypeCharge = idTypeCharge;
    }

    public int getIdChargeAnalytique() {
        return idChargeAnalytique;
    }

    public void setIdChargeAnalytique(int idChargeAnalytique) {
        this.idChargeAnalytique = idChargeAnalytique;
    }

    public int getIdAnalytiqueCout() {
        return idAnalytiqueCout;
    }

    public void setIdAnalytiqueCout(int idAnalytiqueCout) {
        this.idAnalytiqueCout = idAnalytiqueCout;
    }
}

