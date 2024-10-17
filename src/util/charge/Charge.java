package util.charge;

import util.comptabilite.AnalytiqueDesCouts;
import util.comptabilite.ChargeAnalytique;

public class Charge {
    private int id;
    private String nom;
    private double prix_unitaire;
    private String unite_oeuvre;
    private ChargeAnalytique chargeAnalytique;
    private AnalytiqueDesCouts analytiqueDesCouts;
    private TypeCharge typeCharge;

    
    public Charge(int id, String nom, double prix_unitaire, String unite_oeuvre, ChargeAnalytique chargeAnalytique,
            AnalytiqueDesCouts analytiqueDesCouts, TypeCharge typeCharge) {
        this.setId(id);
        this.setNom(nom);
        this.setPrix_unitaire(prix_unitaire);
        this.setUnite_oeuvre(unite_oeuvre);
        this.setAnalytiqueDesCouts(analytiqueDesCouts);
        this.setChargeAnalytique(chargeAnalytique);
        this.setTypeCharge(typeCharge);
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
    public double getPrix_unitaire() {
        return prix_unitaire;
    }
    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }
    public String getUnite_oeuvre() {
        return unite_oeuvre;
    }
    public void setUnite_oeuvre(String unite_oeuvre) {
        this.unite_oeuvre = unite_oeuvre;
    }
    public ChargeAnalytique getChargeAnalytique() {
        return chargeAnalytique;
    }
    public void setChargeAnalytique(ChargeAnalytique chargeAnalytique) {
        this.chargeAnalytique = chargeAnalytique;
    }
    public AnalytiqueDesCouts getAnalytiqueDesCouts() {
        return analytiqueDesCouts;
    }
    public void setAnalytiqueDesCouts(AnalytiqueDesCouts analytiqueDesCouts) {
        this.analytiqueDesCouts = analytiqueDesCouts;
    }
    public TypeCharge getTypeCharge() {
        return typeCharge;
    }
    public void setTypeCharge(TypeCharge typeCharge) {
        this.typeCharge = typeCharge;
    }
    
}