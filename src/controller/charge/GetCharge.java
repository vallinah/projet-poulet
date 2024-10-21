package controller.charge;

import connexion.Connexion;
import java.io.IOException;
import java.util.List;

import dao.charge.ChargeAnalytiqueDAO;
import dao.charge.ChargeDAO;
import dao.charge.TypeChargeDAO;
import dao.comptabilite.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.charge.Charge;
import util.charge.Rubrique;
import util.charge.TypeCharge;
import util.comptabilite.AnalytiqueDesCouts;
import util.comptabilite.ChargeAnalytique;

public class GetCharge extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        ChargeDAO dao = new ChargeDAO();
        String path ="";

        try {
            if (action != null && !action.isEmpty()) {
                switch (action) {
                    case "insert":
                        List<ChargeAnalytique> chargeAnalytique = new ChargeAnalytiqueDAO().getAll();
                        List<AnalytiqueDesCouts> analytiqueDesCouts = new AnalytiqueDesCoutsDAO().getAll();
                        List<TypeCharge> typeCharge = new TypeChargeDAO().getAll();
                        request.setAttribute("chargeAnalytique", chargeAnalytique);
                        request.setAttribute("analytiqueDesCouts", analytiqueDesCouts);
                        request.setAttribute("typeCharge", typeCharge);
                        path = "pages/forms/insertCharge.jsp";
                        request.getRequestDispatcher(path).forward(request, response);

                        break;
                    case "modifier":
                        int chargeId = Integer.parseInt(request.getParameter("chargeId"));
                        Charge charge = dao.getById(chargeId);
                        request.setAttribute("charge", charge);
                        path = "/pages/forms/insertCharge.jsp";
                        request.getRequestDispatcher(path).forward(request, response);
                        break;
                    case "depense":
                        List<Charge> chargess = new ChargeDAO().getAll();
                        request.setAttribute("charges", chargess);
                        path = "pages/forms/insertDepense.jsp";
                        request.getRequestDispatcher(path).forward(request, response);
                        break;
                    case "list":
                        List<Rubrique> rubriques = Rubrique.getRubriques();
                        Connexion connexion = new Connexion();
                        int id_elevage =  Integer.parseInt(request.getParameter("id_elevage"));
                        GestionFinances gestionFinances = new GestionFinances();
                        double chiffreAffaire = gestionFinances.getChiffreAffaire(id_elevage);
                        double total_cout = gestionFinances.getTotalCout(id_elevage);
                        double beneficie = gestionFinances.getBenefice(id_elevage);
                        double margeTotal = gestionFinances.getMargeGlobale(id_elevage);
                        request.setAttribute("rubriques", rubriques);
                        request.setAttribute("chiffreAffaire", chiffreAffaire);
                        request.setAttribute("total_cout", total_cout);
                        request.setAttribute("beneficie", beneficie);
                        request.setAttribute("margeTotal", margeTotal);
                        request.getRequestDispatcher("pages/tables/basic-table.jsp").forward(request, response);
                        break;
                    default:
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                        break;
                }

            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println(e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
