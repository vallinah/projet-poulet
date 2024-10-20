package util.charge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;

public class Rubrique {
    public static Connexion connexion = new Connexion();
    
    private String nom; // nom de la charge
    private String uniteOeuvre; // unité de l'œuvre
    private String nature; // nature de la charge
    private double pourcentageDemarrage;
    private double pourcentageTransition;
    private double pourcentageFinition;
    private double demarrageFixe;
    private double demarrageVariable;
    private double transitionFixe;
    private double transitionVariable;
    private double finitionFixe;
    private double finitionVariable;
    private double totalFixe;
    private double totalVariable;

    // Ajout d'un constructeur par défaut
    public Rubrique() {
    }

    // Ajout d'un constructeur avec paramètres
    public Rubrique(String nom, String uniteOeuvre, String nature, double pourcentageDemarrage, double pourcentageTransition, double pourcentageFinition) {
        this.nom = nom;
        this.uniteOeuvre = uniteOeuvre;
        this.nature = nature;
        this.pourcentageDemarrage = pourcentageDemarrage;
        this.pourcentageTransition = pourcentageTransition;
        this.pourcentageFinition = pourcentageFinition;
    }

    // Méthode pour récupérer les rubriques
    public static List<Rubrique> getRubriques() {
        List<Rubrique> rubriques = new ArrayList<>();
        String sql = "SELECT c.nom, c.unite_oeuvre, tc.nom AS nature, " +
                     "c.pourcentage_demarrage, c.pourcentage_transition, c.pourcentage_finition, " +
                     "SUM(CASE WHEN c.pourcentage_demarrage > 0 THEN d.quantite * c.prix_unitaire * c.pourcentage_demarrage / 100 ELSE 0 END) AS demarrage_variable, " +
                     "SUM(CASE WHEN c.pourcentage_transition > 0 THEN d.quantite * c.prix_unitaire * c.pourcentage_transition / 100 ELSE 0 END) AS transition_variable, " +
                     "SUM(CASE WHEN c.pourcentage_finition > 0 THEN d.quantite * c.prix_unitaire * c.pourcentage_finition / 100 ELSE 0 END) AS finition_variable " +
                     "FROM charge c " +
                     "JOIN depense d ON c.id = d.id_charge " +
                     "JOIN type_charge tc ON c.id_type_charge = tc.id " +
                     "GROUP BY c.nom, c.unite_oeuvre, tc.nom, c.pourcentage_demarrage, c.pourcentage_transition, c.pourcentage_finition";

        try (Connection conn = connexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Rubrique rubrique = new Rubrique();
                rubrique.setNom(rs.getString("nom"));
                rubrique.setUniteOeuvre(rs.getString("unite_oeuvre"));
                rubrique.setNature(rs.getString("nature"));
                rubrique.setPourcentageDemarrage(rs.getDouble("pourcentage_demarrage"));
                rubrique.setPourcentageTransition(rs.getDouble("pourcentage_transition"));
                rubrique.setPourcentageFinition(rs.getDouble("pourcentage_finition"));
                rubrique.setDemarrageVariable(rs.getDouble("demarrage_variable"));
                rubrique.setTransitionVariable(rs.getDouble("transition_variable"));
                rubrique.setFinitionVariable(rs.getDouble("finition_variable"));

                rubriques.add(rubrique);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rubriques;
    }

    // Getters and Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUniteOeuvre() {
        return uniteOeuvre;
    }

    public void setUniteOeuvre(String uniteOeuvre) {
        this.uniteOeuvre = uniteOeuvre;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public double getPourcentageDemarrage() {
        return pourcentageDemarrage;
    }

    public void setPourcentageDemarrage(double pourcentageDemarrage) {
        this.pourcentageDemarrage = pourcentageDemarrage;
    }

    public double getPourcentageTransition() {
        return pourcentageTransition;
    }

    public void setPourcentageTransition(double pourcentageTransition) {
        this.pourcentageTransition = pourcentageTransition;
    }

    public double getPourcentageFinition() {
        return pourcentageFinition;
    }

    public void setPourcentageFinition(double pourcentageFinition) {
        this.pourcentageFinition = pourcentageFinition;
    }

    public double getDemarrageVariable() {
        return demarrageVariable;
    }

    public void setDemarrageVariable(double demarrageVariable) {
        this.demarrageVariable = demarrageVariable;
    }

    public double getTransitionVariable() {
        return transitionVariable;
    }

    public void setTransitionVariable(double transitionVariable) {
        this.transitionVariable = transitionVariable;
    }

    public double getFinitionVariable() {
        return finitionVariable;
    }

    public void setFinitionVariable(double finitionVariable) {
        this.finitionVariable = finitionVariable;
    }
}
