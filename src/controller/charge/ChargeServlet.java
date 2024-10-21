package controller.charge;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import util.charge.Charge;
import util.charge.TypeCharge;
import util.comptabilite.AnalytiqueDesCouts;
import util.comptabilite.ChargeAnalytique;

public class ChargeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Récupération des données du formulaire
        String nom = request.getParameter("nom"); 
        double prixUnitaire = Double.parseDouble(request.getParameter("prix_unitaire")); 
        String uniteOeuvre = request.getParameter("unite_oeuvre"); 
        int idChargeAnalytique = Integer.parseInt(request.getParameter("chargeAnalytique")); 
        int idAnalytiqueDesCouts = Integer.parseInt(request.getParameter("analytiqueCouts")); 
        int idTypeCharge = Integer.parseInt(request.getParameter("typeCharge")); 

        // Création d'une instance de Charge
        Charge charge = new Charge();
        charge.setNom(nom);
        charge.setPrix_unitaire(prixUnitaire);
        charge.setUnite_oeuvre(uniteOeuvre);

        // Création des objets associés
        ChargeAnalytique chargeAnalytique = new ChargeAnalytique();
        chargeAnalytique.setId(idChargeAnalytique);
        charge.setChargeAnalytique(chargeAnalytique);

        AnalytiqueDesCouts analytiqueDesCouts = new AnalytiqueDesCouts();
        analytiqueDesCouts.setId(idAnalytiqueDesCouts);
        charge.setAnalytiqueDesCouts(analytiqueDesCouts);

        TypeCharge typeCharge = new TypeCharge();
        typeCharge.setId(idTypeCharge);
        charge.setTypeCharge(typeCharge);

        // Logique pour traiter les données (par exemple, enregistrer dans la base de données)
        ChargeDao chargeDao = new ChargeDao();
        chargeDao.save(charge); // Implémentez la méthode save pour insérer dans la base de données

        // Redirection ou affichage d'un message après le traitement
        response.sendRedirect("confirmation.jsp"); // Redirection vers une page de confirmation
    }
}
