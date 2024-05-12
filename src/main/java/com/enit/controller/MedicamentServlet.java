package com.enit.controller;

import java.io.IOException;



import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enit.entities.Medicament;
import com.enit.service.ILocalMedicament;



/**
 * Servlet implementation class PatientServlet
 */
@WebServlet(name = "MedicamentServlet", urlPatterns = {"/MedicamentServlet"})
public class MedicamentServlet extends HttpServlet {

	@EJB
	private ILocalMedicament medicamentDao;
	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") ;
		String medicamentIdStr = request.getParameter("idME");
		int medicamentId=0;
        if(medicamentIdStr!=null && !medicamentIdStr.equals("")){
        	medicamentId=Integer.parseInt(medicamentIdStr);    
        }
		
		String nom = request.getParameter("nom");
		String dosgae = request.getParameter("dosage");
		

		Medicament medicament = new Medicament(medicamentId , nom,  dosgae) ;

		if ("Add".equalsIgnoreCase(action))
		{
			medicamentDao.ajoutMedicament(medicament);
			
		}
		else if ("Edit".equalsIgnoreCase(action))
		{
			medicamentDao.modifierMedicament(medicament);
			
		}
		else if ("Delete".equalsIgnoreCase(action))
		{
			medicamentDao.supprimerMedicament(medicamentId);
		}
		else if ("Search".equalsIgnoreCase(action))
		{
			medicament = medicamentDao.chercherMedicament(medicamentId) ;
		}
		request.setAttribute("medicament", medicament);
		request.setAttribute("Lesmedicaments", medicamentDao.lesMedicaments() ) ;
		request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response);

		
	}

	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
	

}
