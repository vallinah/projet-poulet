package dao.elevage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connexion.Connexion;
import util.elevage.Poulet;


public class PouletDAO {

    private Connexion connexion = new Connexion();

    public void insert(Poulet poulet) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO poulet (poids_initial, poids_final, id_elevage) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, poulet.getPoids_initial());
            stmt.setDouble(2, poulet.getPoids_final());
            stmt.setInt(3, poulet.getElevage().getId());
            stmt.executeUpdate();
            System.out.println("Poulet inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void update(Poulet poulet) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE poulet SET poids_initial=?, poids_final=?, id_elevage=? WHERE id_poulet=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, poulet.getPoids_initial());
            stmt.setDouble(2, poulet.getPoids_final());
            stmt.setInt(3, poulet.getElevage().getId());
            stmt.setInt(4, poulet.getId());
            stmt.executeUpdate();
            System.out.println("Poulet mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM poulet WHERE id_poulet=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Poulet supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public List<Poulet> getAll() {
        List<Poulet> poulets = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM poulet";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Poulet poulet = new Poulet();
                poulet.setId(rs.getInt("id_poulet"));
                poulet.setPoids_initial(rs.getDouble("poids_initial"));
                poulet.setPoids_final(rs.getDouble("poids_final"));
                poulet.setElevage(new ElevageDAO().getById(rs.getInt("id_elevage")));
                poulets.add(poulet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return poulets;
    }

    public Poulet getById(int id) {
        Poulet poulet = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM poulet WHERE id_poulet=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                poulet = new Poulet();
                poulet.setId(rs.getInt("id_poulet"));
                poulet.setPoids_initial(rs.getDouble("poids_initial"));
                poulet.setPoids_final(rs.getDouble("poids_final"));
                poulet.setElevage(new ElevageDAO().getById(rs.getInt("id_elevage")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return poulet;
    }
}
