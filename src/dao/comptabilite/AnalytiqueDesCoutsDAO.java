package dao.charge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import util.comptabilite.AnalytiqueDesCouts;


public class AnalytiqueDesCoutsDAO {
    Connexion connexion;
    // Méthode pour obtenir tous les charges analytiques
    public List<AnalytiqueDesCouts> getAll() {
        List<AnalytiqueDesCouts> charges = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM charge_analytique";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                AnalytiqueDesCouts charge = new AnalytiqueDesCouts();
                charge.setId(rs.getInt("id_charge_analytique"));
                charge.setNom(rs.getString("nom"));
                charges.add(charge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return charges;
    }

    // Méthode pour obtenir un charge analytique par ID
    public AnalytiqueDesCouts getById(int id) {
        AnalytiqueDesCouts charge = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM charge_analytique WHERE id_charge_analytique=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                charge = new AnalytiqueDesCouts();
                charge.setId(rs.getInt("id_charge_analytique"));
                charge.setNom(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return charge;
    }

    // Méthode pour insérer un charge analytique
    public void insert(AnalytiqueDesCouts charge) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO charge_analytique(nom) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, charge.getNom());
            stmt.executeUpdate();
            System.out.println("Charge analytique insérée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour mettre à jour un charge analytique existant
    public void update(AnalytiqueDesCouts charge) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE charge_analytique SET nom=? WHERE id_charge_analytique=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, charge.getNom());
            stmt.setInt(2, charge.getId());
            stmt.executeUpdate();
            System.out.println("Charge analytique mise à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }
}
