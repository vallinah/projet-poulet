package controller.mouvement;


import dao.mouvement.MouvementProduitDAO;
import util.fournisseur.FournisseurProduit;
import util.mouvement.MouvementProduit;

import jarkarta.servlet.ServletException;
import jarkarta.servlet.http.HttpServlet;
import jarkarta.servlet.http.HttpServletRequest;
import jarkarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class MouvementProduitServlet extends HttpServlet {

    private MouvementProduitDAO mouvementProduitDAO = new MouvementProduitDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "insert":
                insertMouvementProduit(request, response);
                break;
            case "update":
                updateMouvementProduit(request, response);
                break;
            case "delete":
                deleteMouvementProduit(request, response);
                break;
            case "getAll":
                getAllMouvements(request, response);
                break;
            case "getById":
                getMouvementById(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action not supported.");
        }
    }

    private void insertMouvementProduit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MouvementProduit mouvementProduit = new MouvementProduit();
        FournisseurProduit fournisseurProduit = new FournisseurProduit(); // Récupérer le fournisseur selon vos besoins
        fournisseurProduit.setId(Integer.parseInt(request.getParameter("id_fournisseur_produit"))); // Exemple de récupération

        mouvementProduit.setFournisseurProduit(fournisseurProduit);
        mouvementProduit.setEntree(Boolean.parseBoolean(request.getParameter("entree")));
        mouvementProduit.setSortie(Boolean.parseBoolean(request.getParameter("sortie")));
        mouvementProduit.setQuantite(Double.parseDouble(request.getParameter("quantite")));
        mouvementProduit.setDateMouvement(LocalDate.parse(request.getParameter("dateMouvement")));

        mouvementProduitDAO.insert(mouvementProduit);
        response.sendRedirect("success.jsp");
    }

    private void updateMouvementProduit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MouvementProduit mouvementProduit = new MouvementProduit();
        mouvementProduit.setId(Integer.parseInt(request.getParameter("id")));
        FournisseurProduit fournisseurProduit = new FournisseurProduit(); // Récupérer le fournisseur selon vos besoins
        fournisseurProduit.setId(Integer.parseInt(request.getParameter("id_fournisseur_produit")));

        mouvementProduit.setFournisseurProduit(fournisseurProduit);
        mouvementProduit.setEntree(Boolean.parseBoolean(request.getParameter("entree")));
        mouvementProduit.setSortie(Boolean.parseBoolean(request.getParameter("sortie")));
        mouvementProduit.setQuantite(Double.parseDouble(request.getParameter("quantite")));
        mouvementProduit.setDateMouvement(LocalDate.parse(request.getParameter("dateMouvement")));

        mouvementProduitDAO.update(mouvementProduit);
        response.sendRedirect("success.jsp");
    }

    private void deleteMouvementProduit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        mouvementProduitDAO.delete(id);
        response.sendRedirect("success.jsp");
    }

    private void getAllMouvements(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mouvements", mouvementProduitDAO.getAll());
        request.getRequestDispatcher("mouvementList.jsp").forward(request, response);
    }

    private void getMouvementById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MouvementProduit mouvementProduit = mouvementProduitDAO.getById(id);
        request.setAttribute("mouvementProduit", mouvementProduit);
        request.getRequestDispatcher("mouvementDetails.jsp").forward(request, response);
    }
}

