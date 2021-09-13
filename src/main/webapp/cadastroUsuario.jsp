<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Cadastro de Usuario</title>
	<style>
			form {
			  padding: 30px;
			  border: 1px solid #4CAF50;
			  border: 1px solid black;
			  margin-top: 30px;
			  margin-bottom: 5px;
			  margin-right: 300px;
			  margin-left: 300px;
			  background-color: lightblue;
			}
	</style>
</head>
<body>

	<form class="form" action="loginAddServlet">
		<h2> Cadastro de Usuario</h2>
		</br>
				<%
		String erro = request.getParameter("erro");
		String ok 	= request.getParameter("ok");
		
		if (erro != null){
			if(erro.equals("USUARIO_OU_SENHA_VAZIO")){
				
			%>
				<h4>Usuario ou Senha não informado</h4>
			<%
			}else if(ok.equals("USUARIO_CRIADO")){
			%>	
				<h5>Usuario criado, favor logar!</h4>
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
		  <button  class="btn btn-primary">Salvar</button>
		  <button  class="btn btn-warning " type="reset"  >Limpar</button>
		  <a class="btn btn-secondary" href="login2.jsp" role="button">Voltar</a>
	</form>

</body>
</html>