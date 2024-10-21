package dao.fournisseur;


import java.sql.*;
import connexion.Connexion;
import util.fournisseur.Fournisseur;
import util.fournisseur.FournisseurProduit;
import util.fournisseur.Produit;

public class FournisseurProduitDAO {
    private Connexion connexion = new Connexion();
    private FournisseurDAO fournisseurDAO = new FournisseurDAO();
    private ProduitDAO produitDAO = new ProduitDAO();

    // Méthode pour insérer un nouveau FournisseurProduit
    public void insert(FournisseurProduit fournisseurProduit) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO fournisseur_produit (id_produit, id_fournisseur, prix_unitaire, unite_oeuvre) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fournisseurProduit.getProduit().getId());
            stmt.setInt(2, fournisseurProduit.getFournisseur().getId());
            stmt.setDouble(3, fournisseurProduit.getPrixUnitaire());
            stmt.setString(4, fournisseurProduit.getUniteOeuvre());
            stmt.executeUpdate();
            System.out.println("FournisseurProduit inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour mettre à jour un FournisseurProduit existant
    public void update(FournisseurProduit fournisseurProduit) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE fournisseur_produit SET id_fournisseur=?, prix_unitaire=?, unite_oeuvre=? WHERE id_produit=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fournisseurProduit.getFournisseur().getId());
            stmt.setDouble(2, fournisseurProduit.getPrixUnitaire());
            stmt.setString(3, fournisseurProduit.getUniteOeuvre());
            stmt.setInt(4, fournisseurProduit.getProduit().getId());
            stmt.executeUpdate();
            System.out.println("FournisseurProduit mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour supprimer un FournisseurProduit
    public void delete(int idProduit) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM fournisseur_produit WHERE id_produit=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProduit);
            stmt.executeUpdate();
            System.out.println("FournisseurProduit supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour récupérer un FournisseurProduit par id_produit
    public FournisseurProduit getById(int idProduit) {
        FournisseurProduit fournisseurProduit = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM fournisseur_produit WHERE id_produit=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProduit);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                fournisseurProduit = new FournisseurProduit();
                
                // Récupérer les objets Fournisseur et Produit à partir de leurs DAO
                Fournisseur fournisseur = fournisseurDAO.getById(rs.getInt("id_fournisseur"));
                Produit produit = produitDAO.getById(rs.getInt("id_produit"));
                
                fournisseurProduit.setFournisseur(fournisseur);
                fournisseurProduit.setProduit(produit);
                fournisseurProduit.setPrixUnitaire(rs.getDouble("prix_unitaire"));
                fournisseurProduit.setUniteOeuvre(rs.getString("unite_oeuvre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return fournisseurProduit;
    }
}
