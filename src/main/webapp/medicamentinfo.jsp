<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html> 
<html>

<head>
<style>
* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
* {
  box-sizing: border-box;
}

body {
  margin: 0;
}

/* Style the header */
.header {
  background-color: #f1f1f1;
  padding: 20px;
  text-align: center;
}

/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color: #333;
}

/* Style the topnav links */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Create three unequal columns that floats next to each other */
.column {
  float: left;
  padding: 10px;
}

/* Left and right column */
.column.side {
  width: 25%;
}

/* Middle column */
.column.middle {
  width: 50%;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .column.side, .column.middle {
    width: 100%;
  }
}

/* Style the footer */
.footer {
  background-color: #f1f1f1;
  padding: 10px;
  text-align: center;
}
.active {
  background-color: #04AA6D;
  color: white;
}

        </style>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #04AA6D;
  color: white;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style2.css" rel="stylesheet" type="text/css"/>
<title>Gestion des medicaments</title>
</head>
<body>
<div class="header">
  <h1>Gestion des Rendez-Vous</h1>
</div>

<div class="topnav">
  <a   href="listeConsultations.jsp">Gestion des consultations</a>
       <a   href="ListedesConsultations.jsp">Liste des Consultations</a>
  
    <a  href="chercherPatient.jsp">Chercher les consultations d'un patient</a>
    
          <a  href="affmed.jsp">Medicaments donn�es </a>
  
    <a class="active" href="medicamentinfo.jsp">Gestion des medicaments</a>
  
  <a href="patientinfo.jsp">Gestion des patients</a>
  
</div>
<h1>Gestion des medicaments</h1>
<div class="container">

<form action="./ControleurServlet" method="POST">
<div class="row">
    <div class="col-25">
                     Medicament ID
                     </div>
    <div class="col-75">
                        
                   <input type="text" name="idME" value="${medicament.idME}" placeholder="MedicamentID"/>
               </div>
                                        <td><h3 style="color:red;"> ${messageerrorr6}</h3></td>
               
  </div>
  <div class="row">
    <div class="col-25">
                    Nom
                     </div>
    <div class="col-75">
                    <td><input type="text" name="nom" value="${medicament.nom}" placeholder="Label"/></td>
               </div>
                                        <td><h3 style="color:red;"> ${messageerrorr7}</h3></td>
               
  </div>
  <div class="row">
    <div class="col-25">
                   Dosage
                   </div>
    <div class="col-75">
                        
                    <input type="text" name="dosage" value="${medicament.dosage}" placeholder="Dosage" />
                    </div>
                                             <td><h3 style="color:red;"> ${messageerrorr8}</h3></td>
                    
  </div>
                
                
              <br>  
<div class="row">                        <input type="submit" name="action" value="SearchMed" />
                        <input type="submit" name="action" value="DeleteMed" />
                        <input type="submit" name="action" value="EditMed" />

                        <input type="submit" name="action" value="AddMed" />
                          </div>
                        
        </form>        
        </div>
        
        <br>
        <table border="1">
            <th>ID</th>
            <th>Nom</th>
            <th>Dosage</th>
            
            <c:forEach items="${listeMedicaments}" var="medi">
                <tr>
                
                    <td>${medi.idME}</td>
                    <td>${medi.nom}</td>
                    <td>${medi.dosage}</td>
               
                </tr>
            </c:forEach>
        </table>  
        <br> <br> 
        <br> <br> 
        
 
</body>
</html>