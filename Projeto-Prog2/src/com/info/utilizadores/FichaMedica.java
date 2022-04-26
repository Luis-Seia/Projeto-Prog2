package com.info.utilizadores;

import java.util.Scanner;

public abstract class FichaMedica extends Pessoa {
	Scanner scan = new Scanner(System.in);
	// Atriutos
	private boolean seguroMedico;
	private String seguradora;
	private String credencial;
	private String tipoSanguineo;
	private float peso;
	private boolean diabete;
	private boolean hipertensao;
	private boolean doencaCronica;
	private String tipoCronico;
	private String outrasDoencas;
	
	// Getters & Setters
	public boolean isSeguroMedico() {
		return seguroMedico;
	}
	public void setSeguroMedico(boolean seguroMedico) {
		seguroMedico = scan.nextBoolean();
		this.seguroMedico = seguroMedico;
	}
	public String getSeguradora() {
		return seguradora;
	}
	public void setSeguradora(String seguradora) {
		seguradora = scan.nextLine();
		this.seguradora = seguradora;
	}
	public String getCredencial() {
		return credencial;
	}
	public void setCredencial(String credencial) {
		credencial = scan.nextLine();
		this.credencial = credencial;
	}
	public String getTipoSanguineo() {
		return tipoSanguineo;
	}
	public void setTipoSanguineo(String tipoSanguineo) {
		tipoSanguineo = scan.nextLine();
		this.tipoSanguineo = tipoSanguineo;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		peso = scan.nextFloat();
		this.peso = peso;
	}
	public boolean isDiabete() {
		return diabete;
	}
	public void setDiabete(boolean diabete) {
		diabete = scan.nextBoolean();
		this.diabete = diabete;
	}
	public boolean isHipertensao() {
		return hipertensao;
	}
	public void setHipertensao(boolean hipertensao) {
		hipertensao = scan.nextBoolean();
		this.hipertensao = hipertensao;
	}
	public boolean isDoencaCronica() {
		return doencaCronica;
	}
	public void setDoencaCronica(boolean doencaCronica) {
		doencaCronica = scan.nextBoolean();
		this.doencaCronica = doencaCronica;
	}
	public String getTipoCronico() {
		return tipoCronico;
	}
	public void setTipoCronico(String tipoCronico) {
		tipoCronico = scan.nextLine();
		this.tipoCronico = tipoCronico;
	}
	public String getOutrasDoencas() {
		return outrasDoencas;
	}
	public void setOutrasDoencas(String outrasDoencas) {
		outrasDoencas = scan.nextLine();
		this.outrasDoencas = outrasDoencas;
	}
	
	
}
