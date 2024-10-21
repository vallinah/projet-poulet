package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    // Informations de connexion à PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/poulailler";
    private static final String USER = "postgres";
    private static final String PASSWORD = "nantenaina";

    // Variable pour stocker la connexion
    private Connection connection;

    // Méthode pour obtenir la connexion
    public Connection getConnection() {
        try {
            // Charger le driver PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Établir la connexion
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion à la base de données réussie.");
        } catch (ClassNotFoundException e) {
            System.out.println("Le driver PostgreSQL n'a pas été trouvé.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données.");
            e.printStackTrace();
        }
        return connection;
    }

    // Méthode pour fermer la connexion
    public void deconnexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connexion fermée avec succès.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture de la connexion.");
            e.printStackTrace();
        }
    }

    // Main pour tester la connexion
    public static void main(String[] args) {
        Connexion connexion = new Connexion();

        // Obtenir la connexion
        Connection conn = connexion.getConnection();

        // Fermer la connexion
        connexion.deconnexion();
    }
}
