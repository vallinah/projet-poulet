package controller.fournisseur;

import java.io.IOException;
import java.io.PrintWriter;

import dao.fournisseur.ProformatDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.fournisseur.*;
import java.util.ArrayList;
import java.util.List;

public class ProformatController extends HttpServlet{
    private ProformatDAO myfournisseur=new ProformatDAO();
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    }
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Proformat> myproformat = null;
    HttpSession session = request.getSession(); 
    Integer idUtilisateur = (Integer) session.getAttribute("idutilisateur"); // Récupérer l'attribut de session
    PrintWriter out = response.getWriter();
    
    out.print("tonga"); // Indication que la méthode doGet a été appelée
    
    if (idUtilisateur != null) { // Vérifier si l'utilisateur est connecté
    try {
        int idUtilisateurInt = idUtilisateur.intValue();
        myproformat = myfournisseur.getById(idUtilisateurInt);
        out.print(myproformat.size()); // L'utilisateur est valide
        request.setAttribute("listeproformat", myproformat);
        RequestDispatcher dispat = request.getRequestDispatcher("proformat.jsp");
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