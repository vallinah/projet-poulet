package controller.elevage;

import dao.elevage.ElevageDAO;
import util.elevage.Elevage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ElevageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ElevageDAO elevageDAO = new ElevageDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération des paramètres de la requête
        LocalDate dateDebut = LocalDate.parse(request.getParameter("date_debut"));
        int dureeCycle = Integer.parseInt(request.getParameter("duree_cycle"));

        // Création d'un objet Elevage
        Elevage elevage = new Elevage();
        elevage.setDate_debut(dateDebut);
        elevage.setDuree_cycle(dureeCycle);

        // Insertion de l'élevage dans la base de données
        elevageDAO.insert(elevage);

        // Rediriger ou envoyer une réponse
        response.sendRedirect("elevage-list.jsp"); // redirige vers une page de liste des élevages
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("getAll".equals(action)) {
            // Récupération de tous les élevages
            List<Elevage> elevages = elevageDAO.getAll();
            request.setAttribute("elevages", elevages);
            request.getRequestDispatcher("elevage-list.jsp").forward(request, response); // afficher la liste des élevages
        } else if ("getById".equals(action)) {
            // Récupération d'un élevage par ID
            int id = Integer.parseInt(request.getParameter("id"));
            Elevage elevage = elevageDAO.getById(id);
            request.setAttribute("elevage", elevage);
            request.getRequestDispatcher("elevage-details.jsp").forward(request, response); // afficher les détails de l'élevage
        }
    }
}
