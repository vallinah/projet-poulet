package dao.charge;

import connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.comptabilite.ChargeAnalytique;

public class ChargeAnalytiqueDAO {

    private Connexion connexion = new Connexion();

    public void insert(ChargeAnalytique chargeAnalytique) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO charge_analytique (nom) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, chargeAnalytique.getNom());
            stmt.executeUpdate();
            System.out.println("Charge analytique insérée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void update(ChargeAnalytique chargeAnalytique) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE charge_analytique SET nom=? WHERE id_charge_analytique=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, chargeAnalytique.getNom());
            stmt.setInt(2, chargeAnalytique.getId());
            stmt.executeUpdate();
            System.out.println("Charge analytique mise à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM charge_analytique WHERE id_charge_analytique=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Charge analytique supprimée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public List<ChargeAnalytique> getAll() {
        List<ChargeAnalytique> charges = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM charge_analytique";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ChargeAnalytique charge = new ChargeAnalytique();
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

    public ChargeAnalytique getById(int id) {
        ChargeAnalytique charge = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM charge_analytique WHERE id_charge_analytique=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                charge = new ChargeAnalytique();
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
}
