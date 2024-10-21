package dao.comptabilite;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionFinances {
    private static Connexion connexion = new Connexion();

    public double getTotalCout(int idElevage) {
        double totalCout = 0;
        String sql = "SELECT SUM(c.prix_unitaire * d.quantite) AS total_cout " +
                     "FROM depense d " +
                     "JOIN charge c ON d.id_charge = c.id " +
                     "WHERE d.id_elevage = ?";
        try (Connection conn = connexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idElevage);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalCout = rs.getDouble("total_cout");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalCout;
    }

    public double getPrixUnitaireVente(int idElevage) {
        // Remplacez cette méthode par la logique appropriée pour calculer le prix unitaire de vente
        double prixUnitaireVente = 0;
        // Implémentez la logique ici
        return prixUnitaireVente;
    }

    public double getBenefice(int idElevage) {
        double totalCout = getTotalCout(idElevage);
        double totalVente = getChiffreAffaire(idElevage); // Utilisation de la méthode getChiffreAffaire
        return totalVente - totalCout;
    }

    public double getCoutVariableUnitaire(int idElevage) {
        double coutVariableUnitaire = 0;
        String sql = "SELECT SUM(c.prix_unitaire * d.quantite) AS cout_variable " +
                    "FROM depense d " +
                    "JOIN charge c ON d.id_charge = c.id " +
                    "WHERE d.id_elevage = ? AND c.type_charge = 'Variable'"; // Assurez-vous que 'Variable' correspond au type de charge variable
        try (Connection conn = connexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idElevage);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                coutVariableUnitaire = rs.getDouble("cout_variable");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coutVariableUnitaire;
    }

    public double getCoutFixeUnitaire(int idElevage) {
        double coutVariableUnitaire = 0;
        String sql = "SELECT SUM(c.prix_unitaire * d.quantite) AS cout_fixe " +
                    "FROM depense d " +
                    "JOIN charge c ON d.id_charge = c.id " +
                    "WHERE d.id_elevage = ? AND c.type_charge = 'fixe'"; // Assurez-vous que 'Variable' correspond au type de charge variable
        try (Connection conn = connexion.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idElevage);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                coutVariableUnitaire = rs.getDouble("cout_fixe");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coutVariableUnitaire;
    }


    public double getSeuilRentabilite(int idElevage) {
        double totalCout = getTotalCout(idElevage);
        double prixUnitaireVente = getPrixUnitaireVente(idElevage);
        double coutVariableUnitaire = getCoutVariableUnitaire(idElevage);
    
        if (prixUnitaireVente > coutVariableUnitaire) {
            return totalCout / (prixUnitaireVente - coutVariableUnitaire);
        } else {
            return Double.POSITIVE_INFINITY; // Seuil de rentabilité non atteignable
        }
    }    

    public double getChiffreAffaire(int idElevage) {
        double chiffreAffaire = 0;
        String sql = "SELECT SUM(v.prix_vente * v.quantite) AS chiffre_affaire " +
                     "FROM vente v " +
                     "WHERE v.id_elevage = ?";
        try (Connection conn = connexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idElevage);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                chiffreAffaire = rs.getDouble("chiffre_affaire");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiffreAffaire;
    }

    public double getMargeGlobale(int idElevage) {
        double chiffreAffaire = getChiffreAffaire(idElevage);
        double totalCout = getTotalCout(idElevage);
        return chiffreAffaire - totalCout;
    }

    // Méthode pour calculer la Marge sur Coût Variable (MCV)
    public double getMargeSurCoutVariable(int idElevage) {
        double chiffreAffaire = getChiffreAffaire(idElevage);
        double coutVariableTotal = getCoutVariableUnitaire(idElevage); // Assurez-vous que cela retourne le total
        return chiffreAffaire - coutVariableTotal;
    }

    // Méthode pour calculer la Marge sur Coût Fixe (MCF)
    public double getMargeSurCoutFixe(int idElevage) {
        double chiffreAffaire = getChiffreAffaire(idElevage);
        double coutFixeTotal = getCoutFixeUnitaire(idElevage); // Implémentez cette méthode pour obtenir le coût fixe total
        return chiffreAffaire - coutFixeTotal;
    }
}
