package util.comptabilite;

import java.time.LocalDate;

public class Demande {
    private int id;
    private int idDepartement;
    private double quantite;
    private String motif;
    private LocalDate dateDemande;

    public Demande(int id, int idDepartement, double quantite, String motif, LocalDate dateDemande) {
        this.id = id;
        this.idDepartement = idDepartement;
        this.quantite = quantite;
        this.motif = motif;
        this.dateDemande = dateDemande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public LocalDate getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(LocalDate dateDemande) {
        this.dateDemande = dateDemande;
    }
}
