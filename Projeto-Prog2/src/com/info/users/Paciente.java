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
	
	
	 @Override
	public String toString() {
		return  nome + "|" + idade + "|" + genero + "|" + contacto + "|" + email + "|" + endereco + "|"
				+ NumeroBI + "|" + cadastrado + "|"+faseclinica + "|" + referencia
				+ "|" + localizacacao + "|" + ficha + "]";
	}

	public Boolean concederAcesso(String nome, String referencia){
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
