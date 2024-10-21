package util.charge;

public class TypeCharge {
    private int id;
    private String nom;

    public TypeCharge(int id, String nom) {
        this.setId(id);
        this.setNom(nom);
    }

    public TypeCharge() {
        //TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
