package util.comptabilite;

public class AnalytiqueDesCouts {
    private int id;
    private String nom;

    public AnalytiqueDesCouts() {
    }

    public AnalytiqueDesCouts(int id, String nom) {
        this.setId(id);
        this.setNom(nom);
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

