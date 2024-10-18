package dao.elevage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connexion.Connexion;
import util.elevage.Elevage;

public class ElevageDAO {

    private Connexion connexion = new Connexion();

    public void insert(Elevage elevage) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO elevage (date_debut, duree_cycle) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(elevage.getDate_debut()));
            stmt.setInt(2, elevage.getDuree_cycle());
            stmt.executeUpdate();
            System.out.println("Élevage inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void update(Elevage elevage) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE elevage SET date_debut=?, duree_cycle=? WHERE id_elevage=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(elevage.getDate_debut()));
            stmt.setInt(2, elevage.getDuree_cycle());
            stmt.setInt(3, elevage.getId());
            stmt.executeUpdate();
            System.out.println("Élevage mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM elevage WHERE id_elevage=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Élevage supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public List<Elevage> getAll() {
        List<Elevage> elevages = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM elevage";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Elevage elevage = new Elevage();
                elevage.setId(rs.getInt("id_elevage"));
                elevage.setDate_debut(rs.getDate("date_debut").toLocalDate());
                elevage.setDuree_cycle(rs.getInt("duree_cycle"));
                elevages.add(elevage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return elevages;
    }

    public Elevage getById(int id) {
        Elevage elevage = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM elevage WHERE id_elevage=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                elevage = new Elevage();
                elevage.setId(rs.getInt("id_elevage"));
                elevage.setDate_debut(rs.getDate("date_debut").toLocalDate());
                elevage.setDuree_cycle(rs.getInt("duree_cycle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return elevage;
    }
}
