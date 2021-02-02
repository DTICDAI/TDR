 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>

<html>
<head>
 <style>
      table, th, td {
      padding: 10px;
      border: 1px solid black;
      border-collapse: collapse;
      }
    </style>
</head>

<body>

  <h1>
  	Liste entete
  </h1>

  <table>
  <tr>
  	<td>
  		<a href="ajout_entete">Ajout</a>
  	</td>  
  </tr>
  <c:choose>
  		<c:when test="${not empty listeentete}">
  			  				
  				  <c:forEach var="str" items="${listeentete}">
	  					<tr>
	  					
	  						<td>
	  							<a href="modif_entete?id_entete=${str.id_entete}">Modif</a>	  							   
	  						</td>	
	  						<c:if test ="${str.etat == 'I'}">                           
                      				<td>Inactif</td>
                  			</c:if>
	  						<c:if test ="${str.etat == 'A'}">                           
                      				<td>Actif</td>
                  			</c:if>
                  			                  				  					
	  						<td>${str.entete_droite}</td>	  							  					
	  						<td><IMG SRC=" ${str.logo} " height="50" width="50"/></td>
	  		                <td>${str.entete}</td>
	  					</tr>  	
  				  </c:forEach>  				
  
  		</c:when>
  		<c:otherwise>
  			<br> Il n'y a pas d'entete enregistré dans la base de données
  		</c:otherwise>
  </c:choose>

</table>


</body>
</html>

