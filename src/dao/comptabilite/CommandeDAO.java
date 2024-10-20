package dao.comptabilite;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import connexion.Connexion;
import util.comptabilite.Commande;

public class CommandeDAO {

    private Connexion connexion = new Connexion();

    public void insert(Commande commande) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO commande (demande_id, fournisseur_id, date_commande) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, commande.getDemande().getId()); // Assurez-vous que la méthode getId() est disponible dans Demande
            stmt.setInt(2, commande.getFournisseur().getId()); // Assurez-vous que la méthode getId() est disponible dans Fournisseur
            stmt.setDate(3, Date.valueOf(commande.getDateCommande())); // Conversion de LocalDate à Date
            stmt.executeUpdate();
            System.out.println("Commande insérée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void update(Commande commande) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE commande SET demande_id=?, fournisseur_id=?, date_commande=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, commande.getDemande().getId());
            stmt.setInt(2, commande.getFournisseur().getId());
            stmt.setDate(3, Date.valueOf(commande.getDateCommande()));
            stmt.setInt(4, commande.getId());
            stmt.executeUpdate();
            System.out.println("Commande mise à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM commande WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Commande supprimée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public List<Commande> getAll() {
        List<Commande> commandes = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM commande";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Commande commande = new Commande();
                commande.setId(rs.getInt("id")); // Ajoutez cette ligne pour récupérer l'identifiant
                commande.setDemande(new Demande()); // Remplacez par la logique réelle pour récupérer la demande
                commande.getDemande().setId(rs.getInt("demande_id")); // Assurez-vous que vous récupérez les détails de la demande
                commande.setFournisseur(new Fournisseur()); // Remplacez par la logique réelle pour récupérer le fournisseur
                commande.getFournisseur().setId(rs.getInt("fournisseur_id")); // Assurez-vous que vous récupérez les détails du fournisseur
                commande.setDateCommande(rs.getDate("date_commande").toLocalDate());
                commandes.add(commande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return commandes;
    }

    public Commande getById(int id) {
        Commande commande = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM commande WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                commande = new Commande();
                commande.setId(rs.getInt("id"));
                commande.setDemande(new Demande()); // Remplacez par la logique réelle pour récupérer la demande
                commande.getDemande().setId(rs.getInt("demande_id")); // Assurez-vous que vous récupérez les détails de la demande
                commande.setFournisseur(new Fournisseur()); // Remplacez par la logique réelle pour récupérer le fournisseur
                commande.getFournisseur().setId(rs.getInt("fournisseur_id")); // Assurez-vous que vous récupérez les détails du fournisseur
                commande.setDateCommande(rs.getDate("date_commande").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return commande;
    }
}
