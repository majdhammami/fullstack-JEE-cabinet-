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
<style>
/* Style The Dropdown Button */
.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #f1f1f1}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
  display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
  background-color: #3e8e41;
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
/* Add a card effect for articles */
.card {
 
  padding: 20px;
  margin-top: 20px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

.active {
  background-color: #04AA6D;
  color: white;
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


        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style2.css" rel="stylesheet" type="text/css"/>
        </head>
        
<body>
<div class="header">
  <h1>Gestion des Rendez-Vous</h1>
</div>

<div class="topnav">
  <a   href="listeConsultations.jsp">Gestion des consultations</a>
       <a   href="ListedesConsultations.jsp">Liste des Consultations</a>
  
    <a href="chercherPatient.jsp">Chercher les consultations d'un patient</a>
        <a class="active" href="affmed.jsp">Medicaments données </a>
  
    <a href="medicamentinfo.jsp">Gestion des medicaments</a>
  
  <a href="patientinfo.jsp">Gestion des patients</a>
  
</div>

        <div class="card">
    
<div class="container">
    
    <form method="POST" action="./ControleurServlet">
    
       <div class="row">
    <div class="col-25">
      ID du consultation   : &nbsp;&nbsp;  
      </div>
    <div class="col-75">
    <input type="text" name="idC" size="20" value="${idConsultation}" placeholder="IdConsultation" />  <br>  <br>        
       </div>
                                <td><h3 style="color:red;"> ${messageerrorr5}</h3></td>
       
     </div>
          <div class="row">
               <input  type="submit" value="Show" name="action" /> 
  
             
              
  </div>
    Med1:   <input type="text" name="date" size="20" value="${consultation.med[0].nom}"  disabled="disabled"/>   <br>  <br>  
         Med2:   <input type="text" name="date" size="20" value="${consultation.med[1].nom}"disabled="disabled"/>   <br>  <br>  
         Med3:   <input type="text" name="date" size="20" value="${consultation.med[2].nom}" disabled="disabled"/>   <br>  <br>  
              
            </form>
   
            </div>
    
                  
              
 <div class="row">                                                               <br> <br> 
                           
     <form action="Logout">
                   <input type="submit" value="Logout" name="action"  />
     
     
     </form>
         </div>
                                                                              <br> <br> 
         
                                                                     <br> <br> 
                                                                     <br> <br> 
                                                                     <br> <br> 
                                                                     
     
   <div class="footer">
</div>
    </body></html>