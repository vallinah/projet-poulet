package util.elevage;

import java.math.BigDecimal;

public class ChargeRepartition {
    private int id;
    private int idCharge;
    private BigDecimal pourcentageDemarrage;
    private BigDecimal pourcentageTransition;
    private BigDecimal pourcentageFinition;

    public ChargeRepartition(int id, int idCharge, BigDecimal pourcentageDemarrage, 
                             BigDecimal pourcentageTransition, BigDecimal pourcentageFinition) {
        this.id = id;
        this.idCharge = idCharge;
        this.pourcentageDemarrage = pourcentageDemarrage;
        this.pourcentageTransition = pourcentageTransition;
        this.pourcentageFinition = pourcentageFinition;
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

    public BigDecimal getPourcentageDemarrage() {
        return pourcentageDemarrage;
    }

    public void setPourcentageDemarrage(BigDecimal pourcentageDemarrage) {
        this.pourcentageDemarrage = pourcentageDemarrage;
    }

    public BigDecimal getPourcentageTransition() {
        return pourcentageTransition;
    }

    public void setPourcentageTransition(BigDecimal pourcentageTransition) {
        this.pourcentageTransition = pourcentageTransition;
    }

    public BigDecimal getPourcentageFinition() {
        return pourcentageFinition;
    }

    public void setPourcentageFinition(BigDecimal pourcentageFinition) {
        this.pourcentageFinition = pourcentageFinition;
    }
}
