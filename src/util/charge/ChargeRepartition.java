package util.charge;

public class ChargeRepartition {
    private int id;
    private double pourcentage_demarrage;
    private double pourcentage_transition;
    private double pourcentage_finition;
    private Charge charge;
    
    public ChargeRepartition(int id, double pourcentage_demarrage, double pourcentage_transition,
            double pourcentage_finition, Charge charge) {
        this.setId(id);
        this.setPourcentage_demarrage(pourcentage_demarrage);
        this.setPourcentage_finition(pourcentage_finition);
        this.setPourcentage_transition(pourcentage_transition);
        this.setCharge(charge);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getPourcentage_demarrage() {
        return pourcentage_demarrage;
    }
    public void setPourcentage_demarrage(double pourcentage_demarrage) {
        this.pourcentage_demarrage = pourcentage_demarrage;
    }
    public double getPourcentage_transition() {
        return pourcentage_transition;
    }
    public void setPourcentage_transition(double pourcentage_transition) {
        this.pourcentage_transition = pourcentage_transition;
    }
    public double getPourcentage_finition() {
        return pourcentage_finition;
    }
    public void setPourcentage_finition(double pourcentage_finition) {
        this.pourcentage_finition = pourcentage_finition;
    }
    public Charge getCharge() {
        return charge;
    }
    public void setCharge(Charge charge) {
        this.charge = charge;
    }
    
}