package util.fournisseur;

public class Produit {
    private int id;
    private String nom;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Produit(int id, String nom,String description) {
        this.setId(id);
        this.setNom(nom);
        this.setDescription(description);
    }

    public Produit() {
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
