package com.management.users;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.enums.state.FaseClinica;
import com.info.users.Paciente;
import com.info.users.Responsavel;
import com.info.users.abstracts.classes.Pessoa;

public class Enfermeiro extends Pessoa {

	public static ArrayList<Paciente> pacientes = new ArrayList<>();
	private static SimpleDateFormat date3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Scanner scan = new Scanner(System.in);

	@Override
	public void cadastrar() {
		super.cadastrar();
	}

// Metodo para prencher ficha medica do paciente
	public void prencherFicha(Paciente paciente) {
		try {
			System.out.println("|Admistracao do Sistema|");
			System.out.println("Prenchimento da ficha medica do paciente: \n ");
			System.out.println("Seguro? \n 1.SIM \n 2.Nao \n:");
			int op = scan.nextInt();
			switch (op) {
			case 1:
				paciente.ficha.setSeguroMedico(true);
				System.out.print("Seguradora: ");
				String seguradora = scan.next();
				paciente.ficha.setSeguradora(seguradora);
				break;
			case 2:
				paciente.ficha.setSeguroMedico(false);
				;
			default:
				System.out.println("Opcao invalida");
				break;
			}
			System.out.print("Credencial: ");
			String credencial = scan.next();
			paciente.ficha.setCredencial(credencial);

			// verificar se o paciente tem Hipertensao
			System.out.println("Hipertensao? \n 1.SIM \n 2.Nao");
			int op2 = scan.nextInt();
			switch (op2) {
			case 1:
				paciente.ficha.setHipertensao(true);

				break;
			case 2:
				paciente.ficha.setHipertensao(false);
			default:
				System.out.println("Opcao invalida");
				break;
			}
			System.out.print("TipoSanguineo: ");
			String tipoSanguineo = scan.next();
			paciente.ficha.setTipoSanguineo(tipoSanguineo);

			// verificar se o paciente tem diabete
			System.out.println("Diabete? \n 1.SIM \n 2.Nao");
			int op3 = scan.nextInt();
			switch (op3) {
			case 1:
				paciente.ficha.setDiabete(true);

				break;
			case 2:
				paciente.ficha.setDiabete(false);
			default:
				System.out.println("Opcao invalida");
				break;
			}
			System.out.print("Peso: ");
			float peso = scan.nextFloat();
			paciente.ficha.setPeso(peso);
			System.out.print(" ");
			System.out.println("Doenca cronica:? \n 1.SIM \n 2.Nao");
			int op4 = scan.nextInt();
			switch (op4) {
			case 1:
				paciente.ficha.setDoencaCronica(true);
				System.out.print("Tipo da doenca: ");
				String tipoCronico = scan.next();
				paciente.ficha.setTipoCronico((tipoCronico));
				break;
			case 2:
				paciente.ficha.setDoencaCronica(false);
			default:
				System.out.println("Opcao invalida");
				break;
			}
			System.out.print("Outras doencas: ");
			String outrasDoencas = scan.next();
			paciente.ficha.setOutrasDoencas((outrasDoencas));

		} catch (InputMismatchException e) {
			System.out.println("Erro: Insira os dados corretamente");
		}

		catch (IllegalArgumentException e) {
			System.out.println("Paciente invalido");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

	}

	// Metodo para Prencher inforacoes do paciente e associar ao responsavel
	public void prencherInfo() {
		Paciente paciente = new Paciente();
		try {
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
			System.out.println("Referencia");
			String referencia = scan.next();
			paciente.setReferencia(referencia);
			System.out.println();
			pacientes.add(paciente);

		} catch (InputMismatchException e) {
			System.out.println("Erro: Insira os dados corretamente");
		}

		catch (IllegalArgumentException e) {
			System.out.println("Paciente invalido");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}

	// Metodo para relatar o utilizador
	public void relatar(Responsavel responsavel) {
		try {
			System.out.println("|Admistracao do Sistema|");
			System.out.println("-----------Emitir relatorio---------\n Escreva");
			String path = "D:\\" + responsavel.getNome() + "" + responsavel.getEmail() + ".txt";
			File relatorio = new File(path);
			FileWriter fw = new FileWriter(path);
			BufferedWriter bo = new BufferedWriter(fw);
			String relatar = scan.next();
			bo.write(relatar);
			bo.flush();
			bo.close();
			fw.close();

		} catch (IllegalArgumentException e) {
			System.out.println("Paciente invalido");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

	}

	// Metodo para atualaizar estadso clinico do paciente
	public void atualzarEstado(Paciente paciente) {
		try {
			Date data3 = new Date();
			System.out.println("|Admistracao do Sistema|");
			System.out.println("-----------Atualizar Estado Clinico---------");
			System.out.println(date3.format(data3));
			System.out.println("Recuperado? \n 1.SIM \n 2.Nao");
			int op = scan.nextInt();
			switch (op) {
			case 1:
				paciente.setInfectado(false);
				FaseClinica os = FaseClinica.valueOf("RECUPERADO"); // conver um String em um tipo enumerado
				paciente.setFaseclinica(os);

				break;
			case 2:
				paciente.setInfectado(true);
				System.out.println("Fase: ");
				String fase = scan.next();
				FaseClinica os1 = FaseClinica.valueOf(fase); // conver um String em um tipo enumerado

				paciente.setFaseclinica(os1);
			default:
				System.out.println("Opcao invalida");
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Erro: Insira os dados corretamente");
		} catch (IllegalArgumentException e) {
			System.out.println("Paciente invalido");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

	}

	// Meetodo para notificar o utilizador do sistema, neste caso o responsavel pelo
	// paciente
	public void notificarResponsavel(Responsavel responsavel) {
		try {
			int resp = 1;
			System.out.println("|Admistracao do Sistema|");
			System.out.println("------Notificar utilizador responsavel-----");
			System.out.print("Escreva: ");
			while (resp == 1) {
				String mensagem = scan.nextLine();
				responsavel.setNotificacoes(mensagem);
				System.out.println("Deseja enviar um novo E-mail? \n 1.Sim \n 2.Nao");
				resp = scan.nextInt();
			}
			scan.close();
		} catch (IllegalArgumentException e) {
			System.out.println("Utilizador invalido");
		} catch (InputMismatchException e) {
			System.out.println("Erro: Insira uma opcao valida");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}

	public Paciente operaracaoPaciente() {
		this.allPacientes();
		System.out.println("Selecione o paciente: ");
		int n = scan.nextInt();
		return Enfermeiro.pacientes.get(n - 1);
	}

	public void allPacientes() {
		int n = 1;
		for (Paciente pacientes : Enfermeiro.pacientes) {
			System.out.println(n + ": " + pacientes.getNome().toString());
		}
	}
}
