package dao.fournisseur;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.fournisseur.*;

public class ProformatDAO {
    private Connexion connexion = new Connexion();

    // Méthode pour récupérer tous les Proformat pour un fournisseur donné
    public List<Proformat> getById(int idFournisseur) {
        List<Proformat> proformats = new ArrayList<>();
        String sql = "SELECT id_fournisseur_produit, id_produit, id_fournisseur, prix_unitaire, quantite_totale " +
                     "FROM v_listeProFormat " +
                     "WHERE id_fournisseur = ?";

        try (Connection conn = connexion.getConnection(); // Récupérer la connexion
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idFournisseur); // Définir l'id du fournisseur dans la requête
            ResultSet rs = pstmt.executeQuery(); // Exécuter la requête

            // Parcourir les résultats
            while (rs.next()) {
                int idFournisseurProduit = rs.getInt("id_fournisseur_produit");
                int idProduit = rs.getInt("id_produit");
                double prixUnitaire = rs.getDouble("prix_unitaire");
                double quantiteTotale = rs.getDouble("quantite_totale");

                // Récupérer les objets Produit et Fournisseur
                ProduitDAO produitDAO = new ProduitDAO();
                FournisseurDAO fournisseurDAO = new FournisseurDAO();
                Produit produit = produitDAO.getById(idProduit);
                Fournisseur fournisseur = fournisseurDAO.getById(idFournisseur);

                // Vérifier que les objets Produit et Fournisseur sont non null
                if (produit != null && fournisseur != null) {
                    // Créer un objet Proformat
                    Proformat proformat = new Proformat(
                        produit,
                        fournisseur,
                        quantiteTotale,
                        prixUnitaire
                    );

                    // Ajouter à la liste
                    proformats.add(proformat);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Gérer les exceptions (vous pouvez aussi loguer l'erreur)
        }
        return proformats; // Retourner la liste des Proformats
    }
}
