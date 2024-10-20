package util.mouvement;

import java.time.LocalDate;

import util.charge.Charge;

public class MouvementCharge {
    private int id;
    private Charge charge;
    private boolean entree;
    private boolean sortie;
    private double quantite;
    private LocalDate dateMouvement;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public MouvementCharge() {
    }

    public MouvementCharge(int id,Charge charge, boolean entree, boolean sortie, double quantite, LocalDate dateMouvement) {
        this.setCharge(charge);
        this.setEntree(entree);
        this.setSortie(sortie);
        this.setQuantite(quantite);
        this.setDateMouvement(dateMouvement);
    }

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }

    public boolean getEntree() {
        return entree;
    }

    public void setEntree(boolean entree) {
        this.entree = entree;
    }

    public boolean getSortie() {
        return sortie;
    }

    public void setSortie(boolean sortie) {
        this.sortie = sortie;
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

}
