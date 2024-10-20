package dao.mouvement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connexion.Connexion;
import dao.fournisseur.FournisseurProduitDAO;
import util.fournisseur.FournisseurProduit;
import util.mouvement.MouvementProduit;

public class MouvementProduitDAO {

    private Connexion connexion = new Connexion();

    public void insert(MouvementProduit mouvementProduit) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO mouvement_produit (entree, sortie, id_fournisseur_produit, quantite, dateMouvement) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, mouvementProduit.isEntree());
            stmt.setBoolean(2, mouvementProduit.isSortie());
            stmt.setInt(3, mouvementProduit.getFournisseurProduit().getId()); // Assurez-vous que FournisseurProduit a une méthode getId()
            stmt.setDouble(4, mouvementProduit.getQuantite());
            stmt.setDate(5, Date.valueOf(mouvementProduit.getDateMouvement())); // Conversion de LocalDate à Date
            stmt.executeUpdate();
            System.out.println("Mouvement de produit inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void update(MouvementProduit mouvementProduit) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE mouvement_produit SET entree=?, sortie=?, id_fournisseur_produit=?, quantite=?, dateMouvement=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, mouvementProduit.isEntree());
            stmt.setBoolean(2, mouvementProduit.isSortie());
            stmt.setInt(3, mouvementProduit.getFournisseurProduit().getId());
            stmt.setDouble(4, mouvementProduit.getQuantite());
            stmt.setDate(5, Date.valueOf(mouvementProduit.getDateMouvement()));
            stmt.setInt(6, mouvementProduit.getId());
            stmt.executeUpdate();
            System.out.println("Mouvement de produit mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM mouvement_produit WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Mouvement de produit supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public List<MouvementProduit> getAll() {
        List<MouvementProduit> mouvements = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM mouvement_produit";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                MouvementProduit mouvementProduit = new MouvementProduit();
                mouvementProduit.setId(rs.getInt("id"));
                mouvementProduit.setEntree(rs.getBoolean("entree"));
                mouvementProduit.setSortie(rs.getBoolean("sortie"));
                FournisseurProduit fournisseurProduit = new FournisseurProduitDAO().getById(rs.getInt("id_fournisseur_produit")); // Assurez-vous d'avoir la classe FournisseurProduit
                mouvementProduit.setFournisseurProduit(fournisseurProduit);
                mouvementProduit.setQuantite(rs.getDouble("quantite"));
                mouvementProduit.setDateMouvement(rs.getDate("dateMouvement").toLocalDate());
                mouvements.add(mouvementProduit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return mouvements;
    }

    public MouvementProduit getById(int id) {
        MouvementProduit mouvementProduit = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM mouvement_produit WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                mouvementProduit = new MouvementProduit();
                mouvementProduit.setId(rs.getInt("id"));
                mouvementProduit.setEntree(rs.getBoolean("entree"));
                mouvementProduit.setSortie(rs.getBoolean("sortie"));

                FournisseurProduit fournisseurProduit = new FournisseurProduitDAO().getById(rs.getInt("id_fournisseur_produit")); 
                mouvementProduit.setFournisseurProduit(fournisseurProduit);

                mouvementProduit.setQuantite(rs.getDouble("quantite"));
                mouvementProduit.setDateMouvement(rs.getDate("dateMouvement").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return mouvementProduit;
    }
}

