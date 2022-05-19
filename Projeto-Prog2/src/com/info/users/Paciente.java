package com.info.users;

import com.enums.state.FaseClinica;
import com.info.users.abstracts.classes.Pessoa;

public class Paciente extends Pessoa{
	/*
	 * A classe Paciente herdara atributos e mmetodos da classe pessoa e da classe FichaMedica
	 */
	
 //Atributos
	private boolean infectado;
	private FaseClinica faseclinica; // Tipo enumerado
	private String referencia;
	private String localizacacao;
	private String infomation;
	private Responsavel responsavel;
	public FichaMedica ficha;
	{
		ficha = new FichaMedica();
	}
	

	public FichaMedica getFicha() {
		return ficha;
	}

	public void setFicha(FichaMedica ficha) {
		this.ficha = ficha;
	}

	public Paciente() {
		this.infectado = true;
		
	}

	// getters e setters
	public FaseClinica getFaseclinica() {
		return faseclinica;
	}

	public void setFaseclinica(FaseClinica faseclinica) {
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
	
	
	 public Boolean efetuarLoga(String nome, String referencia){
	        if(this.getNome().equals(nome) && this.getReferencia().equals(referencia)){
	            return true;
	        }else{
	            return false;
	        }
	    }
	 
	public void info() {
		super.info();
		System.out.println("Infectado: "+this.isInfectado()+ "\nReferencia: "+this.getReferencia()+"\n");
	}
}
