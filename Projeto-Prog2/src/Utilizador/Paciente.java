package Utilizador;

public class Paciente extends Pessoa{
 //Atributos
	private boolean infectado;
	private String referencia;
	private String localizacacao;
	
	
	
	// getters e setters
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
}
