package com.admistracao;

import java.util.Scanner;

import com.info.utilizadores.Paciente;
import com.info.utilizadores.Responsavel;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.IOException;



public class Enfermeiro  {
	Scanner scan = new Scanner(System.in);
	private String nome;
	private String credencial;
	private String localizacao;
	private String turno;
	 
	
	
	public Enfermeiro(String nome, String credencial, String localizacao, String turno) {
		super();
		this.nome = nome;
		this.credencial = credencial;
		this.localizacao = localizacao;
		this.turno = turno;
	}

	

	public void prencherFicha(Paciente paciente) {
		System.out.println("|Admistracao do Sistema|");
		System.out.println("Prenchimento da ficha medica do paciente: \n ");
		System.out.println("Seguro? \n 1.SIM \n 2.Nao \n:");
		int op = scan.nextInt();
		switch (op) {
		case 1: 
			paciente.setSeguroMedico(true);
			System.out.print("Seguradora: ");
			String seguradora = scan.next();
			paciente.setSeguradora((seguradora));
			
			
			break;
		case 2: 
			paciente.setSeguroMedico(false);;
			default:
				System.out.println("Opcao invalida");break;
		} 
		System.out.print("Credencial: ");
		String credencial = scan.next();
		paciente.setCredencial(credencial);
		
		// verificar se o paciente tem Hipertensao
		System.out.println("Hipertensao? \n 1.SIM \n 2.Nao");
		int op2 = scan.nextInt();
		switch (op2) {
		case 1: 
			paciente.setHipertensao(true);
			
			break;
		case 2: 
			paciente.setHipertensao(false);
			default:
				System.out.println("Opcao invalida");break;
		}
		System.out.print("TipoSanguineo: ");
		String tipoSanguineo = scan.next();
		paciente.setTipoSanguineo(tipoSanguineo);
		
		// verificar se o paciente tem diabete
		System.out.println("Diabete? \n 1.SIM \n 2.Nao");
		int op3 = scan.nextInt();
		switch (op3) {
		case 1: 
			paciente.setDiabete(true);
			
			break;
		case 2: 
			paciente.setDiabete(false);
			default:
				System.out.println("Opcao invalida");break;
		}
		System.out.print("Peso: ");
		float peso = scan.nextFloat();
		paciente.setPeso(peso);
		System.out.print(" ");
		System.out.println("Doenca cronica:? \n 1.SIM \n 2.Nao");
		int op4 = scan.nextInt();
		switch (op4) {
		case 1: 
			paciente.setDoencaCronica(true);
			System.out.print("Tipo da doenca: ");
			String tipoCronico = scan.next();
			paciente.setTipoCronico((tipoCronico));
			break;
		case 2: 
			paciente.setDoencaCronica(false);
			default:
				System.out.println("Opcao invalida");break;
		}
		System.out.print("Outras doencas: ");
		String outrasDoencas = scan.next();
		paciente.setOutrasDoencas((outrasDoencas));
		
	}
	
	public void prencherInfo(Paciente paciente, Responsavel responsavel) {
		System.out.println("|Admistracao do Sistema|");
		System.out.println("------Registrar  Paciente:--------- ");
		System.out.print("nome: ");
		String nome = scan.next();
		paciente.setNome(nome);
		System.out.print("idade: ");
		int idade = scan.nextInt();
		paciente.setIdade(idade);
		System.out.print("Genero ");
		char genero = scan.next().charAt(0);
		paciente.setGenero(genero);
		System.out.print("Numero BI ");
		String bi = scan.next();
		paciente.setNumeroBI(bi);
		System.out.print("Endereco: ");
		String endereco = scan.next();
		paciente.setEndereco(endereco);
		System.out.print("Contacto: ");
		String contacto = scan.next();
		paciente.setContacto(contacto);
		System.out.println();
		System.out.println("------Familiar responsavel:--------- ");
		System.out.println(responsavel.getNome());
		System.out.println(responsavel.getContacto());
		System.out.println(responsavel.getEmail());
		System.out.println("------------------------------------- ");
	}
	
	public void relatorio(Paciente paciente) {
		System.out.println("|Admistracao do Sistema|");
		System.out.println("-----------Emitir relatorio---------");
		String relatar = scan.nextLine();
		paciente.setInfomation(relatar);
		
	}
	public void atualzarEstado(Paciente paciente) {
		System.out.println("|Admistracao do Sistema|");
		System.out.println("-----------Atualizar Estado Clinico---------");
		System.out.println("Recuperado? \n 1.SIM \n 2.Nao");
		int op = scan.nextInt();
		switch (op) {
		case 1: 
			paciente.setInfectado(false);
			paciente.setFaseclinica("Recuperado");
			
			break;
		case 2: 
			paciente.setInfectado(true);
			System.out.println("Fase: ");
			String fase = scan.next();
			paciente.setFaseclinica(fase);
			default:
				System.out.println("Opcao invalida");break;
		} 
		
	}
	
	public void notificarResponsavel(Responsavel responsavel) {
		System.out.println("|Admistracao do Sistema|");
		System.out.println("------Notificar utilizador responsavel-----");
		System.out.print("Escreva: ");
		String mensagem = null; 
		while(!mensagem.equals(" ")) {
		mensagem=scan.nextLine();
		 responsavel.setNotificacoes(mensagem);
		}
		
	}
	
	/*
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCredencial() {
		return credencial;
	}

	public void setCredencial(String credencial) {
		this.credencial = credencial;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}*/
}
