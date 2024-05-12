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
import javax.servlet.http.HttpSession;

import com.enit.entities.Consultation;
import com.enit.entities.Medecin;
import com.enit.entities.Medicament;
import com.enit.entities.Patient;
import com.enit.service.ILocalConsultation;
import com.enit.service.ILocalMedecin;
import com.enit.service.ILocalMedicament;
import com.enit.service.ILocalPatient;



/**
 * Servlet implementation class PatientServlet
 */
@WebServlet(name = "LoginRegister", urlPatterns = {"/LoginRegister"})
public class LoginRegister extends HttpServlet {

	@EJB
	private ILocalMedecin medecinDao;
	ServletContext context ;
	@EJB private ILocalConsultation metierConsultation;
	@EJB private ILocalPatient metierPatient;
	@EJB private ILocalMedicament metierMedicament;
	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action") ;

	
		String userName=request.getParameter("username");
		request.getSession().setAttribute("userName", userName);
		String password=request.getParameter("password11");

		Medecin m = new Medecin();
		
	 m= medecinDao.getMedecin(userName) ;
	 
		
		if(("login".equalsIgnoreCase(action)) && (m!=null) && (m.getNom()!=null) &&(m.getPassword().equals(password)))
		{
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			request.setAttribute("userName", userName);
			context= request.getSession().getServletContext();
			
			   List<Patient> listePatients=	metierPatient.lesPatients();

				List<Consultation> listeConsultations=metierConsultation.tousLesConsultations();
				
				List<Medicament> listeMedicaments=metierMedicament.lesMedicaments();

					

					context.setAttribute("listeConsultations", listeConsultations);
						context.setAttribute("listePatients", listePatients);
				  
						context.setAttribute("listeMedicaments", listeMedicaments);

				
			      // request.getRequestDispatcher("listeCours.jsp").forward(request, response); 
			this.getServletContext().getRequestDispatcher("/Menu.jsp").forward(request, response);
	  // this.getServletContext().getRequestDispatcher("/listeConsultations.jsp").forward(request, response);
	   this.getServletContext().getRequestDispatcher("/MenuServlet").forward(request, response);

			
			//request.setAttribute("message", m.getNom());
			request.getRequestDispatcher("Menu.jsp").forward(request, response);

		}

		else if ("Register".equalsIgnoreCase(action))
		{
			if (!(request.getParameter("password1").equals(request.getParameter("password2"))))
			{
			

				request.setAttribute("messageerror","ERROR !!Retype password !!");
				request.getRequestDispatcher("Register.jsp").forward(request, response);

			}
			else if(request.getParameter("name").isEmpty() || request.getParameter("password1").isEmpty()
					|| request.getParameter("password2").isEmpty()|| request.getParameter("username").isEmpty() )
			{
				request.setAttribute("messageerror2","ERROR !!Retype !!");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
			else
			{
			
			
			String username = request.getParameter("username");
			String nom = request.getParameter("name");
			String password1 = request.getParameter("password1");
			

			Medecin medecin = new Medecin(username , password1,  nom) ;
			medecinDao.insertMedecin(medecin);
			
				request.setAttribute("successMessage","Registration Done please login to continue !!!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				request.setAttribute("medecin", medecin);

			}
			
		}
		
		else
		{
			request.setAttribute("message","Data Not Found, click on Register !!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		request.setAttribute("Lesmedecins", medecinDao.lesMedecins() ) ;
		//request.getRequestDispatcher("Login.jsp").forward(request, response);

		
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
