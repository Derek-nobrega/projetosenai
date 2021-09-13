package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.login;
import model.paciente;


public class loginDao {

	public boolean adicionar(login objL) {
		
		try {
			Connection cont = crud.db.conexao.conectar();

			String sql ="INSERT INTO \"pacienteDb\".usuario"
					+ "(email, senha)"
					+ "VALUES('"+objL.getEmail_login()+"', '"+objL.getSenha_login()+"')";
			
			PreparedStatement pst = cont.prepareStatement(sql);
			pst.execute();
			pst.close();
			cont.close();
			return true;	
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
			
	
		public boolean logar(login objL) {
			
			try {
				Connection cont = crud.db.conexao.conectar();
				PreparedStatement pst2 = cont.prepareStatement("SELECT * FROM \"pacienteDb\".usuario WHERE email = ? and senha = ?");
				pst2.setString(1, objL.getEmail_login());
				pst2.setString(2, objL.getSenha_login());
				ResultSet rs2 = pst2.executeQuery();
				pst2.getResultSet();
				if( rs2.next() ) {
					return true;
					}
				pst2.close();
				cont.close();
				
				} catch (Exception e) {
					e.printStackTrace();
	
				}
			return false;
		}
		
		
		public List<login> listaLogin() {
			
			List<login> ls = new ArrayList<>();
			
			try {
				Connection cont = crud.db.conexao.conectar();
				PreparedStatement pst = cont.prepareStatement("select id, email, senha from \"pacienteDb\".usuario order by id ");
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()){ 
					
					login l = new login();
					
					l.setId_login(rs.getInt("id"));
					l.setEmail_login(rs.getString("email"));
					l.setSenha_login(rs.getString("senha"));
					
					ls.add(l);	
				}
				cont.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ls;
		}
		
		public boolean apagar(int id) {
			
			try {
				
				Connection cont = crud.db.conexao.conectar();
				
				String sql ="delete from  \"pacienteDb\".usuario where id = ?";
				
				
				PreparedStatement pst = cont.prepareStatement(sql);
				pst.setInt(1, id);
				pst.execute();
				pst.close();
				cont.close();
				return true;	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean alterar(login objL) {
			
			try {
				
				Connection cont = crud.db.conexao.conectar();
				
				String sql ="update  \"pacienteDb\".usuario  set"
						+ " senha = ?"
						+ " where "
						+ " id   = ?";
						
				
				PreparedStatement pst = cont.prepareStatement(sql);
				pst.setString(1, objL.getSenha_login());
				pst.setInt(2, objL.getId_login());
				
				pst.execute();
				pst.close();
				cont.close();
				return true;	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

	
}
