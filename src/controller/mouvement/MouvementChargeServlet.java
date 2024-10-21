package controller.mouvement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.charge.Charge;
import util.mouvement.MouvementCharge;

import java.io.IOException;
import java.time.LocalDate;

import dao.charge.ChargeDAO;

public class MouvementChargeServlet extends HttpServlet {

    private MouvementChargeDAO mouvementChargeDAO = new MouvementChargeDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "insert":
                insertMouvementCharge(request, response);
                break;
            case "update":
                updateMouvementCharge(request, response);
                break;
            case "delete":
                deleteMouvementCharge(request, response);
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

    private void insertMouvementCharge(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MouvementCharge mouvementCharge = new MouvementCharge();
        Charge charge = new ChargeDAO().getById(Integer.parseInt(request.getParameter("id_charge")));
        mouvementCharge.setCharge(charge);
        mouvementCharge.setEntree(Boolean.parseBoolean(request.getParameter("entree")));
        mouvementCharge.setSortie(Boolean.parseBoolean(request.getParameter("sortie")));
        mouvementCharge.setQuantite(Double.parseDouble(request.getParameter("quantite")));
        mouvementCharge.setDateMouvement(LocalDate.parse(request.getParameter("dateMouvement")));

        mouvementChargeDAO.insert(mouvementCharge);
        response.sendRedirect("success.jsp");
    }

    private void updateMouvementCharge(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MouvementCharge mouvementCharge = new MouvementCharge();
        mouvementCharge.setId(Integer.parseInt(request.getParameter("id")));
        Charge charge = new ChargeDAO().getById(Integer.parseInt(request.getParameter("id_charge")));
        mouvementCharge.setCharge(charge);
        mouvementCharge.setEntree(Boolean.parseBoolean(request.getParameter("entree")));
        mouvementCharge.setSortie(Boolean.parseBoolean(request.getParameter("sortie")));
        mouvementCharge.setQuantite(Double.parseDouble(request.getParameter("quantite")));
        mouvementCharge.setDateMouvement(LocalDate.parse(request.getParameter("dateMouvement")));

        mouvementChargeDAO.update(mouvementCharge);
        response.sendRedirect("success.jsp");
    }

    private void deleteMouvementCharge(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        mouvementChargeDAO.delete(id);
        response.sendRedirect("success.jsp");
    }

    private void getAllMouvements(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mouvements", mouvementChargeDAO.getAll());
        request.getRequestDispatcher("mouvementList.jsp").forward(request, response);
    }

    private void getMouvementById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MouvementCharge mouvementCharge = mouvementChargeDAO.getById(id);
        request.setAttribute("mouvementCharge", mouvementCharge);
        request.getRequestDispatcher("mouvementDetails.jsp").forward(request, response);
    }
}

