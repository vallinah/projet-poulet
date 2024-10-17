package util.charge;

public class TypeCharge {
    private int id_type_charge;
    private String nom;
    
    public TypeCharge(int id_type_charge, String nom) {
        this.setId_type_charge(id_type_charge);
        this.setNom(nom);
    }
    public int getId_type_charge() {
        return id_type_charge;
    }
    public void setId_type_charge(int id_type_charge) {
        this.id_type_charge = id_type_charge;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
