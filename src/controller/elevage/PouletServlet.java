package controller.elevage;

import dao.elevage.PouletDAO;
import util.elevage.Poulet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PouletServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PouletDAO pouletDAO = new PouletDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération des paramètres de la requête
        double poidsInitial = Double.parseDouble(request.getParameter("poids_initial"));
        double poidsFinal = Double.parseDouble(request.getParameter("poids_final"));
        int idElevage = Integer.parseInt(request.getParameter("id_elevage"));

        // Création d'un objet Poulet
        Poulet poulet = new Poulet();
        poulet.setPoids_initial(poidsInitial);
        poulet.setPoids_final(poidsFinal);
        // On peut aussi récupérer l'objet Elevage si nécessaire

        // Insertion du poulet dans la base de données
        pouletDAO.insert(poulet);

        // Rediriger ou envoyer une réponse
        response.sendRedirect("poulet-list.jsp"); // redirige vers une page de liste des poulets
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("getAll".equals(action)) {
            // Récupération de tous les poulets
            List<Poulet> poulets = pouletDAO.getAll();
            request.setAttribute("poulets", poulets);
            request.getRequestDispatcher("poulet-list.jsp").forward(request, response); // afficher la liste des poulets
        } else if ("getById".equals(action)) {
            // Récupération d'un poulet par ID
            int id = Integer.parseInt(request.getParameter("id"));
            Poulet poulet = pouletDAO.getById(id);
            request.setAttribute("poulet", poulet);
            request.getRequestDispatcher("poulet-details.jsp").forward(request, response); // afficher les détails du poulet
        }
    }
}
