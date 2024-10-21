package dao.fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connexion.Connexion;
import util.fournisseur.Fournisseur;
import util.fournisseur.Produit;
import util.fournisseur.ProduitLivrer;

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

    public Fournisseur getByEmailAndPassword(Fournisseur fournisseur) {
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM fournisseur WHERE email= ? and mot_de_passe = ?";
        Fournisseur vraie = null;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fournisseur.getEmail());
            stmt.setString(2, fournisseur.getMotDePasse());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                vraie = new Fournisseur();
                vraie.setId(rs.getInt("id_fournisseur"));
                vraie.setNom(rs.getString("nom_fournisseur"));
                vraie.setEmail(rs.getString("email"));
                vraie.setMotDePasse(rs.getString("mot_de_passe"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return vraie;
    }

    public int estFournisseur(Fournisseur fournisseur) {
        int marina = 0;
        Fournisseur fournisseur2 = getByEmailAndPassword(fournisseur);
        if (fournisseur2 != null) {
            marina = fournisseur2.getId();
        }
        return marina;
    }

    // Nouvelle méthode pour récupérer les produits livrés par un fournisseur
    public List<ProduitLivrer> getProduitsLivresParFournisseur(int idFournisseur) throws SQLException {
        List<ProduitLivrer> produitsLivres = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT p.*, mp.quantite, mp.date_mouvement " +
                     "FROM mouvement_produit_fournisseur mp " +
                     "JOIN produit p ON mp.id_produit = p.id_produit " +
                     "WHERE mp.id_fournisseur = ?"; // Remplacez par le champ réel qui identifie le fournisseur

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, idFournisseur);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Produit produit = new Produit(); // Créez une instance de Produit et remplissez ses attributs
                    produit.setId(resultSet.getInt("id_produit")); // Remplacez par les bonnes colonnes
                    produit.setNom(resultSet.getString("nom_produit")); // Remplacez par les bonnes colonnes
                    // Ajoutez d'autres attributs du produit si nécessaire

                    double quantite = resultSet.getDouble("quantite");
                    Date dateMouvement = resultSet.getDate("date_mouvement");

                    ProduitLivrer produitLivrer = new ProduitLivrer(produit, null, quantite, dateMouvement); // Fournisseur sera null ici
                    produitsLivres.add(produitLivrer);
                }
            }
        } finally {
            connexion.deconnexion();
        }
        return produitsLivres;
    }
}
