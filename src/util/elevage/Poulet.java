package util.elevage;

import java.math.BigDecimal;

public class Poulet {
    private int id;
    private BigDecimal poidsInitial;
    private BigDecimal poidsFinal;
    private int idElevage;

    public Poulet(int id, BigDecimal poidsInitial, BigDecimal poidsFinal, int idElevage) {
        this.id = id;
        this.poidsInitial = poidsInitial;
        this.poidsFinal = poidsFinal;
        this.idElevage = idElevage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPoidsInitial() {
        return poidsInitial;
    }

    public void setPoidsInitial(BigDecimal poidsInitial) {
        this.poidsInitial = poidsInitial;
    }

    public BigDecimal getPoidsFinal() {
        return poidsFinal;
    }

    public void setPoidsFinal(BigDecimal poidsFinal) {
        this.poidsFinal = poidsFinal;
    }

    public int getIdElevage() {
        return idElevage;
    }

    public void setIdElevage(int idElevage) {
        this.idElevage = idElevage;
    }
}

