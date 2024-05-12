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
 * Servlet implementation class PatientServlet
 */
@WebServlet(name = "PatientServlet", urlPatterns = {"/PatientServlet"})
public class PatientServlet extends HttpServlet {
	ServletContext context ;

	@EJB
	private ILocalPatient patientDao;
	@EJB private ILocalMedicament metierMedicament;
	@EJB private ILocalMedecin metierMedecin;
	@EJB private ILocalConsultation metierConsultation;


	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		context= request.getSession().getServletContext();
		
		   List<Patient> listePatients=	patientDao.lesPatients();

			List<Consultation> listeConsultations=metierConsultation.tousLesConsultations();
			
			List<Medicament> listeMedicaments=metierMedicament.lesMedicaments();

				

				context.setAttribute("listeConsultations", listeConsultations);
					context.setAttribute("listePatients", listePatients);
			  
					context.setAttribute("listeMedicaments", listeMedicaments);

			
		String action = request.getParameter("action") ;
		String patientIdStr = request.getParameter("idP");
		int patientId=0;
        if(patientIdStr!=null && !patientIdStr.equals("")){
        	patientId=Integer.parseInt(patientIdStr);    
        }
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String sexe = request.getParameter("sexe");
		String Date_Naissance = request.getParameter("date_Naissance");
		String adresse = request.getParameter("adresse");
		String telephone= request.getParameter("telephone");

		Patient patient = new Patient(patientId , nom,  prenom, sexe, Date_Naissance, adresse, telephone) ;

		if ("Add".equalsIgnoreCase(action))
		{
			patientDao.ajoutPatient(patient);
			context.setAttribute("listePatients", listePatients);
			context.setAttribute("listeConsultations", listeConsultations);
			context.setAttribute("listeMedicaments", listeMedicaments);
			request.setAttribute("patient", patient);
			request.setAttribute("Lespatients", patientDao.lesPatients() ) ;
			request.getRequestDispatcher("patientinfo.jsp").forward(request, response);
			context= request.getSession().getServletContext();

			   this.getServletContext().getRequestDispatcher("/PatientServlet").forward(request, response);



			
		}
		else if ("Edit".equalsIgnoreCase(action))
		{
			patientDao.modifierPatient(patient);
			
		}
		else if ("Delete".equalsIgnoreCase(action))
		{
			patientDao.supprimerPatient(patientId);
		}
		else if ("Search".equalsIgnoreCase(action))
		{
			patient = patientDao.chercherPatient(patientId) ;
		}
		request.setAttribute("patient", patient);
		request.setAttribute("Lespatients", patientDao.lesPatients() ) ;
		request.getRequestDispatcher("patientinfo.jsp").forward(request, response);

		
	}

	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        context= request.getSession().getServletContext();
    	
 	   List<Patient> listePatients=	patientDao.lesPatients();

 		List<Consultation> listeConsultations=metierConsultation.tousLesConsultations();
 		
 		List<Medicament> listeMedicaments=metierMedicament.lesMedicaments();

 			

 			context.setAttribute("listeConsultations", listeConsultations);
 				context.setAttribute("listePatients", listePatients);
 		  
 				context.setAttribute("listeMedicaments", listeMedicaments);

 		
 	      // request.getRequestDispatcher("listeCours.jsp").forward(request, response); 
            context.getRequestDispatcher("/patientinfo").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        context= request.getSession().getServletContext();
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
	

}
