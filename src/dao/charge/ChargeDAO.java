package dao.charge;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import util.charge.Charge;

public class ChargeDAO {
    Connexion connexion;

    // Méthode pour obtenir toutes les charges
    public List<Charge> getAll() {
        List<Charge> charges = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM charge";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Charge charge = new Charge();
                charge.setId(rs.getInt("id_charge"));
                charge.setNom(rs.getString("nom"));
                charge.setPrixUnitaire(rs.getBigDecimal("prix_unitaire"));
                charge.setUniteOeuvre(rs.getString("unite_oeuvre"));
                charge.setIdChargeAnalytique(rs.getInt("id_charge_analytique"));
                charge.setIdAnalytiqueDesCouts(rs.getInt("id_analytique_des_couts"));
                charge.setIdTypeCharge(rs.getInt("id_type_charge"));
                charges.add(charge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return charges;
    }

    // Méthode pour obtenir une charge par ID
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
                charge.setPrixUnitaire(rs.getBigDecimal("prix_unitaire"));
                charge.setUniteOeuvre(rs.getString("unite_oeuvre"));
                charge.setIdChargeAnalytique(rs.getInt("id_charge_analytique"));
                charge.setIdAnalytiqueDesCouts(rs.getInt("id_analytique_des_couts"));
                charge.setIdTypeCharge(rs.getInt("id_type_charge"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return charge;
    }

    // Méthode pour insérer une charge
    public void insert(Charge charge) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO charge(nom, prix_unitaire, unite_oeuvre, id_charge_analytique, id_analytique_des_couts, id_type_charge) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, charge.getNom());
            stmt.setBigDecimal(2, charge.getPrixUnitaire());
            stmt.setString(3, charge.getUniteOeuvre());
            stmt.setInt(4, charge.getIdChargeAnalytique());
            stmt.setInt(5, charge.getIdAnalytiqueDesCouts());
            stmt.setInt(6, charge.getIdTypeCharge());
            stmt.executeUpdate();
            System.out.println("Charge insérée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    // Méthode pour mettre à jour une charge existante
    public void update(Charge charge) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE charge SET nom=?, prix_unitaire=?, unite_oeuvre=?, id_charge_analytique=?, id_analytique_des_couts=?, id_type_charge=? WHERE id_charge=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, charge.getNom());
            stmt.setBigDecimal(2, charge.getPrixUnitaire());
            stmt.setString(3, charge.getUniteOeuvre());
            stmt.setInt(4, charge.getIdChargeAnalytique());
            stmt.setInt(5, charge.getIdAnalytiqueDesCouts());
            stmt.setInt(6, charge.getIdTypeCharge());
            stmt.setInt(7, charge.getId());
            stmt.executeUpdate();
            System.out.println("Charge mise à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }
}
 