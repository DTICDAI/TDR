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

</head>

<body>
<form id="signaletique" action="ajout_entete" method="post">
   <label>ENTETE-DROITE</label><input type="text" id="Entete_droite" name ="Entete_droite" required /><br />
   <label for="avatar">LOGO</label><input type="file" id="logo" name="logo" multiple><br>  
   <label for="story">ENTETE</label><textarea id="Entete" name="Entete" rows="5" cols="33"></textarea> 
   
   <input type="submit" id="submit" value="Envoyer" />
   <a onClick="history.back()"><input type="button" value="Annuler"></a>
       
</form>
</body>
</html>    