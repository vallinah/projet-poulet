package util.mouvement;

import java.time.LocalDate;

import util.elevage.Poulet;

public class MouvementPoulet {
    private Poulet poulet;
    private Mouvement mouvement;
    private double quantite;
    private LocalDate dateMouvement;

    public MouvementPoulet(Poulet poulet, Mouvement mouvement, double quantite, LocalDate dateMouvement) {
        this.setPoulet(poulet);
        this.setMouvement(mouvement);
        this.setQuantite(quantite);
        this.setDateMouvement(dateMouvement);
    }
    public Poulet getPoulet() {
        return poulet;
    }
    public void setPoulet(Poulet poulet) {
        this.poulet = poulet;
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
