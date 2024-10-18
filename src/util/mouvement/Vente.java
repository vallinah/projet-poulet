package util.mouvement;

import java.time.LocalDate;

import util.elevage.Poulet;

public class Vente {
    private int id;
    private Poulet poulet;
    private double prixUnitaire;
    private LocalDate dateVente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Poulet getPoulet() {
        return poulet;
    }

    public void setPoulet(Poulet poulet) {
        this.poulet = poulet;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public LocalDate getDateVente() {
        return dateVente;
    }

    public void setDateVente(LocalDate dateVente) {
        this.dateVente = dateVente;
    }

    public Vente(int id, Poulet poulet, double prixUnitaire, LocalDate dateVente) {
        this.setId(id);
        this.setPoulet(poulet);
        this.setPrixUnitaire(prixUnitaire);
        this.setDateVente(dateVente);
    }

    public Vente() {
    }
}
