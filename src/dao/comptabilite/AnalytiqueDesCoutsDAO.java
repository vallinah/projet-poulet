package dao.comptabilite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import util.comptabilite.AnalytiqueDesCouts;

public class AnalytiqueDesCoutsDAO {

    private Connexion connexion = new Connexion();

    public void insert(AnalytiqueDesCouts analytiqueDesCouts) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO analytique_des_cout (nom) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, analytiqueDesCouts.getNom());
            stmt.executeUpdate();
            System.out.println("Analytique des coûts inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void update(AnalytiqueDesCouts analytiqueDesCouts) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE analytique_des_cout SET nom=? WHERE id_analytique_des_couts=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, analytiqueDesCouts.getNom());
            stmt.setInt(2, analytiqueDesCouts.getId());
            stmt.executeUpdate();
            System.out.println("Analytique des coûts mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM analytique_des_cout WHERE id_analytique_des_couts=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Analytique des coûts supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public List<AnalytiqueDesCouts> getAll() {
        List<AnalytiqueDesCouts> analytiques = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM analytique_des_cout";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                AnalytiqueDesCouts analytique = new AnalytiqueDesCouts();
                analytique.setId(rs.getInt("id_analytique_des_couts"));
                analytique.setNom(rs.getString("nom"));
                analytiques.add(analytique);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return analytiques;
    }

    public AnalytiqueDesCouts getById(int id) {
        AnalytiqueDesCouts analytique = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM analytique_des_cout WHERE id_analytique_des_couts=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                analytique = new AnalytiqueDesCouts();
                analytique.setId(rs.getInt("id_analytique_des_couts"));
                analytique.setNom(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return analytique;
    }
}
