package model;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sun.jdi.Value;

import dao.loginDao;
import dao.pacienteDao;

@WebServlet ("/loginAddServlet")

public class loginAddServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException{
		
		login objL = new login();
		boolean validar = false;
		
		objL.setEmail_login	(req.getParameter("email"));
		objL.setSenha_login(req.getParameter("senha"));
		//objP.setId			(Integer.parseInt(req2.getParameter("id")));
		
		
		loginDao objDao = new loginDao();
		
		
		if(!objL.getEmail_login().isEmpty() && !objL.getSenha_login().isEmpty()) {

				validar = objDao.adicionar(objL);
			
				rep.sendRedirect("login.jsp?ok=USUARIO_CRIADO");

		
		}else {
		  rep.sendRedirect("login.jsp?erro=USUARIO_OU_SENHA_VAZIO");
	  
	}
		
	}

}
