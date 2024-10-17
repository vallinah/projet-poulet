package util.mouvement;

public class Mouvement {
    private int id;
    private String mouvement;
    
    public Mouvement(int id, String mouvement) {
        this.setId(id);
        this.setMouvement(mouvement);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMouvement() {
        return mouvement;
    }
    public void setMouvement(String mouvement) {
        this.mouvement = mouvement;
    }

}