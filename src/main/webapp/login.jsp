<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style2.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container">
            <div class="box">
                <img class="avatar" src="img/user-avatar.png">
<form  action="./LoginRegister" method="POST" >
<tr>
<td><h3 style="color:red;">${message }</h3>

<h3 style="color:green;"> ${successMessage}</h3>

</td>

<div class="screen-1">

 
    <div class="email">
  

<tr><td>UserName  </td><td><input style="" type="text" name="username" value="${medecin.username}"></td></tr>
   

    </div>
    
    <div class="password">

<tr><td>password  </td><td><input type="password" name="password11" value="${medecin.password}"></td></tr>

    </div>

<tr><td><a href="listeConsultations.jsp"><input 
 type="submit" name="action" value="login"></a></td>
 
 <td><a href="Register.jsp">Registration</a></td></tr>
</div>
</form>
</body>
</html>