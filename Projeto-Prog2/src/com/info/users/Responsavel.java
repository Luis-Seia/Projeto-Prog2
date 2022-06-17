package com.info.users;
/*
 * A classe Responsavel corresponde ao utilizador responsavel pelo paciente que ira se cadastrar
  no sistema e efetuar operacoes como:
  * Ver ficha medica do paciente;
  * Ver estado atual do paciente
  * ver relatorio
  * ver Notificacoes do hospital
  * 
 */



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.info.users.abstracts.classes.Pessoa;

public class Responsavel extends Pessoa {

	// Atributos
	private ArrayList<String> notificacoes = new ArrayList<String>(); // Arraylist que recebe as notificacoes do
																		// hospital
	Scanner scan = new Scanner(System.in);

	public Responsavel(String nome, String senha, int idade, String genero, String contacto, String email,
			String endereco, String numbi) {
		this.nome = nome;
		this.senha = senha;
		this.idade = idade;
		this.genero = genero.charAt(0);
		this.contacto = contacto;
		this.email = email;
		this.endereco = endereco;
		this.NumeroBI = numbi;
		
	}
	public Responsavel() {
		super();
	}

	// Getters e Settrs
	public ArrayList<String> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(String mensagem) { // modifiquei o paramentro
		this.notificacoes.add(mensagem);
	}

	

	// Metodo para acedar as informacoes do paciente associad
	public void operacoes(Paciente paciente) {
		if (cadastrado != true) {
			System.out.println("Erro: Nao esta cadastrado no SISTEMA");
			scan.close();
		} else {
			try {
				int opcao;
				do {
					System.out.println(
							" 1. Ficha Medica \n 2. Estado clinico \n 3. Notificacoes \n 4. relatorio \n 5. sair");
					opcao = scan.nextInt();
					switch (opcao) {
					case 1:
						System.out.println("Ficha Medica");
						System.out.println("-----Informcoes pessoais----");
						paciente.info();
						System.out.println("--------------------------------");
						System.out.println("Seguro: " + paciente.ficha.isSeguroMedico() + "\n Hipertensao: "
								+ paciente.ficha.isHipertensao() + "\n Diabete: " + paciente.ficha.isDiabete()
								+ "\nPeso: " + paciente.ficha.getPeso() + "\n");
						if (paciente.ficha.isDoencaCronica() == true) {
							System.out.println("Doenca cronica" + paciente.ficha.isDoencaCronica()
									+ "   Tipo de doenca: " + paciente.ficha.getTipoCronico());
						} else {
							System.out.println(paciente.ficha.isDoencaCronica());
						}
						if (paciente.ficha.isSeguroMedico() == true) {
							System.out.println("Seguro Medico: " + paciente.ficha.isSeguroMedico() + "     Seguradora: "
									+ paciente.ficha.getSeguradora());
						} else {
							System.out.println("Seguro Medico: " + paciente.ficha.isSeguroMedico());
						}
						System.out.println("Outras doenas: " + paciente.ficha.getOutrasDoencas());

					case 2:
						System.out.println("Estado Clinico");
						System.out.println("Infectado: " + paciente.isInfectado());
						System.out.println("Fase: " + paciente.getFaseclinica());
						break;

					case 3:
						System.out.println("Notificacoes");
						System.out.println(this.getNotificacoes());
						break;

					case 4:
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
						System.out.println("Relatorio \n " + dtf.format(LocalDateTime.now()) + "\n" + paciente.getNome()
								+ "\nTeve como resultado da avaliacao: \n ");

						// ler o arquivo relatorio criado na classe enfermiro
						String path = "D:\\" + this.getNome() + "" + this.getEmail() + ".txt";

						try {
							File relatorio = new File(path);
							BufferedReader br = new BufferedReader(new FileReader(relatorio));
							int n = 0;
							while ((n = br.read()) != -1) {
								System.out.println((char) n);
							}
						} catch (IOException e) {
							System.out.println("Nao ha nenhum relatorio");
							;
						}
						break;

					default:
						System.out.println("Opcao invalida \n");
						break;
					}
				} while (opcao != 5);

			} catch (InputMismatchException e) {
				System.out.println("Erro: Insira os dados corretamente ");
			} catch (IllegalArgumentException e) {
				System.out.println("Nao esta associado a este paciente");
			} catch (RuntimeException e) {
				System.out.println("Unexpected error");
			}
		}

	}

	
	
	@Override
	public void info() {
		super.info();
	}

}
