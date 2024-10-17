package util.mouvement;

import java.time.LocalDate;

import util.charge.Charge;

public class MouvementCharge {
    private Charge charge;
    private Mouvement mouvement;
    private double quantite;
    private LocalDate dateMouvement;

    public MouvementCharge(Charge charge, Mouvement mouvement, double quantite, LocalDate dateMouvement) {
        this.setCharge(charge);
        this.setMouvement(mouvement);
        this.setQuantite(quantite);
        this.setDateMouvement(dateMouvement);
    }

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }

    public Mouvement getMouvement() {
        return mouvement;
    }

    public void setMouvement(Mouvement mouvement) {
        this.mouvement = mouvement;
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
