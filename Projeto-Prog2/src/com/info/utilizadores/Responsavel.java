package com.info.utilizadores;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

// class do responsavell pelo paciente
public class Responsavel extends Pessoa {
	
	
	private ArrayList<String> notificacoes = new ArrayList<String>(); // Arraylist que recebe as notificacoes do hospital
	Scanner scan = new Scanner(System.in);
	
	public ArrayList<String> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(String mensagem) {
		this.notificacoes.add(mensagem);
	}
	
	// Medoto para cadastrar o usuario responsavel pelo pacientee
	public void cadastrar() {
		System.out.println("---------Cadastro do responsavel pelo paciente------");
		System.out.print("nome: ");
		String nome = scan.nextLine();
		this.setNome(nome);
		System.out.print("idade: ");
		int idade = scan.nextInt();
		this.setIdade(idade);
		System.out.print("Genero ");
		char genero = scan.next().charAt(0);
		this.setGenero(genero);
		System.out.print("Numero BI: ");
		String bi = scan.next();
		this.setNumeroBI(bi);
		System.out.print("Endereco: ");
		String endereco = scan.next();
		this.setEndereco(endereco);
		System.out.print("Contacto: ");
		String contacto = scan.next();
		this.setContacto(contacto);
		System.out.print("E-mail: ");
		String email = scan.next();
		this.setEmail(email);
		System.out.println("----------------Cadastrado com sucesoo-----------------------\n Confira os seus dados");
		this.info();
	}
	
	// Metodo para acedar as informacoes do paciente associado
	
	public void operacoes(Paciente paciente) {
		System.out.println(" 1. Ficha Medica \n 2. Estado clinico \n 3. Notificacoes \n 4. relatorio");
		int opcao = scan.nextInt();
		switch (opcao) {
		case 1:
			System.out.println("Ficha Medica");
			paciente.info();
			System.out.println("Seguro: "+paciente.getCredencial()+"\n Hipertensao: "+paciente.isHipertensao()
			+"\n Diabete: "+paciente.isDiabete()+"\nPeso: "+paciente.getPeso()+"\n");
			if (paciente.isDoencaCronica()==true) {
				System.out.println("Doenca cronica"+paciente.isDoencaCronica()+"   Tipo de doenca: " +paciente.getTipoCronico());
			}else {
				System.out.println(paciente.isDoencaCronica());
			}
			if (paciente.isSeguroMedico()== true) {
				System.out.println("Seguro Medico: "+paciente.isSeguroMedico()+"     Seguradora: "+paciente.getSeguradora());
			}else {
				System.out.println("Seguro Medico: "+paciente.isSeguroMedico());
			} 
			System.out.println("Outras doenas: "+paciente.getOutrasDoencas());break;
		
		case 2:
			System.out.println("Estado Clinico");
			System.out.println(paciente.isInfectado());
			System.out.println(paciente.getFaseclinica());break;
	
		case 3:
			System.out.println("Notificacoes");
			System.out.println(this.getNotificacoes());
		
		case 4:
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			System.out.println("Relatorio \n \"yyyy/MM/dd HH:mm:ss-> "+ dtf.format(LocalDateTime.now())+ "\n"+paciente.getNome()+ "Teve como resultado da avaliacao: \n "+paciente.getInfomation());break;
			
		}
		
		
			
		
		
		
	}

	@Override
	public void info() {
		System.out.println("Nome: "+this.getNome()
				+ "\n Bilhete de identificacao NR: "+this.getNumeroBI()+"\n Genero :"+this.getGenero()+"\n Endereco: "+this.getEndereco()+"\n contacto: "+this.getContacto());
	}
	
}
