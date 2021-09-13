package model;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.pacienteDao;

@WebServlet ("/operacaoServlet")

public class operacaoServlet extends HttpServlet {
	
	public void service(HttpServletRequest req2, HttpServletResponse rep2) throws ServletException, IOException {
		

		boolean validar = false;
		paciente objP = new paciente();
		String acao = req2.getParameter("acao");
		
		if (acao != null && acao.equals("apagar")) {
			objP.setId(Integer.parseInt(req2.getParameter("id")));
		}else {
			
			objP.setNome_pac	(req2.getParameter("nome"));
			objP.setStatus_pac	(req2.getParameter("status"));
			objP.setLocal_pac	(req2.getParameter("local"));
			objP.setPrev_ini_pac(req2.getParameter("ini_prev"));
			objP.setInicio_pac	(req2.getParameter("ini_real"));
			objP.setSaida_pac	(req2.getParameter("saida"));
			objP.setFim_pac		(req2.getParameter("fim"));
			objP.setId			(Integer.parseInt(req2.getParameter("id")));
			
		}
		
		pacienteDao objDao = new pacienteDao();
		
		if (objP.getId() > 0) {
			if(acao != null && acao.equals("apagar")){
				validar = objDao.apagar(objP.getId());
			}else {
				validar = objDao.alterar(objP);
				
			}
			
		}else {
			validar = objDao.adicionar(objP);
		}
		
		if (validar) {
			rep2.sendRedirect("cadastroOperacao.jsp");
		}
		
		
	}

}
