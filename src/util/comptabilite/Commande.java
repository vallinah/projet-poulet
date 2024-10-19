package util.comptabilite;

import java.time.LocalDate;

import util.fournisseur.Fournisseur;

public class Commande {
    private Demande demande;
    private Fournisseur fournisseur;
    private LocalDate dateCommande;

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Commande(Demande demande, Fournisseur fournisseur, LocalDate dateCommande) {
        this.setDemande(demande);
        this.setFournisseur(fournisseur);
        this.setDateCommande(dateCommande);
    }

    public Commande() {
    }

}