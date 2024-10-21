package dao.comptabilite;

import connexion.Connexion;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import util.comptabilite.Demande;

public class DemandeDAO {

    private Connexion connexion = new Connexion();

    public void insert(Demande demande) {
        Connection conn = connexion.getConnection();
        String sql = "INSERT INTO demande (idDepartement, quantite, motif, dateDemande) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, demande.getIdDepartement());
            stmt.setDouble(2, demande.getQuantite());
            stmt.setString(3, demande.getMotif());
            stmt.setDate(4, Date.valueOf(demande.getDateDemande())); // Conversion de LocalDate à Date
            stmt.executeUpdate();
            System.out.println("Demande insérée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void update(Demande demande) {
        Connection conn = connexion.getConnection();
        String sql = "UPDATE demande SET idDepartement=?, quantite=?, motif=?, dateDemande=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, demande.getIdDepartement());
            stmt.setDouble(2, demande.getQuantite());
            stmt.setString(3, demande.getMotif());
            stmt.setDate(4, Date.valueOf(demande.getDateDemande()));
            stmt.setInt(5, demande.getId());
            stmt.executeUpdate();
            System.out.println("Demande mise à jour avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public void delete(int id) {
        Connection conn = connexion.getConnection();
        String sql = "DELETE FROM demande WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Demande supprimée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
    }

    public List<Demande> getAll() {
        List<Demande> demandes = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM demande";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Demande demande = new Demande();
                demande.setId(rs.getInt("id"));
                demande.setIdDepartement(rs.getInt("idDepartement"));
                demande.setQuantite(rs.getDouble("quantite"));
                demande.setMotif(rs.getString("motif"));
                demande.setDateDemande(rs.getDate("dateDemande").toLocalDate());
                demandes.add(demande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return demandes;
    }

    public Demande getById(int id) {
        Demande demande = null;
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM demande WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                demande = new Demande();
                demande.setId(rs.getInt("id"));
                demande.setIdDepartement(rs.getInt("idDepartement"));
                demande.setQuantite(rs.getDouble("quantite"));
                demande.setMotif(rs.getString("motif"));
                demande.setDateDemande(rs.getDate("dateDemande").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return demande;
    }

   public List<Demande> getByDepartement(int idDepartement) {
        List<Demande> demandes = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM demande WHERE id_departement = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idDepartement);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Demande demande = new Demande();
                demande.setId(rs.getInt("id_demande"));
                demande.setIdDepartement(rs.getInt("id_departement"));
                demande.setQuantite(rs.getDouble("quantite"));
                demande.setMotif(rs.getString("motif"));
                demande.setDateDemande(rs.getDate("date_demande").toLocalDate());
                demandes.add(demande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return demandes;
    }

    public List<Demande> getByDateBetween(LocalDate debut, LocalDate fin) {
        List<Demande> demandes = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM demande WHERE date_demande BETWEEN ? AND ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(debut));
            stmt.setDate(2, java.sql.Date.valueOf(fin));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Demande demande = new Demande();
                demande.setId(rs.getInt("id_demande"));
                demande.setIdDepartement(rs.getInt("id_departement"));
                demande.setQuantite(rs.getDouble("quantite"));
                demande.setMotif(rs.getString("motif"));
                demande.setDateDemande(rs.getDate("date_demande").toLocalDate());
                demandes.add(demande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return demandes;
    }

    public List<Demande> getByDateBetweenDepartement(int idDepartement, LocalDate debut, LocalDate fin) {
        List<Demande> demandes = new ArrayList<>();
        Connection conn = connexion.getConnection();
        String sql = "SELECT * FROM demande WHERE id_departement = ? AND date_demande BETWEEN ? AND ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idDepartement);
            stmt.setDate(2, java.sql.Date.valueOf(debut));
            stmt.setDate(3, java.sql.Date.valueOf(fin));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Demande demande = new Demande();
                demande.setId(rs.getInt("id_demande"));
                demande.setIdDepartement(rs.getInt("id_departement"));
                demande.setQuantite(rs.getDouble("quantite"));
                demande.setMotif(rs.getString("motif"));
                demande.setDateDemande(rs.getDate("date_demande").toLocalDate());
                demandes.add(demande);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connexion.deconnexion();
        }
        return demandes;
    }
}

