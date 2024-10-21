package controller.fournisseur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.fournisseur.LivraisonDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.fournisseur.FactureProduit;
import util.fournisseur.Proformat;

public class LivraisonController extends HttpServlet{
     private LivraisonDAO mylivraison=new LivraisonDAO();

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<FactureProduit> myproformat = null;
    HttpSession session = request.getSession(); 
    Integer idUtilisateur = (Integer) session.getAttribute("idutilisateur"); // Récupérer l'attribut de session
    PrintWriter out = response.getWriter();
    
    out.print("tonga"); // Indication que la méthode doGet a été appelée
    
    if (idUtilisateur != null) { // Vérifier si l'utilisateur est connecté
    try {
        int idUtilisateurInt = idUtilisateur.intValue();
        myproformat = mylivraison.getFactureProduitsParFournisseur(idUtilisateurInt);
        out.print(myproformat.size()); // L'utilisateur est valide
        request.setAttribute("listefacture", myproformat);
        RequestDispatcher dispat = request.getRequestDispatcher("facture.jsp");
        dispat.forward(request, response); // Rediriger vers la page JSP
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        out.print("diso"); // L'utilisateur n'est pas connecté
        response.sendRedirect("connexion.jsp"); // Redirection vers la page de connexion
    }
}     
}
