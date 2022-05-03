package com.info.utilizadores;

public class Paciente extends FichaMedica{
 //Atributos
	private boolean infectado;
	private String faseclinica;
	private String referencia;
	private String localizacacao;
	private String infomation;
	private Responsavel responsavel;
	

	// getters e setters
	public String getFaseclinica() {
		return faseclinica;
	}

	public void setFaseclinica(String faseclinica) {
		this.faseclinica = faseclinica;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	
	public String getInfomation() {
		return infomation;
	}

	public void setInfomation(String infomation) {
		this.infomation = infomation;
	}

	public boolean isInfectado() {
		return infectado;
	}

	public void setInfectado(boolean infectado) {
		this.infectado = infectado;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getLocalizacacao() {
		return localizacacao;
	}

	public void setLocalizacacao(String localizacacao) {
		this.localizacacao = localizacacao;
	}
	
	
	// Metodos
	public void estadoClinico() {
		
	}
	
	public void fichaMedica() {
		
	}
	 public void recuperado() {
		 
	 }
	 
	public void info() {
		super.info();
		System.out.println("Infectado: "+this.isInfectado()+ "\nReferencia: "+this.getReferencia()+"\n");
	}
}
