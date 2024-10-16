package util.comptabilite;

import java.math.BigDecimal;
import java.sql.Date;

public class Demande {
    private int id;
    private int idDepartement;
    private BigDecimal quantite;
    private String motif;
    private Date dateDemande;

    public Demande(int id, int idDepartement, BigDecimal quantite, String motif, Date dateDemande) {
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

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }
}

