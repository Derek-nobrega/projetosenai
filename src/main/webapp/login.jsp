<%@page import="model.login"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="dao.loginDao"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="crud.db.conexao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<script > 
		function mostrar(id){
			
			if(document.getElementById('oc').style.display == 'block'){
				document.getElementById('oc').style.display = 'none';
			}else {document.getElementById('oc').style.display = 'block'}
		}
		function mostrar2(id){
			
			
			if(document.getElementById(id).style.display == 'flex'){
				document.getElementById(id).style.display = 'none';
			}else {document.getElementById(id).style.display = 'flex'}
		}
		
	</script>
	<style>
			.form {
			  padding: 30px;
			  border: 1px solid #4CAF50;
			  border: 1px solid black;
			  margin-top: 30px;
			  margin-bottom: 5px;
			  margin-right: 300px;
			  margin-left: 300px;
			  background-color: lightblue;
			}
			h5{
			color: green;
			text-align: center;
			}
			h4{
			color: red;
			text-align: center;
			}
			.hidden{
			display:none;
			width:750px;
			margin-left: 300px;
			height:120px;"
			padding-left: 80px;
			}
			.ocu{
			displya:block ;
			}
			
			.trocasenha{
			margin-left:10px;
			display: none;
			}
	</style>	
</head>
<body>

	<form class="form" action="loginServlet2">
		<h2>Login</h2>
		</br>
		<%
		String erro = request.getParameter("erro");
		String ok 	= request.getParameter("ok");
		
		if (erro != null){
			if (erro.equals("USUARIO_NAO_EXISTE")){
			%>
				<h4>Usuario ou senha incorreto</h4>
			<%
			} else if(erro.equals("USUARIO_OU_SENHA_VAZIO")){
				
			%>
				<h4>Usuario ou Senha não informado</h4>
			<%
			}
				
		}
			
		if(ok != null){
			
			if(ok.equals("USUARIO_CRIADO")){
			%>	
				<h5>Usuario criado, favor logar!</h5>
			<%
			}else if(ok.equals("SENHA_TROCADA")){
				%>
				<h5>Senha trocada, favor logar!</h5>
				<%
			}
		}
		%>
		  <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">Email</label>
		    <input type="text" class="form-control" name="email" id="email" >
		  </div>
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Senha</label>
		    <input type="password" class="form-control" name="senha" id="senha">
		  </div>
		  <button  class="btn btn-primary " >Entrar</button>
		  <a class="btn btn-success" href="cadastroUsuario.jsp" role="button">+ Criar Usuario</a>
		 <input type="button" value="Verificar Lista"  onClick="mostrar('oc')" class="btn btn-secondary"/>
		  
	</form>

    	 <%
    	 	loginDao objDao = new loginDao();
		   	List<login> ls = objDao.listaLogin();
				 if(ls.size()> 0) {
				
       	 %>
<div id="oc" class="hidden" >
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Usuario</th>
      <th scope="col"> Ação</th>

     
    </tr>
  </thead>
  <tbody>
    <%
    for(login u : ls){
    %>
    <tr>
      <th ><%= u.getEmail_login()%></th>
      <td> <div class="btn-group" role="group" aria-label="Basic mixed styles example">
  <a class="btn btn-danger" href="loginServlet2?acao=apagar&id=<%=u.getId_login()%>">Apagar</a>
  <input type="button" value="Trocar Senha"  onClick="mostrar2('<%=u.getId_login() %>')" class="btn btn-warning"/>
  <input class='trocasenha' type=text/>
 	 <form  action="loginServlet2" >
 	 <div id="<%=u.getId_login() %>"   class="input-group mb-3" style=" display: none;">
  	 		
  	 		 <input type="hidden" name="id" value="<%= u.getId_login() %>" ></input>
  	   		 <input type="hidden" name="email" value="<%= u.getEmail_login() %>" ></input>
	 		 <input type="text" id="senhanova" name="senhanova"  class="form-control" placeholder="Nova Senha" style="margin-left: 10px;"/>
  	  		 <button type="submit"  class="btn btn-success"  id="bt" >Salvar</button>
 	 </div>	
 	 </form>
  	  

  
	</div>
	</td>

    </tr>
 	<% }%>
  </tbody>
</table>
<% } %>
</div>

</body>
</html>