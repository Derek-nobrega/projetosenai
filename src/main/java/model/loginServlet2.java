package model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.sun.jdi.Value;

import dao.loginDao;
import dao.pacienteDao;

@WebServlet ("/loginServlet2")

public class loginServlet2 extends HttpServlet {
	
	public void service(HttpServletRequest req1, HttpServletResponse rep1) throws ServletException, IOException{ 
		
		login objL = new login();
		boolean validar = false;
		String acao = req1.getParameter("acao");
		
		if (acao != null && acao.equals("apagar")) {
			
			objL.setId_login(Integer.parseInt(req1.getParameter("id")));	
		
		}else {
			if (req1.getParameter("id")!= null){
				objL.setId_login(Integer.parseInt(req1.getParameter("id")));
			}
		
			objL.setEmail_login	(req1.getParameter("email"));
			if (req1.getParameter("senha")!= null) {
				objL.setSenha_login(req1.getParameter("senha"));
			}else {
				objL.setSenha_login(req1.getParameter("senhanova"));
				objL.setId_login(Integer.parseInt(req1.getParameter("id")));
			}
		}
		
	
		
		loginDao objDao = new loginDao();
		
		
		

		if (objL.getId_login() > 0) {
			
			if(acao != null && acao.equals("apagar")){
				validar = objDao.apagar(objL.getId_login());
				if (validar) {
					rep1.sendRedirect("login.jsp");
				}
			}else{
			validar = objDao.alterar(objL);
			if (validar) {
				rep1.sendRedirect("login.jsp?ok=SENHA_TROCADA");
				
			}
			}
		}else {
		if(!objL.getEmail_login().isEmpty() && !objL.getSenha_login().isEmpty()) {

				validar = objDao.logar(objL);
			
			if (validar) {
				
				HttpSession session= req1.getSession();
				session.setAttribute("usuario", objL); 
				rep1.sendRedirect("cadastroOperacao.jsp");
			}else {
				rep1.sendRedirect("login.jsp?erro=USUARIO_NAO_EXISTE");
			}
		
	  }else {
		  rep1.sendRedirect("login.jsp?erro=USUARIO_OU_SENHA_VAZIO");
	  
	}	
	}
	}

}
