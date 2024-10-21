package controller.fournisseur;

import dao.fournisseur.FournisseurDAO;
import util.elevage.Elevage;
import util.fournisseur.Fournisseur;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

public class FournisseurController extends HttpServlet {

    private FournisseurDAO myfournisseur=new FournisseurDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom=request.getParameter("nom");
        String email = request.getParameter("email");
        String mdp=request.getParameter("mdp");
        try{
            Fournisseur fournisseur=new Fournisseur(nom,email,mdp);
            myfournisseur.insert(fournisseur);
            HttpSession session = request.getSession();
            session.setAttribute("idutilisateur", fournisseur.getId());
            response.sendRedirect("index.jsp");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String mdp=request.getParameter("mdp");
        PrintWriter out=response.getWriter();
        try{
            Fournisseur fournisseur=new Fournisseur(email,mdp);
            int valiny=myfournisseur.estFournisseur(fournisseur);
            out.println(valiny);
            if(valiny!=0){

                out.println("tafiditra");
                HttpSession session = request.getSession();
                session.setAttribute("idutilisateur", valiny);
                response.sendRedirect("index.jsp");
            }else{
                out.println("tsy mety");
                response.sendRedirect("connexion.jsp");
            }

        }catch(Exception e){
            e.printStackTrace(); 
        }
    }
}