package util.fournisseur;

import java.math.BigDecimal;
import java.sql.Date;

public class FournisseurStock {
    private int id;
    private int idFournisseurProduit;
    private BigDecimal quantite;
    private Date dateMouvement;
    private int mouvement;

    public FournisseurStock(int id, int idFournisseurProduit, BigDecimal quantite, Date dateMouvement, int mouvement) {
        this.id = id;
        this.idFournisseurProduit = idFournisseurProduit;
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

    public int getIdFournisseurProduit() {
        return idFournisseurProduit;
    }

    public void setIdFournisseurProduit(int idFournisseurProduit) {
        this.idFournisseurProduit = idFournisseurProduit;
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

