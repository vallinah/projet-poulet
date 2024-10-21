package dao.fournisseur;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.fournisseur.*;
public class LivraisonDAO {
    private Connexion connexion = new Connexion();

    // Méthode pour récupérer la facture des produits livrés par un fournisseur donné
    public List<FactureProduit> getFactureProduitsParFournisseur(int idFournisseur) {
        List<FactureProduit> factures = new ArrayList<>();
        String sql = "SELECT " +
                     "    f.nom_fournisseur, " +
                     "    p.nom_produit, " +
                     "    SUM(mp.quantite) AS quantite_totale, " +
                     "    SUM(mp.quantite * fp.prix_unitaire) AS total_facture, " +
                     "    MIN(mp.date_mouvement) AS date_premiere_livraison, " +
                     "    MAX(mp.date_mouvement) AS date_derniere_livraison " +
                     "FROM " +
                     "    mouvement_produit_fournisseur mp " +
                     "JOIN " +
                     "    fournisseur_produit fp ON mp.id_fournisseur_produit = fp.id_fournisseur_produit " +
                     "JOIN " +
                     "    produit p ON fp.id_produit = p.id_produit " +
                     "JOIN " +
                     "    fournisseur f ON fp.id_fournisseur = f.id_fournisseur " +
                     "WHERE " +
                     "    f.id_fournisseur = ? " + // Paramètre pour l'ID du fournisseur
                     "GROUP BY " +
                     "    f.nom_fournisseur, p.nom_produit " +
                     "ORDER BY " +
                     "    f.nom_fournisseur, p.nom_produit;";

        try (Connection con = connexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idFournisseur); // Définir l'ID du fournisseur dans la requête
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String nomFournisseur = rs.getString("nom_fournisseur");
                    String nomProduit = rs.getString("nom_produit");
                    double quantiteTotale = rs.getDouble("quantite_totale");
                    double totalFacture = rs.getDouble("total_facture");
                    java.sql.Date datePremiereLivraison = rs.getDate("date_premiere_livraison");
                    java.sql.Date dateDerniereLivraison = rs.getDate("date_derniere_livraison");

                    // Créer un objet FactureProduit et l'ajouter à la liste
                    FactureProduit facture = new FactureProduit(nomFournisseur, nomProduit, quantiteTotale, totalFacture, datePremiereLivraison, dateDerniereLivraison);
                    factures.add(facture);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gérer les exceptions
        }

        return factures; // Retourner la liste des factures
    }
}
