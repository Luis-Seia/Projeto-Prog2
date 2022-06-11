package com.general.system;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.general.system.interfaces.IMystates;
import com.info.users.Paciente;
import com.info.users.Responsavel;
import com.management.users.Enfermeiro;

public class MyStates implements IMystates {
	Scanner scan = new Scanner(System.in);
	private ArrayList<Enfermeiro> enfermeiros;
	private ArrayList<Responsavel> responsaveis;

	{
		enfermeiros = new ArrayList<>();
		responsaveis = new ArrayList<>();
		this.menu();
	}

	public void menu() {
		try {
			System.out.println("****My States****");
			System.out.println("1. Enfermeiro \n 2. Utlizador\\Responsavel ");
			int opcao = scan.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Enfermeiro: \n 1. Fazer login \n 2. Cadastrar");
				int op = scan.nextInt();
				switch (op) {
				case 1:
					this.login_do_Enfermeiro();
					break;
				case 2:
					this.cadastrarEnfermeiro();
					break;
				default:
					System.out.println("OPcao invalida");
					break;
				}
			case 2:
				System.out.println(" Utlizador: \n 1.Fazer login \n 2. Cadastrar");
				int opS = scan.nextInt();
				switch (opS) {
				case 1:
					this.login_do_Responsavel();
					break;
				case 2:
					this.cadastrarResponsavel();
					break;
				default:
					System.out.println("OPcao invalida");
					break;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Ensira os dados corretamenaste");
		}
	}

	// login para o Enfermeiro
	public void login_do_Enfermeiro() {
		System.out.println("Username: ");
		String nome = scan.next();
		System.out.println("Password: ");
		String senha = scan.next();

		for (Enfermeiro enfermeiro : enfermeiros) {
			if (enfermeiro.efetuarLogin(nome, senha) == true) {
				Enfermeiro logado = enfermeiro;
				this.operacoesEnfermeiro(logado);
			} else {
				System.out.println("Verifique se o nome e a senha estao corretos");
			}

		}
	}

	// login para o utilizador
	public void login_do_Responsavel() {
		System.out.println("Nome: ");
		String nome = scan.next();
		System.out.println("Password: ");
		String senha = scan.next();

		for (Responsavel responsavel : responsaveis) {
			if (responsavel.efetuarLogin(nome, senha) == true) {
				Responsavel logado = responsavel;
				this.operacoesResponsavel(logado);
			} else {
				System.out.println("Verifique se o nome e a senha estao corretos");
			}

		}
	}

	// Esse metodo o enfermeiro fara as operacoes no sistema
	public void operacoesEnfermeiro(Enfermeiro logado) {
		try {
			logado = new Enfermeiro();
			int opcao;
			do {
				System.out.println("1. Registrar um novo paciente \n 2. Operar paciente exitente \n 3. sair");
				opcao = scan.nextInt();
				switch (opcao) {
				case 1:
					logado.prencherInfo();
					break;
				case 2:
					this.menuEnfermeiro();
					int ops = scan.nextInt();
					switch (ops) {
					case 1:
						Paciente paciente1 = logado.operaracaoPaciente();
						logado.prencherFicha(paciente1);
						break;

					case 2:
						Paciente paciente = logado.operaracaoPaciente();
						logado.atualzarEstado(paciente);
						break;
					case 3:
						Responsavel responsvel = this.selecionarResponsavel();
						logado.notificarResponsavel(responsvel);
						break;
					case 4:
						responsvel = this.selecionarResponsavel();
						logado.relatar(responsvel);
						break;
					default:
						System.out.println("Opcao invalida");
					}
				}
			} while (opcao != 3);
			menu();
		} catch (InputMismatchException e) {
			System.out.println("Erro: Insira os dados corretamente ");
		} catch (IllegalArgumentException e) {
			System.out.println("Nao esta associado a este paciente");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}

	// metodo para que o utilizador tenha acesso as informacoes do seu parente internado
	public void operacoesResponsavel(Responsavel responsavel) {
		System.out.println("Insira as credencias do seu parente para ter acesso aos dados");
		System.out.println("Nome: ");
		String nome = scan.next();
		System.out.println("Refrencia: ");
		String referencia = scan.next();
		for (Paciente pacient : Enfermeiro.pacientes) {
			if (pacient.efetuarLogin(nome, referencia) == true) {
				responsavel.operacoes(pacient);
			} else {
				System.out.println("Verifique se o nome e a referencia estao corretos");
			}
		}
	}

	// metodo para o cadastro do efermeiro
	public void cadastrarEnfermeiro() {
		Enfermeiro enfermeiro = new Enfermeiro();
		System.out.println("---------Cadastrar Enfermeiro------");
		enfermeiro.cadastrar();
		enfermeiros.add(enfermeiro);
		operacoesEnfermeiro(enfermeiro);
	}

	
	//  metodo para o cadastro do utilizador
	public void cadastrarResponsavel() {
		System.out.println("---------Cadastro do responsavel pelo paciente------");
		Responsavel responsavel = new Responsavel();
		responsavel.cadastrar();
		responsaveis.add(responsavel);
		operacoesResponsavel(responsavel);
	}

	public Responsavel selecionarResponsavel() {
		this.allResponavel();
		System.out.println("Selecione o utilizador ");
		int n = scan.nextInt();
		return this.responsaveis.get(n - 1);
	}

	// metodos para listar todos usuarios
	public void allResponavel() {
		int n = 1;
		for (Responsavel responsavel : responsaveis) {
			System.out.println(n + ": " + responsavel.toString());
		}
	}

	public void menuEnfermeiro() {
		System.out.println("1. Prencher\\Atualizar Ficha Medica \n 2. Atualizar Estado Clinico  \n 3. sair"
				+ "Notificar responsavel \n 4. Relatar \n 5. Sair");
	}

}
