package util.comptabilite;

public class FactureCharge {
    private int id;
    private int idFacture;
    private int idCharge;

    public FactureCharge(int id, int idFacture, int idCharge) {
        this.id = id;
        this.idFacture = idFacture;
        this.idCharge = idCharge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public int getIdCharge() {
        return idCharge;
    }

    public void setIdCharge(int idCharge) {
        this.idCharge = idCharge;
    }
}

