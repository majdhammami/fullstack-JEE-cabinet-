package com.enit.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.enit.entities.Patient;
import com.enit.service.ILocalConsultation;
import com.enit.service.ILocalPatient;

import com.enit.entities.Medecin;
import com.enit.entities.Medicament;
import com.enit.service.ILocalMedecin;
import com.enit.service.ILocalMedicament;



@WebServlet(name="ControleurServlet",urlPatterns={"/ControleurServlet"})
public class ControleurServlet extends HttpServlet{
	ServletContext context ;
	@EJB private ILocalConsultation metierConsultation;
	@EJB private ILocalPatient metierPatient;
	@EJB private ILocalMedicament metierMedicament;
	@EJB private ILocalMedecin metierMedecin;
	ArrayList<Integer> ids= new ArrayList() ;

	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 
		context= request.getSession().getServletContext();
	
	   List<Patient> listePatients=	metierPatient.lesPatients();

		List<Consultation> listeConsultations=metierConsultation.tousLesConsultations();
		
		List<Medicament> listeMedicaments=metierMedicament.lesMedicaments();

			

			context.setAttribute("listeConsultations", listeConsultations);
				context.setAttribute("listePatients", listePatients);
		  
				context.setAttribute("listeMedicaments", listeMedicaments);

		           context.getRequestDispatcher("/listeConsultations").forward(request, response);

	} 
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 
		context= request.getSession().getServletContext();
	
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
		 
		String medicamentIdStr = request.getParameter("idME");
		int medicamentId=0;
        if(medicamentIdStr!=null && !medicamentIdStr.equals("")){
        	medicamentId=Integer.parseInt(medicamentIdStr);    
 }
		
		String nom2 = request.getParameter("nom");
		String dosgae = request.getParameter("dosage");
		

		Medicament medicament = new Medicament(medicamentId , nom2,  dosgae) ;

	   
		 if(action.equals("ajouter"))

			{ 
			   List<Patient> listePatients=	metierPatient.lesPatients();
			   List<Medicament> listeMedicaments=	metierMedicament.lesMedicaments();

			 if (!(request.getParameter("idC").matches("-?\\d+")))
				{
					request.setAttribute("messageerrorr","Ce champ doit etre un entier");
					request.getRequestDispatcher("listeConsultations.jsp").forward(request, response);
				}
			 
			 else if(request.getParameter("date").isEmpty())
			 {
				 request.setAttribute("messageerrorr2","Ce champ est requis");
					request.getRequestDispatcher("listeConsultations.jsp").forward(request, response);
			 }
			 
			 else if(request.getParameter("heure").isEmpty())
			 {
				 request.setAttribute("messageerrorr3","Ce champ est requis");
					request.getRequestDispatcher("listeConsultations.jsp").forward(request, response); 
			 }
			 else
				 {
				 Integer idConsultation= Integer.parseInt(request.getParameter("idC"));
				 
		
			 
			  if (metierConsultation.existeConsultation(idConsultation))
				{
					request.setAttribute("messageerrorr","cet id est utilisé par un autre medecin");
					request.getRequestDispatcher("listeConsultations.jsp").forward(request, response);
				}
			
			else
			{
			 
				String DateRDV= request.getParameter("date");
				String HeureRDV=request.getParameter("heure");
				String patientString = request.getParameter("choice");
				String MedicamentString = request.getParameter("choice2");
				String MedicamentString2 = request.getParameter("choice3");
				String MedicamentString3 = request.getParameter("choice4");
				Medecin m = new Medecin();
				String userName= (String)request.getSession().getAttribute("userName");

			     m= metierMedecin.getMedecin(userName) ;

				Patient patientSelectionne=   metierPatient.chercherPatient( Integer.parseInt(patientString));
				 
				Medicament medicamentSelectionne=   metierMedicament.chercherMedicament(Integer.parseInt(MedicamentString)) ;
				Medicament medicamentSelectionne2 =   metierMedicament.chercherMedicament(Integer.parseInt(MedicamentString2)) ;
				Medicament medicamentSelectionne3=   metierMedicament.chercherMedicament(Integer.parseInt(MedicamentString3)) ;

				Consultation consultation= new Consultation(idConsultation, DateRDV, HeureRDV,m);
				
					consultation.ajouterMedicament(medicamentSelectionne);
					consultation.ajouterMedicament(medicamentSelectionne2);

				consultation.ajouterMedicament(medicamentSelectionne3);

					
				
					consultation.setIntervenant(m);
				consultation.setPatient(patientSelectionne);

				

				metierConsultation.ajoutConsultation(consultation);
				request.setAttribute("beanConsultation", consultation);
				   List<Consultation> listeConsultations=metierConsultation.tousLesConsultations();

				context.setAttribute("listeConsultations", listeConsultations);
				context.setAttribute("listePatients", listePatients);
				context.setAttribute("listeMedicaments", listeMedicaments);
				 request.setAttribute("consultation", consultation);
			}
		       

		    } 
			}
			else if (action.equals("Reset"))
			{
				if (!(request.getParameter("idC").matches("-?\\d+")))
				{
					request.setAttribute("messageerrorr","Ce champ doit etre un entier");
					request.getRequestDispatcher("listeConsultations.jsp").forward(request, response);
				}
				else
				{
					
				
				   List<Patient> listePatients=	metierPatient.lesPatients();

				 Integer idConsultation= Integer.parseInt(request.getParameter("idC"));

				metierConsultation.supprimerConsultation(idConsultation);

				   List<Consultation> listeConsultations=metierConsultation.tousLesConsultations();

				context.setAttribute("listeConsultations", listeConsultations);
				context.setAttribute("listePatients", listePatients);
				}

			}
			else if (action.equals("Show"))
			{
				   List<Patient> listePatients=	metierPatient.lesPatients();
				   if (!(request.getParameter("idC").matches("-?\\d+")))
					{
						request.setAttribute("messageerrorr5","Ce champ doit etre un entier");
						request.getRequestDispatcher("affmed.jsp").forward(request, response);
					}
				 Integer idConsultation= Integer.parseInt(request.getParameter("idC"));
					Consultation consultation= new Consultation();

				consultation = metierConsultation.chercherConsultation(idConsultation) ;

				 request.setAttribute("consultation", consultation);
		           context.getRequestDispatcher("/affmed.jsp").forward(request, response);


			}
			else if (action.equals("Logout"))
			{
				HttpSession session =request.getSession();
				session.removeAttribute("username");
				session.invalidate();
				response.sendRedirect("login.jsp");
			}
			else if (action.equals("search"))
			{
				   List<Patient> listePatients=	metierPatient.lesPatients();
				   if (!(request.getParameter("idP").matches("-?\\d+")))
					{
						request.setAttribute("messageerrorr4","Ce champ doit etre un entier");
						request.getRequestDispatcher("chercherPatient.jsp").forward(request, response);
					}
				 Integer idd= Integer.parseInt(request.getParameter("idP"));
					context.setAttribute("idP", idd);
			           context.getRequestDispatcher("/chercherPatient.jsp").forward(request, response);


			}
		 if ("Add".equalsIgnoreCase(action))
			{	   
			 if (!(request.getParameter("idP").matches("-?\\d+")))
				{
					request.setAttribute("messageerrorr9","Ce champ doit etre un entier");
					request.getRequestDispatcher("patientinfo.jsp").forward(request, response);
				}
			 else if(request.getParameter("nom").isEmpty())
			 {
				 request.setAttribute("messageerrorr10","Ce champ est requis");
					request.getRequestDispatcher("patientinfo.jsp").forward(request, response);
			 }
			 
			 else if(request.getParameter("prenom").isEmpty())
			 {
				 request.setAttribute("messageerrorr11","Ce champ est requis");
					request.getRequestDispatcher("patientinfo.jsp").forward(request, response); 
			 }
			 
			 else if(request.getParameter("sexe").isEmpty())
			 {
				 request.setAttribute("messageerrorr12","Ce champ est requis");
					request.getRequestDispatcher("patientinfo.jsp").forward(request, response);
			 }
			 
			 else if(request.getParameter("date_Naissance").isEmpty())
			 {
				 request.setAttribute("messageerrorr13","Ce champ est requis");
					request.getRequestDispatcher("patientinfo.jsp").forward(request, response); 
			 }
			 else if(request.getParameter("adresse").isEmpty())
			 {
				 request.setAttribute("messageerrorr14","Ce champ est requis");
					request.getRequestDispatcher("patientinfo.jsp").forward(request, response);
			 }
			 
			 else if(request.getParameter("telephone").isEmpty())
			 {
				 request.setAttribute("messageerrorr15","Ce champ est requis");
					request.getRequestDispatcher("patientinfo.jsp").forward(request, response); 
			 }
			 else
			 {
				 
			 
			 metierPatient.ajoutPatient(patient);
			   List<Patient> listePatients=	metierPatient.lesPatients();
			   List<Medicament> listeMedicaments=	metierMedicament.lesMedicaments();


				context.setAttribute("listePatients", listePatients);
				context.setAttribute("listeMedicaments", listeMedicaments);
				request.setAttribute("patient", patient);
				request.setAttribute("listePatients", metierPatient.lesPatients() ) ;
				request.getRequestDispatcher("patientinfo.jsp").forward(request, response);
				context= request.getSession().getServletContext();

				   this.getServletContext().getRequestDispatcher("/PatientServlet").forward(request, response);
					request.getRequestDispatcher("patientinfo.jsp").forward(request, response);
			 }
			}
			else if ("Edit".equalsIgnoreCase(action))
			{
				if (!(request.getParameter("idP").matches("-?\\d+")))
				{
					request.setAttribute("messageerrorr9","Ce champ doit etre un entier");
					request.getRequestDispatcher("patientinfo.jsp").forward(request, response);
				}
				else
				{
					
				
				metierPatient.modifierPatient(patient);
				   List<Patient> listePatients=	metierPatient.lesPatients();

				context.setAttribute("listePatients", listePatients);

				request.setAttribute("patient", patient);
				request.setAttribute("listePatients", metierPatient.lesPatients() ) ;
				request.getRequestDispatcher("patientinfo.jsp").forward(request, response);
				}
				
			}
			else if ("Delete".equalsIgnoreCase(action))
			{
				if (!(request.getParameter("idP").matches("-?\\d+")))
				{
					request.setAttribute("messageerrorr9","Ce champ doit etre un entier");
					request.getRequestDispatcher("patientinfo.jsp").forward(request, response);
				}
				else
				{
					metierPatient.supprimerPatient(patientId);
				   List<Patient> listePatients=	metierPatient.lesPatients();
					context.setAttribute("listePatients", listePatients);

				request.setAttribute("patient", patient);
				request.setAttribute("listePatients", listePatients ) ;
				request.getRequestDispatcher("patientinfo.jsp").forward(request, response);
					
				}
			
				
			}
			else if ("Search".equalsIgnoreCase(action))
			{
				if (!(request.getParameter("idP").matches("-?\\d+")))
				{
					request.setAttribute("messageerrorr9","Ce champ doit etre un entier");
					request.getRequestDispatcher("patientinfo.jsp").forward(request, response);
				}
				else
				{
					patient = metierPatient.chercherPatient(patientId) ;
					   List<Patient> listePatients=	metierPatient.lesPatients();
						context.setAttribute("listePatients", listePatients);

					request.setAttribute("patient", patient);
					request.setAttribute("listePatients",  listePatients ) ;
					request.getRequestDispatcher("patientinfo.jsp").forward(request, response);
				}
				
			}
			else if ("AddMed".equalsIgnoreCase(action))
			{
				 if (!(request.getParameter("idME").matches("-?\\d+")))
					{
						request.setAttribute("messageerrorr6","Ce champ doit etre un entier");
						request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response);
					}
				 else if(request.getParameter("nom").isEmpty())
				 {
					 request.setAttribute("messageerrorr7","Ce champ est requis");
						request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response);
				 }
				 
				 else if(request.getParameter("dosage").isEmpty())
				 {
					 request.setAttribute("messageerrorr8","Ce champ est requis");
						request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response); 
				 }
				 else
				 {
					 
				 
				
				metierMedicament.ajoutMedicament(medicament);
				   List<Medicament> listeMedicaments=	metierMedicament.lesMedicaments();
					context.setAttribute("listeMedicaments", listeMedicaments);

				   request.setAttribute("medicament", medicament);
					request.setAttribute("listeMedicaments", listeMedicaments ) ;
					request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response);

				 }
			}
			else if ("EditMed".equalsIgnoreCase(action))
			{
				if (!(request.getParameter("idME").matches("-?\\d+")))
				{
					request.setAttribute("messageerrorr6","Ce champ doit etre un entier");
					request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response);
				}
			 else if(request.getParameter("nom").isEmpty())
			 {
				 request.setAttribute("messageerrorr7","Ce champ est requis");
					request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response);
			 }
			 
			 else if(request.getParameter("dosage").isEmpty())
			 {
				 request.setAttribute("messageerrorr8","Ce champ est requis");
					request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response); 
			 }
				metierMedicament.modifierMedicament(medicament);
				   List<Medicament> listeMedicaments=	metierMedicament.lesMedicaments();
					context.setAttribute("listeMedicaments", listeMedicaments);

				   request.setAttribute("medicament", medicament);
					request.setAttribute("listeMedicaments", listeMedicaments ) ;
					request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response);

			}
			else if ("DeleteMed".equalsIgnoreCase(action))
			{
				if (!(request.getParameter("idME").matches("-?\\d+")))
				{
					request.setAttribute("messageerrorr6","Ce champ doit etre un entier");
					request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response);
				}
			 else if(request.getParameter("nom").isEmpty())
			 {
				 request.setAttribute("messageerrorr7","Ce champ est requis");
					request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response);
			 }
			 
			 else if(request.getParameter("dosage").isEmpty())
			 {
				 request.setAttribute("messageerrorr8","Ce champ est requis");
					request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response); 
			 }
				metierMedicament.supprimerMedicament(medicamentId);
				   List<Medicament> listeMedicaments=	metierMedicament.lesMedicaments();
					context.setAttribute("listeMedicaments", listeMedicaments);

				   request.setAttribute("medicament", medicament);
					request.setAttribute("listeMedicaments", listeMedicaments ) ;
					request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response);

			}
			else if ("SearchMed".equalsIgnoreCase(action))
			{
				if (!(request.getParameter("idME").matches("-?\\d+")))
				{
					request.setAttribute("messageerrorr6","Ce champ doit etre un entier");
					request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response);
				}
			 else if(request.getParameter("nom").isEmpty())
			 {
				 request.setAttribute("messageerrorr7","Ce champ est requis");
					request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response);
			 }
			 
			 else if(request.getParameter("dosage").isEmpty())
			 {
				 request.setAttribute("messageerrorr8","Ce champ est requis");
					request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response); 
			 }
				medicament = metierMedicament.chercherMedicament(medicamentId) ;
				   List<Medicament> listeMedicaments=	metierMedicament.lesMedicaments();
					context.setAttribute("listeMedicaments", listeMedicaments);

				   request.setAttribute("medicament", medicament);
					request.setAttribute("listeMedicaments", listeMedicaments ) ;
					request.getRequestDispatcher("medicamentinfo.jsp").forward(request, response);

			}
		 
		 

		

		 
		 
			request.setAttribute("Lesconsultations", metierConsultation.tousLesConsultations());
		
	     //  request.getRequestDispatcher("/listeCours.jsp").forward(request, response); 
           context.getRequestDispatcher("/listeConsultations.jsp").forward(request, response);
	} 
	}
