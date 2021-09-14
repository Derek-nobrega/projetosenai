<%@page import="model.login"%>
<%@page import="model.paciente" %>
<%@page import="dao.pacienteDao" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
login usuariologado = null;

if (session.getAttribute("usuario") != null){
	 usuariologado = (login) session.getAttribute("usuario");	
}else{
	response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>Cadastro Operação</title>
</head>

<%
paciente p = new paciente();
try{
	int id = Integer.parseInt(request.getParameter("id")) ;
	pacienteDao dao = new pacienteDao();
	p = dao.getPaciente(id);
}catch(Exception e){
	
}%>

<body>
<ul class="nav">

   <h1> Gerenciar Painel dos Pacientes do Centro Cirúgico <a class="btn btn-danger" style="margin-left: 150px" href="sair.jsp">sair</a> </h1> 
</ul>
	<form action="operacaoServlet" style="padding: 12px 20px" >
	<input type="hidden" name="id" value="<%= p.getId() %>" ></input>
	  <div class="row">
		  <div class="col-md-6">
		  	<label class="form-label">Nome do Paciente: </label>
		    <input type="text" class="form-control" placeholder="Nome do Paciente" id="nome_pac" value="<%= p.getNome_pac()%>" name="nome">
		  </div>
		  <div class="col-md-3">
		  	<label class="form-label">Status: </label>
		      <select class="form-select" id="status_pac" name="status">
		      <option value="1" name="status">Pre-Operatorio</option>
		      <option value="2" name="status">Transferido</option>
		      <option value="3" name="status">Em Cirugia</option>
		      <option value="4" name="status">Em Recuperação</option>
		    </select>
		  </div>
		    <div class="col-md-3">
		  	<label class="form-label">Local: </label>
		    <input type="text" class="form-control" placeholder="Sala/Quarto" value="<%= p.getLocal_pac() %>" id="local_pac" name="local">
		  </div>
		</div>
		  <div class="row" style="margin-top: 15px">
		  <div class="col-md-3">
		  	<label class="form-label">Inicio Previsto: </label>
		    <input type="time" class="form-control"  id="prev_ini_pac" value="<%= p.getPrev_ini_pac() %>" name="ini_prev">
		  </div>
		  <div class="col-md-3">
		  	<label class="form-label">Inicio Cirugia: </label>
		    <input type="time" class="form-control"  id="inicio_pac" value="<%= p.getInicio_pac() %>" name="ini_real">
		  </div>
		    <div class="col-md-3">
		  	<label class="form-label">Fim da Cirugia: </label>
		    <input type="time" class="form-control"  id="fim_pac" value="<%= p.getFim_pac() %>" name="fim">
		  </div>
		    <div class="col-md-3">
		  	<label class="form-label">Saida Prevista: </label>
		    <input type="time" class="form-control"  id="saida_pac" value="<%= p.getSaida_pac() %>" name="saida">
		  </div>
		</div>
		
		<p style="margin-top: 15px">
		 <%
			if(p.getId() > 0){
		 %>
	  		<a  class="btn btn-secondary" href="cadastroOperacao.jsp"> + Nova Operação</a>
	  		<button type="submit" class="btn btn-primary">Gravar</button>
	  		<a type="submit"  href="operacaoServlet?acao=apagar&id=<%= p.getId() %>" class="btn btn-danger">Apagar</a>
		<% 
		 }else{
			 %>
				<button type="submit" class="btn btn-primary">Gravar</button>
			 	<button type="reset"  class="btn btn-warning"> Limpar</button>
		<% }
		
		%>  
		</p>
	</form>
	<script type="text/javascript">
	
	document.getElementById("status_pac").value = "<%= p.getStatus_pac()%>" ;
	</script>

	<%@include file="index.jsp"%>
</body>
</html>