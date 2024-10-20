package dao.fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connexion.Connexion;
import util.fournisseur.Fournisseur;

public class FournisseurDAO {
    private Connexion connexion = new Connexion();

    public void insert(Fournisseur fournisseur) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO fournisseur (nom_fournisseur, email, mot_de_passe) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fournisseur.getNom());
            stmt.setString(2, fournisseur.getEmail());
            stmt.setString(3, fournisseur.getMotDePasse());
            stmt.executeUpdate();
            System.out.println("Fournisseur inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void update(Fournisseur fournisseur) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE fournisseur SET nom_fournisseur=?, email=?, mot_de_passe=? WHERE id_fournisseur=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fournisseur.getNom());
            stmt.setString(2, fournisseur.getEmail());
            stmt.setString(3, fournisseur.getMotDePasse());
            stmt.setInt(4, fournisseur.getId());
            stmt.executeUpdate();
            System.out.println("Fournisseur mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM fournisseur WHERE id_fournisseur=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Fournisseur supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public List<Fournisseur> getAll() {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM fournisseur";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Fournisseur fournisseur = new Fournisseur();
                fournisseur.setId(rs.getInt("id_fournisseur"));
                fournisseur.setNom(rs.getString("nom_fournisseur"));
                fournisseur.setEmail(rs.getString("email"));
                fournisseur.setMotDePasse(rs.getString("mot_de_passe"));
                fournisseurs.add(fournisseur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return fournisseurs;
    }

    public Fournisseur getById(int id) {
        Fournisseur fournisseur = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM fournisseur WHERE id_fournisseur=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                fournisseur = new Fournisseur();
                fournisseur.setId(rs.getInt("id_fournisseur"));
                fournisseur.setNom(rs.getString("nom_fournisseur"));
                fournisseur.setEmail(rs.getString("email"));
                fournisseur.setMotDePasse(rs.getString("mot_de_passe"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return fournisseur;
    }
}
