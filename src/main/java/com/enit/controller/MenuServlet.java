package com.enit.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enit.entities.Consultation;
import com.enit.entities.Medicament;
import com.enit.entities.Patient;
import com.enit.service.ILocalConsultation;
import com.enit.service.ILocalMedecin;
import com.enit.service.ILocalMedicament;
import com.enit.service.ILocalPatient;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet(name="MenuServlet",urlPatterns={"/MenuServlet"})
public class MenuServlet extends HttpServlet {
	ServletContext context ;
	@EJB private ILocalConsultation metierConsultation;
	@EJB private ILocalPatient metierPatient;
	@EJB private ILocalMedicament metierMedicament;
	@EJB private ILocalMedecin metierMedecin;
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		context= request.getSession().getServletContext();
		
		   List<Patient> listePatients=	metierPatient.lesPatients();

			List<Consultation> listeConsultations=metierConsultation.tousLesConsultations();
			
			List<Medicament> listeMedicaments=metierMedicament.lesMedicaments();

				

				context.setAttribute("listeConsultations", listeConsultations);
					context.setAttribute("listePatients", listePatients);
			  
					context.setAttribute("listeMedicaments", listeMedicaments);

			
		      // request.getRequestDispatcher("listeCours.jsp").forward(request, response); 
	           context.getRequestDispatcher("/listeConsultations").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
