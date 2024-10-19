package dao.charge;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connexion.Connexion;
import util.charge.TypeCharge;

public class TypeChargeDAO {

    private Connexion connexion = new Connexion();

    public void insert(TypeCharge typeCharge) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO type_charge (nom) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, typeCharge.getNom());
            stmt.executeUpdate();
            System.out.println("Type de charge inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void update(TypeCharge typeCharge) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE type_charge SET nom=? WHERE id_type_charge=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, typeCharge.getNom());
            stmt.setInt(2, typeCharge.getId());
            stmt.executeUpdate();
            System.out.println("Type de charge mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM type_charge WHERE id_type_charge=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Type de charge supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public List<TypeCharge> getAll() {
        List<TypeCharge> typeCharges = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM type_charge";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TypeCharge typeCharge = new TypeCharge();
                typeCharge.setId(rs.getInt("id_type_charge"));
                typeCharge.setNom(rs.getString("nom"));
                typeCharges.add(typeCharge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return typeCharges;
    }

    public TypeCharge getById(int id) {
        TypeCharge typeCharge = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM type_charge WHERE id_type_charge=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                typeCharge = new TypeCharge();
                typeCharge.setId(rs.getInt("id_type_charge"));
                typeCharge.setNom(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return typeCharge;
    }
}

