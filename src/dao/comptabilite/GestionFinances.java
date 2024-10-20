package dao.comptabilite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionFinances {
    private Connection connection;

    public GestionFinances(Connection connection) {
        this.connection = connection;
    }

    public double calculerChiffreAffaire() throws SQLException {
        String sql = "SELECT SUM(mq.quantite * fp.prix_unitaire) AS chiffre_affaire " +
                     "FROM mouvement_produit_fournisseur mq " +
                     "JOIN fournisseur_produit fp ON mq.id_fournisseur_produit = fp.id_fournisseur_produit " +
                     "WHERE mq.entree = TRUE";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble("chiffre_affaire");
            }
        }
        return 0;
    }

    public double calculerTotalCout() throws SQLException {
        String sql = "SELECT SUM(c.prix_unitaire * mc.quantite) AS total_cout " +
                     "FROM mouvement_charge mc " +
                     "JOIN charge c ON mc.id_charge = c.id_charge " +
                     "WHERE mc.entree = TRUE";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble("total_cout");
            }
        }
        return 0;
    }

    public double calculerPrixUnitaireVente() throws SQLException {
        String sql = "SELECT AVG(fp.prix_unitaire) AS prix_unitaire_vente " +
                     "FROM fournisseur_produit fp";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble("prix_unitaire_vente");
            }
        }
        return 0;
    }

    public double calculerBenefice() throws SQLException {
        String sql = "SELECT (SUM(mq.quantite * fp.prix_unitaire) - SUM(c.prix_unitaire * mc.quantite)) AS benefice " +
                     "FROM mouvement_produit_fournisseur mq " +
                     "JOIN fournisseur_produit fp ON mq.id_fournisseur_produit = fp.id_fournisseur_produit " +
                     "JOIN mouvement_charge mc ON mc.id_charge = fp.id_produit " +
                     "JOIN charge c ON mc.id_charge = c.id_charge " +
                     "WHERE mq.entree = TRUE AND mc.entree = TRUE";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble("benefice");
            }
        }
        return 0;
    }

    public double calculerSeuilRentabilite() throws SQLException {
        String sql = "SELECT COALESCE(NULLIF(SUM(c.prix_unitaire * mc.quantite), 0), 1) AS seuil_rentabilite " +
                     "FROM mouvement_charge mc " +
                     "JOIN charge c ON mc.id_charge = c.id_charge " +
                     "WHERE mc.entree = TRUE";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble("seuil_rentabilite");
            }
        }
        return 0;
    }
}

