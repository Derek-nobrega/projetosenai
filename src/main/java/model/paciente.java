package model;

import java.sql.Date;

public class paciente {

	private int id ;
	private String nome_pac 	="";
	private String status_pac 	="" ;
	private String local_pac 	="";
	private String prev_ini_pac ="";
	private String inicio_pac 	="";
	private String fim_pac 		="";
	private String saida_pac	="";
	private Date   dia_ope ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome_pac() {
		return nome_pac;
	}
	public void setNome_pac(String nome_pac) {
		this.nome_pac = nome_pac;
	}
	public String getStatus_pac() {
		return status_pac;
	}
	public void setStatus_pac(String status_pac) {
		this.status_pac = status_pac;
	}
	public String getLocal_pac() {
		return local_pac;
	}
	public void setLocal_pac(String local_pac) {
		this.local_pac = local_pac;
	}
	public String getPrev_ini_pac() {
		return prev_ini_pac;
	}
	public void setPrev_ini_pac(String prev_ini_pac) {
		this.prev_ini_pac = prev_ini_pac;
	}
	public String getInicio_pac() {
		return inicio_pac;
	}
	public void setInicio_pac(String inicio_pac) {
		this.inicio_pac = inicio_pac;
	}
	public String getFim_pac() {
		return fim_pac;
	}
	public void setFim_pac(String fim_pac) {
		this.fim_pac = fim_pac;
	}
	public String getSaida_pac() {
		return saida_pac;
	}
	public void setSaida_pac(String saida_pac) {
		this.saida_pac = saida_pac;
	}
	public Date getDia_ope() {
		return dia_ope;
	}
	public void setDia_ope(Date dia_ope) {
		this.dia_ope = dia_ope;
	}

	
	
}
