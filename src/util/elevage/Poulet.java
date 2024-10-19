package util.elevage;

public class Poulet {
    private int id;
    private double poids_initial;
    private double poids_final;
    private Elevage elevage;

    public Poulet(){}

    public Poulet(int id, double poids_initial, double poids_final, Elevage elevage) {
        this.setId(id);
        this.setPoids_initial(poids_initial);
        this.setPoids_final(poids_final);
        this.setElevage(elevage);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPoids_initial() {
        return poids_initial;
    }

    public void setPoids_initial(double poids_initial) {
        this.poids_initial = poids_initial;
    }

    public double getPoids_final() {
        return poids_final;
    }

    public void setPoids_final(double poids_final) {
        this.poids_final = poids_final;
    }

    public Elevage getElevage() {
        return elevage;
    }

    public void setElevage(Elevage elevage) {
        this.elevage = elevage;
    }

}