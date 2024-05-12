<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  margin: 0;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 25%;
  background-color: #f1f1f1;
  position: fixed;
  height: 100%;
  overflow: auto;
}

li a {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

li a.active {
  background-color: #04AA6D;
  color: white;
}

li a:hover:not(.active) {
  background-color: #555;
  color: white;
}
</style>
</head>
<body>
<ul>
       
  
  
  <li><a class="active" href="#home">Accueil</a></li>
  <li><a href="listeConsultations.jsp">Gestion des Consultations</a></li>
     <li><a href="ListedesConsultations.jsp">Liste des Consultations</a></li>
  <li><a href="medicamentinfo.jsp">Liste des medicaments</a></li>
  <li><a href="patientinfo.jsp">Liste des patients</a></li>
    <li><a href="chercherPatient.jsp">Chercher les consultations d'un patient</a></li>
    <li><a href="affmed.jsp">Medicaments données</a></li>
  
</ul>

              


</body>
</html>