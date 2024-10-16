package util.elevage;

import java.math.BigDecimal;
import java.sql.Date;

public class Mouvement {
    private int id;
    private int idCharge;
    private BigDecimal quantite;
    private Date dateMouvement;
    private int mouvement;

    public Mouvement(int id, int idCharge, BigDecimal quantite, Date dateMouvement, int mouvement) {
        this.id = id;
        this.idCharge = idCharge;
        this.quantite = quantite;
        this.dateMouvement = dateMouvement;
        this.mouvement = mouvement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCharge() {
        return idCharge;
    }

    public void setIdCharge(int idCharge) {
        this.idCharge = idCharge;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    public Date getDateMouvement() {
        return dateMouvement;
    }

    public void setDateMouvement(Date dateMouvement) {
        this.dateMouvement = dateMouvement;
    }

    public int getMouvement() {
        return mouvement;
    }

    public void setMouvement(int mouvement) {
        this.mouvement = mouvement;
    }
}

