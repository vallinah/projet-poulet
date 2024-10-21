package dao.fournisseur;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import util.fournisseur.*;

public class DemandeDAO {
    private Connexion connexion = new Connexion();
    private ProformatDAO pro = new ProformatDAO();

    // Méthode pour récupérer toutes les demandes d'un fournisseur
    public List<Demande> getAllDemandeFournisseur(int idFournisseur) {
        List<Demande> demandes = new ArrayList<>();
        String sql = "SELECT id_charge, quantite, id_fournisseur, date_demande " +
                     "FROM demande " +
                     "WHERE id_demande IN ( " +
                     "    SELECT id_demande " +
                     "    FROM commande " +
                     "    WHERE id_fournisseur = ? " +
                     ")";

        try (Connection con = connexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idFournisseur);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int idCharge = rs.getInt("id_charge");
                    double quantite = rs.getDouble("quantite");
                    int idFournisseurRes = rs.getInt("id_fournisseur");
                    Date dateDemande = rs.getDate("date_demande");

                    Demande demande = new Demande(idCharge, quantite, idFournisseurRes, dateDemande);
                    demandes.add(demande);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return demandes;
    }

    // Méthode pour ajuster le stock en fonction des demandes
    public void ajusterStock(int idFournisseur) {
        // Récupérer les demandes pour le fournisseur
        List<Demande> demandes = getAllDemandeFournisseur(idFournisseur);

        // Parcourir chaque demande
        for (Demande demande : demandes) {
            int idCharge = demande.getIdCharge();
            double quantiteDemandee = demande.getQuantite();

            // Récupérer les informations sur le stock du produit
            List<Proformat> proformats = pro.getById(idFournisseur);
            Proformat proformatChoisi = null;

            for (Proformat proformat : proformats) {
                if (proformat.getProduit().getId() == idCharge) {
                    proformatChoisi = proformat;
                    break;
                }
            }

            // Si le produit demandé n'existe pas dans les stocks du fournisseur, on passe à la prochaine demande
            if (proformatChoisi == null) {
                continue;
            }

            double quantiteDisponible = proformatChoisi.getQuantite();

            // Calculer la quantité à diminuer
            double quantiteADiminuer = Math.min(quantiteDemandee, quantiteDisponible);

            // Si la quantité à diminuer est supérieure à zéro, ajuster le stock
            if (quantiteADiminuer > 0) {
                // Diminuer le stock dans la table mouvement_produit_fournisseur
                mettreAJourStock(proformatChoisi.getFournisseur().getId(), quantiteADiminuer);
            }
        }
    }

    // Méthode pour diminuer le stock dans la table mouvement_produit_fournisseur
    private void mettreAJourStock(int idFournisseurProduit, double quantiteADiminuer) {
        String sql = "INSERT INTO mouvement_produit_fournisseur (entree, sortie, id_fournisseur_produit, quantite, date_mouvement) " +
                     "VALUES (false, true, ?, ?, CURRENT_DATE)";

        try (Connection conn = connexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idFournisseurProduit);
            pstmt.setDouble(2, quantiteADiminuer);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
