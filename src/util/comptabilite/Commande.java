package util.comptabilite;

public class Commande {
    private int id;
    private int idDemande;
    private int idFournisseur;

    public Commande(int id, int idDemande, int idFournisseur) {
        this.id = id;
        this.idDemande = idDemande;
        this.idFournisseur = idFournisseur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }
}

