package com.classes.abstratas;

import java.util.Scanner;

public abstract class Pessoa {
	
	// ATRIBUTOS
	private String nome;
	private int idade;
	private char genero;
	private String contacto;
	private String email;
	private String endereco;
	private String NumeroBI;
	private String dataNascimento;
	
	Scanner scan = new Scanner(System.in);
	
	// GEETRS E SEETRS
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumeroBI() {
		return NumeroBI;
	}
	public void setNumeroBI(String numeroBI) {
		NumeroBI = numeroBI;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	//Metodos
	public void info(){
		System.out.println("Nome: "+this.getNome()+"\n Data de nascimento: "+this.getDataNascimento()+""
				+ "\n Bilhete de identificacao NR: "+this.getNumeroBI()+"\n Genero :"+this.getGenero()+"\n Endereco: "+this.getEndereco()+"\n contacto: "+this.getContacto()
				+"\n e-mail: "+this.getEmail()+"\n");
	}
	
	
	
}
