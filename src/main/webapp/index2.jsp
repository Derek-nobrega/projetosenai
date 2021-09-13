<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="dao.loginDao"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.paciente"%>
<%@page import="model.login"%>

<%@page import="java.util.List"%>
<%@page import="dao.pacienteDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.sun.net.httpserver.Authenticator.Result"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="crud.db.conexao" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<meta http-equiv="refresh" content="60">
	<style>
		.pointer {cursor: pointer;}
	</style>
<title>Painel Operatorio</title>
</head>
<body>
<%
LocalDateTime myDateTime = LocalDateTime.now();
DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
String formattedDate = myDateTime.format(myFormatter);

%>
<ul class="nav">
  <li class="nav-item">
  <img src="https://blog-static.infra.grancursosonline.com.br/wp-content/uploads/2015/06/03165141/GDF.jpg" alt="alternatetext" width="90" height="70">
    Hospital Regional de Taguatinga – HRT|Secretaria de Saúde do Distrito Federal  <%= formattedDate %>
  </li>
</ul>
    	 <%
			pacienteDao objDao = new pacienteDao() ;  
	        List<paciente> ls = objDao.listaPaciente();
				 if(ls.size()> 0) {
				
       	 %>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Nome do paciente</th>
      <th scope="col">Status</th>
      <th scope="col">Inicio Previsto</th>
      <th scope="col">Inicio da Cirugia</th>
      <th scope="col">Fim da Cirugia</th>
      <th scope="col">Saida prevista</th>
     
    </tr>
  </thead>
  <tbody>
    <%
    for(paciente i : ls){
  

	if (session.getAttribute("usuario") != null){
	 %>
	 <tr class="pointer" onclick="window.location.href = 'cadastroOperacao.jsp?id=<%= i.getId() %>'">
	    
	<% 
	}else{
		%>
		<tr>	
<% 
}
%>    
      <th ><%= i.getNome_pac() %></th>
      <% switch(i.getStatus_pac()) {
      	  case "1":%>
          <td style="background-color:rgb(250, 247, 69)" id="status">Pré Operatório </td>
    	   <%  break;
    	  case "2": %>
          <td style="background-color:rgb(6, 138, 179)" id="status">Transferido </td>
    	    <%break; 
    	  case "3":%>
    	  <td style="background-color:rgb(248, 64, 51)" id="status">Em Cirugia </td>
			<% break;
		  case "4":%>
    	  <td style="background-color: rgb(146, 248, 51)" id="status">Em Recuperação </td>
			<% break;
			} %>
      <td><%= i.getPrev_ini_pac() %></td>
      <td><%= i.getInicio_pac() %></td>
      <td><%= i.getFim_pac() %></td>
      <td><%= i.getSaida_pac() %></td>
    </tr>
 	<% }%>
  </tbody>
</table>
       	<% 
          }
         %>
</body>
</html>