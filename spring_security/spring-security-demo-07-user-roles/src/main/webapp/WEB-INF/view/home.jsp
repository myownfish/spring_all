<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>

<html>

<head>
    <title>luv2code Company Home Page</title>
</head>

<body>

 <h2>luv2code Company Home Page</h2>
 <hr>
 <p>
 Welcome to the luv2code company home page!
 </p>
 
 <hr>
 
 <p>
     User: <security:authentication property="principal.username"/>
     <br><br>
     Role(s): <security:authentication property="principal.authorities"/>
 </p>
 
 <hr>
 
 <security:authorize access="hasRole('MANAGER')">
 <p>
     <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
     (Only for Manager peeps)
 </p>
 </security:authorize>
 
 <security:authorize access="hasRole('ADMIN')">
  <p>
     <a href="${pageContext.request.contextPath}/systems">IT System Meeting</a>
     (Only for Admin peeps)
 </p>
 </security:authorize>
 
 <hr>
 
 <form:form action="${pageContext.request.contextPath}/logout" method="POST">
   <input type="submit" value="Logout" />
 </form:form>
</body>

</html>









