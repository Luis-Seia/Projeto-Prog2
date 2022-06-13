package com.info.users.abstracts.classes;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Pessoa {

	// ATRIBUTOS
	private String nome;
	private String senha;
	private int idade;
	private char genero;
	private String contacto;
	private String email;
	private String endereco;
	private String NumeroBI;
	protected boolean cadastrado;

	Scanner scan = new Scanner(System.in);

	// GEETRS E SEETRS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	// Medoto para cadastrar o usuario responsavel pelo pacientee

	public void cadastrar() {
		try {

			System.out.print("nome: ");
			String nome = scan.nextLine();
			System.out.print("Insira uma Senha: ");
			String senha = scan.nextLine();
			this.setSenha(nome);
			System.out.print("idade: ");
			int idade = scan.nextInt();
			this.setIdade(idade);
			System.out.print("Genero ");
			char genero = scan.next().charAt(0);
			this.setGenero(genero);
			scan.nextLine();
			System.out.print("Numero BI: ");
			String bi = scan.nextLine();
			this.setNumeroBI(bi);
			System.out.print("Endereco: ");
			String endereco = scan.nextLine();
			this.setEndereco(endereco);
			System.out.print("Contacto: ");
			String contacto = scan.nextLine();
			this.setContacto(contacto);
			System.out.print("E-mail: ");
			String email = scan.nextLine();
			this.setEmail(email);
			System.out.println("----------------Cadastrado com sucesoo--------------------\n Confira os seus dados");
			this.info();
			cadastrado = true;
		} catch (InputMismatchException e) {
			System.out.println("Erro: Insira os dados corretamente");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error" + e.getStackTrace());
		}
	}

	// Metodos
	public Boolean efetuarLogin(String nome, String senha) {
		if (this.nome.equals(nome) && this.senha.equals(senha)) {
			return true;
		} else {
			return false;
		}
	}

	public void info() {
		System.out.println("Nome: " + this.getNome() + "\n Data de nascimento: " + "\n Bilhete de identificacao NR: "
				+ this.getNumeroBI() + "\n Genero :" + this.getGenero() + "\n Endereco: " + this.getEndereco()
				+ "\n contacto: " + this.getContacto() + "\n e-mail: " + this.getEmail() + "\n");
	}

	@Override
	public String toString() {
		return nome + "|" + idade + "|" + genero + "|" + contacto + "|" + email + "|" + endereco + "|"
				+ NumeroBI + "|" + cadastrado + "]";
	}

}
