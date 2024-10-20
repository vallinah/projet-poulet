package dao.mouvement;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import connexion.Connexion;
import util.charge.Charge;
import util.mouvement.MouvementCharge;

public class MouvementChargeDAO {

    private Connexion connexion = new Connexion();

    public void insert(MouvementCharge mouvementCharge) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO mouvement_charge (id_charge, entree, sortie, quantite, dateMouvement) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, mouvementCharge.getCharge().getId()); // Assurez-vous que Charge a une méthode getId()
            stmt.setBoolean(2, mouvementCharge.getEntree());
            stmt.setBoolean(3, mouvementCharge.getSortie());
            stmt.setDouble(4, mouvementCharge.getQuantite());
            stmt.setDate(5, Date.valueOf(mouvementCharge.getDateMouvement())); // Conversion de LocalDate à Date
            stmt.executeUpdate();
            System.out.println("Mouvement de charge inséré avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void update(MouvementCharge mouvementCharge) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE mouvement_charge SET id_charge=?, entree=?, sortie=?, quantite=?, dateMouvement=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, mouvementCharge.getCharge().getId());
            stmt.setBoolean(2, mouvementCharge.getEntree());
            stmt.setBoolean(3, mouvementCharge.getSortie());
            stmt.setDouble(4, mouvementCharge.getQuantite());
            stmt.setDate(5, Date.valueOf(mouvementCharge.getDateMouvement()));
            stmt.setInt(6, mouvementCharge.getId()); // Vous devez ajouter un champ id dans MouvementCharge
            stmt.executeUpdate();
            System.out.println("Mouvement de charge mis à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM mouvement_charge WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Mouvement de charge supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public List<MouvementCharge> getAll() {
        List<MouvementCharge> mouvements = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM mouvement_charge";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                MouvementCharge mouvementCharge = new MouvementCharge();
                Charge charge = new Charge(); // Vous devez avoir une classe Charge avec un constructeur ou des setters appropriés
                charge.setId(rs.getInt("id_charge")); // Assurez-vous que Charge a une méthode setId()
                mouvementCharge.setCharge(charge);
                mouvementCharge.setEntree(rs.getBoolean("entree"));
                mouvementCharge.setSortie(rs.getBoolean("sortie"));
                mouvementCharge.setQuantite(rs.getDouble("quantite"));
                mouvementCharge.setDateMouvement(rs.getDate("dateMouvement").toLocalDate());
                mouvements.add(mouvementCharge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return mouvements;
    }

    public MouvementCharge getById(int id) {
        MouvementCharge mouvementCharge = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM mouvement_charge WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                mouvementCharge = new MouvementCharge();
                Charge charge = new Charge();
                charge.setId(rs.getInt("id_charge"));
                mouvementCharge.setCharge(charge);
                mouvementCharge.setEntree(rs.getBoolean("entree"));
                mouvementCharge.setSortie(rs.getBoolean("sortie"));
                mouvementCharge.setQuantite(rs.getDouble("quantite"));
                mouvementCharge.setDateMouvement(rs.getDate("dateMouvement").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return mouvementCharge;
    }
}
