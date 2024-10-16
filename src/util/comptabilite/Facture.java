package util.comptabilite;

import java.sql.Date;

public class Facture {
    private int id;
    private int idCommande;
    private Date dateFacture;

    public Facture(int id, int idCommande, Date dateFacture) {
        this.id = id;
        this.idCommande = idCommande;
        this.dateFacture = dateFacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }
}

