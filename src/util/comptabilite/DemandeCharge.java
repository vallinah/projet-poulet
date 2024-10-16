package util.comptabilite;

public class DemandeCharge {
    private int id;
    private int idDemande;
    private int idCharge;

    public DemandeCharge(int id, int idDemande, int idCharge) {
        this.id = id;
        this.idDemande = idDemande;
        this.idCharge = idCharge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public int getIdCharge() {
        return idCharge;
    }

    public void setIdCharge(int idCharge) {
        this.idCharge = idCharge;
    }
}

