package util.elevage;

import java.time.LocalDate;

public class Elevage {
    private int id_elevage;
    private LocalDate date_debut;
    private int duree_cycle;

    public Elevage(int id_elevage, LocalDate date_debut, int duree_cycle) {
        this.setId_elevage(id_elevage);
        this.setDate_debut(date_debut);
        this.setDuree_cycle(duree_cycle);
    }

    public int getId_elevage() {
        return id_elevage;
    }

    public void setId_elevage(int id_elevage) {
        this.id_elevage = id_elevage;
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
