package util.elevage;

import java.time.LocalDate;

public class Elevage {
    private int id;
    private LocalDate date_debut;
    private int duree_cycle;

    public Elevage(int id, LocalDate date_debut, int duree_cycle) {
        this.setId(id);
        this.setDate_debut(date_debut);
        this.setDuree_cycle(duree_cycle);
    }

    public Elevage() {
        //TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public int getDuree_cycle() {
        return duree_cycle;
    }

    public void setDuree_cycle(int duree_cycle) {
        this.duree_cycle = duree_cycle;
    }
}
