package util.elevage;

import java.sql.Date;

public class Elevage {
    private int id;
    private Date dateDebut;
    private int dureeCycle;

    public Elevage(int id, Date dateDebut, int dureeCycle) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dureeCycle = dureeCycle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDureeCycle() {
        return dureeCycle;
    }

    public void setDureeCycle(int dureeCycle) {
        this.dureeCycle = dureeCycle;
    }
}

