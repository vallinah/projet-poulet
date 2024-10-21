package dao.charge;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connexion.Connexion;
import util.charge.Charge;
import util.charge.TypeCharge;
import util.comptabilite.AnalytiqueDesCouts;
import util.comptabilite.ChargeAnalytique;

public class ChargeDAO {

    private Connexion connexion = new Connexion();

    public void insert(Charge charge) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO charge (nom, prix_unitaire, unite_oeuvre, id_charge_analytique, id_analytique_des_couts, id_type_charge) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, charge.getNom());
            stmt.setDouble(2, charge.getPrix_unitaire());
            stmt.setString(3, charge.getUnite_oeuvre());
            stmt.setInt(4, charge.getChargeAnalytique().getId()); // Assurez-vous que la méthode getId() est disponible dans ChargeAnalytique
            stmt.setInt(5, charge.getAnalytiqueDesCouts().getId()); // Assurez-vous que la méthode getId() est disponible dans AnalytiqueDesCouts
            stmt.setInt(6, charge.getTypeCharge().getId()); // Assurez-vous que la méthode getId() est disponible dans TypeCharge
            stmt.executeUpdate();
            System.out.println("Charge insérée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void update(Charge charge) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE charge SET nom=?, prix_unitaire=?, unite_oeuvre=?, id_charge_analytique=?, id_analytique_des_couts=?, id_type_charge=? WHERE id_charge=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, charge.getNom());
            stmt.setDouble(2, charge.getPrix_unitaire());
            stmt.setString(3, charge.getUnite_oeuvre());
            stmt.setInt(4, charge.getChargeAnalytique().getId());
            stmt.setInt(5, charge.getAnalytiqueDesCouts().getId());
            stmt.setInt(6, charge.getTypeCharge().getId());
            stmt.setInt(7, charge.getId());
            stmt.executeUpdate();
            System.out.println("Charge mise à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM charge WHERE id_charge=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Charge supprimée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public List<Charge> getAll() {
        List<Charge> charges = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM charge";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Charge charge = new Charge();
                charge.setId(rs.getInt("id_charge"));
                charge.setNom(rs.getString("nom"));
                charge.setPrix_unitaire(rs.getDouble("prix_unitaire"));
                charge.setUnite_oeuvre(rs.getString("unite_oeuvre"));
                
                // Ajoutez ici la logique pour récupérer les objets ChargeAnalytique, AnalytiqueDesCouts, TypeCharge par leurs IDs
                charge.setChargeAnalytique(new ChargeAnalytique()); // Remplacez par la logique réelle
                charge.setAnalytiqueDesCouts(new AnalytiqueDesCouts()); // Remplacez par la logique réelle
                charge.setTypeCharge(new TypeCharge()); // Remplacez par la logique réelle

                charges.add(charge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return charges;
    }

    public Charge getById(int id) {
        Charge charge = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM charge WHERE id_charge=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                charge = new Charge();
                charge.setId(rs.getInt("id_charge"));
                charge.setNom(rs.getString("nom"));
                charge.setPrix_unitaire(rs.getDouble("prix_unitaire"));
                charge.setUnite_oeuvre(rs.getString("unite_oeuvre"));

                // Ajoutez ici la logique pour récupérer les objets ChargeAnalytique, AnalytiqueDesCouts, TypeCharge par leurs IDs
                charge.setChargeAnalytique(new ChargeAnalytique()); // Remplacez par la logique réelle
                charge.setAnalytiqueDesCouts(new AnalytiqueDesCouts()); // Remplacez par la logique réelle
                charge.setTypeCharge(new TypeCharge()); // Remplacez par la logique réelle
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return charge;
    }
}
