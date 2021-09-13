package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.paciente;



public class pacienteDao {
	
	public boolean adicionar(paciente objP) {
		
		LocalDate myObj = LocalDate.now(); 
		
		try {
			Connection cont = crud.db.conexao.conectar();
			
			String sql ="INSERT INTO \"pacienteDb\".operacao"
					+ "(nome, status, local, inicio_prev, inicio_real, fim_real, fim_prev, dia_ope)"
					+ "VALUES('"+objP.getNome_pac()+"', '"+objP.getStatus_pac()+"', '"+objP.getLocal_pac()+"', '"+objP.getPrev_ini_pac()+"', '"+objP.getInicio_pac()+"', '"+objP.getFim_pac()+"', '"+objP.getSaida_pac()+"', '"+myObj+"' )";
			
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
	
	public List<paciente> listaPaciente() {
		
		List<paciente> ls = new ArrayList<>();
		
		try {
			
			Connection cont = crud.db.conexao.conectar();
			 PreparedStatement pst = cont.prepareStatement("select nome, status, local, inicio_prev, inicio_real, fim_real, fim_prev, dia_ope, id from \"pacienteDb\".operacao order by id ");
			 ResultSet rs = pst.executeQuery();
			 
			  while(rs.next()){ 
				  
				  paciente p = new paciente();
				  
				  p.setNome_pac(rs.getString("nome"));
				  p.setStatus_pac(rs.getString("status"));
				  p.setInicio_pac(rs.getString("inicio_real"));
				  p.setPrev_ini_pac(rs.getString("inicio_prev"));
				  p.setFim_pac(rs.getString("fim_real"));
				  p.setSaida_pac(rs.getString("fim_prev"));
				  p.setDia_ope(rs.getDate("dia_ope"));
				  p.setLocal_pac(rs.getString("local"));
				  p.setId(rs.getInt("id"));
				//  p.setCpf(rs.getString("cpf"));
				  
				  
				
				  ls.add(p);
			  }
			  cont.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;	
	}
	
	public paciente getPaciente(int id) {
		
		paciente p = new  paciente();
		
		try {
			
			Connection cont = crud.db.conexao.conectar();
			 PreparedStatement pst = cont.prepareStatement("select * from \"pacienteDb\".operacao where id= ? ");
			 pst.setInt(1, id);
			 ResultSet rs = pst.executeQuery();
			 
			 while(rs.next()){ 
				  p.setId(rs.getInt("id"));
				  p.setNome_pac(rs.getString("nome"));
				  p.setStatus_pac(rs.getString("status"));
				  p.setInicio_pac(rs.getString("inicio_real"));
				  p.setPrev_ini_pac(rs.getString("inicio_prev"));
				  p.setFim_pac(rs.getString("fim_real"));
				  p.setSaida_pac(rs.getString("fim_prev"));
				  p.setDia_ope(rs.getDate("dia_ope"));
				  p.setLocal_pac(rs.getString("local"));
			 }
			  cont.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public boolean alterar(paciente objP) {
		
		try {
			
			Connection cont = crud.db.conexao.conectar();
			String sql ="update  \"pacienteDb\".operacao set "
					+ "nome     = ?,"
					+ " status   = ?,"
					+ " local = ?,"
					+ " inicio_prev     = ?::time,"
					+ " inicio_real    = ?::time,"
					+ " fim_real     = ?::time,"
					+ " fim_prev    = ?::time"
					+ " where"
					+ " id      = ?";
			
			
			PreparedStatement pst = cont.prepareStatement(sql);
			pst.setString(1, objP.getNome_pac() );
			pst.setString(2, objP.getStatus_pac() );
			pst.setString(3, objP.getLocal_pac() );
			
			//pst.setTime(4, objP.getPrev_ini_pac());
			pst.setString(4, objP.getPrev_ini_pac());
			pst.setString(5, objP.getInicio_pac());
			pst.setString(6, objP.getFim_pac());
			pst.setString(7, objP.getSaida_pac());
			
			pst.setInt	 (8, objP.getId() );
			
			pst.execute();
			pst.close();
			cont.close();
			return true;	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean apagar(int id) {

		try {
			Connection cont = crud.db.conexao.conectar();
			
			String sql ="delete from  \"pacienteDb\".operacao where id = ?";
			
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
	
}
