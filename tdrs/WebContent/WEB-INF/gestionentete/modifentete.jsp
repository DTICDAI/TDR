 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>  
  
  <!DOCTYPE html>
<html>
<head>
<title>Saisies obligatoires</title>
<style>
*{
   font-family:calibri;
   font-size:19px;
}

label{ /* Pour alignement des zones de saisie */
   width:150px;
   display:inline-block;
   margin-bottom:20px;
}
form { /* Cadre du formulaire */
   border:2px solid gray;
   border-radius:10px;
   box-sizing:border-box;
   padding:15px;
   width:600px;
   margin:auto;
} 
input {
   border:2px solid gray;
   border-radius:5px;
}



textarea {
    padding: 10px;
    line-height: 1.5;
    border-radius: 5px;
    border: 1px solid #ccc;
    box-shadow: 1px 1px 1px #999;
</style>

<script type="text/javascript">
	function afficherdiv(){ alert("p");
		document.getElementById('demo').style.display = 'block';
	}
	
	function cacherdiv(){
		document.getElementById('demo').style.display = 'none';
	}	
</script>

</head>

<body>
<form  action="modif_entete" method="post">

<!--form action="modif_entete" method="get"-->
	<c:if test="${existentete != null}">
	        <c:forEach var="enteteamodif" items="${existentete}"> 
				   <label>ENTETE-DROITE</label><input type="text" id="Entete_droite" name ="Entete_droite" value="${enteteamodif.entete_droite}"  required /><br />
					<label>ENTETE</label>
					<input type="text" id="Entete" name ="Entete" value="${enteteamodif.entete}"/><br />
					<label>LOGO</label><input type="text" id="logo" name ="logo" value="${enteteamodif.logo}" /> 
						
						<a onclick="afficherdiv()" >Modifier</a>
								  <div id="demo" style="display:'none' ">								
										<input type="text" name="autre_transfert">									
								  </div>
							
					<br />
					<input type="hidden" name="id_entete" id="id_entete" value="${enteteamodif.id_entete}">
				   <input type="submit" id="submit" value="Envoyer" />
				   <input type="submit" id="submit" value="Annuler" />
			</c:forEach>
	</c:if>			   
</form>
</body>
</html>    