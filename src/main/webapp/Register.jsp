<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Account</title>

<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style2.css" rel="stylesheet" type="text/css"/>
</head>
<style>

</style>
<body>
<div class="container">
            <div class="regbox box">
                <img class="avatar" src="img/collaboration.png">
<form action="./LoginRegister" method="POST"  >

<div class="screen-1">


  <td><h3 style="color:red;"> ${messageerror}</h3></td>
    <td><h3 style="color:red;"> ${messageerror2}</h3></td>
  
   <div class="email">
  
<tr><td>UserName  </td><td><input style="" type="text" placeholder="Username" name="username" value="${medecin.username}"></td></tr>
       </div>
   
    
    
    <div class="email">
  
<tr><td>Name  </td><td><input style="" type="text" placeholder="name" name="name" value="${medecin.nom}"></td></tr>
   

    </div>
    
    <div class="password">

<tr><td>password  </td><td><input type="password" placeholder="password" name="password1" value="${medecin.password}"></td></tr>
    </div>
<div class="password">

<tr><td>Re-Type password  </td><td><input type="password" placeholder="password2" name="password2"></td></tr>
    </div>
    
<tr><td colspan="2">
                        <input  type="submit" name="action" value="Register" />
                        
                    </td>      
 <td></td>
 </tr>
</div>
</form>
</body>
</html>