package dao.fournisseur;

import connexion.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.fournisseur.Produit;

public class ProduitDAO {
    private Connexion connexion = new Connexion();

    public void insert(Produit produit) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO produit (nom_produit, description) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produit.getNom());
            stmt.setString(2, produit.getDescription());
            stmt.executeUpdate();
            System.out.println("Produit inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void update(Produit produit) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE produit SET nom_produit=? , description=? WHERE id_produit=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produit.getNom());
            stmt.setString(2, produit.getDescription());
            stmt.setInt(3, produit.getId());
            stmt.executeUpdate();
            System.out.println("Produit mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM produit WHERE id_produit=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Produit supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public List<Produit> getAll() {
        List<Produit> produits = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM produit";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produit produit = new Produit();
                produit.setId(rs.getInt("id_produit"));
                produit.setNom(rs.getString("nom_produit"));
                produit.setDescription(rs.getString("description"));
                produits.add(produit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return produits;
    }

    public Produit getById(int id) {
        Produit produit = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM produit WHERE id_produit=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                produit = new Produit();
                produit.setId(rs.getInt("id_produit"));
                produit.setNom(rs.getString("nom_produit"));
                produit.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return produit;
    }
}
