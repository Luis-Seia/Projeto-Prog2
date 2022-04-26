package com.admistracao;

import java.util.Scanner;

import com.info.utilizadores.Paciente;
import com.info.utilizadores.Responsavel;

public class AdmSystem  {
	Scanner scan = new Scanner(System.in);
	
	public void prencherFicha(Paciente paciente,  Responsavel responsavel) {
		//System.out.println("Seguro: ");
		//boolean seguroMedico = scan.nextBoolean();
		//paciente.setSeguroMedico(seguroMedico);
		System.out.println("Seguradora: ");
		String seguradora = scan.nextLine();
		paciente.setSeguradora((seguradora));
		System.out.println("Credencial: ");
		String credencial = scan.nextLine();
		paciente.setCredencial(credencial);
		System.out.println("Hipertensao: ");
		boolean hipertensao = scan.nextBoolean();
		paciente.setHipertensao(hipertensao);
		System.out.println("TipoSanguineo: ");
		String tipoSanguineo = scan.nextLine();
		paciente.setTipoSanguineo(tipoSanguineo);
		System.out.println("Diabete: ");
		boolean diabete = scan.nextBoolean();
		paciente.setDiabete((diabete));
		System.out.println("Peso: ");
		float peso = scan.nextFloat();
		paciente.setPeso(peso);
		System.out.println("Doenca cronica: ");
		boolean doencaCronica = scan.nextBoolean();
		paciente.setDoencaCronica((doencaCronica));
		System.out.println("Tipo da doenca: ");
		String tipoCronico = scan.nextLine();
		paciente.setTipoCronico((tipoCronico));
		System.out.println("Outras doencas: ");
		String outrasDoencas = scan.nextLine();
		paciente.setOutrasDoencas((outrasDoencas));
		System.out.println("------Familiar responsavel:--------- ");
		responsavel.getNome();
		responsavel.getContacto();
		responsavel.getEmail();
	}
	
	public void prencherInfo(Paciente paciente, Responsavel responsavel) {
		System.out.println("------Paciente:--------- ");
		System.out.println("nome: ");
		String nome = scan.nextLine();
		paciente.setNome(nome);
		System.out.println("idade: ");
		int idade = scan.nextInt();
		paciente.setIdade(idade);
		System.out.println("Genero ");
		char genero = scan.next().charAt(0);
		paciente.setGenero(genero);
		System.out.println("Numero BI ");
		String bi = scan.nextLine();
		paciente.setNumeroBI(bi);
		System.out.println("Endereco: ");
		String endereco = scan.nextLine();
		paciente.setEndereco(endereco);
		System.out.println("Contacto: ");
		String contacto = scan.nextLine();
		paciente.setContacto(contacto);
		System.out.println();
		System.out.println("------Familiar responsavel:--------- ");
		responsavel.getNome();
		responsavel.getContacto();
		responsavel.getEmail();
		System.out.println("------------------------------------- ");
	}
	
	public void relatorio(Paciente paciente) {
		String relatar = scan.nextLine();
		paciente.setInfomation(relatar);
		
	}
	public void atualzarEstado(Paciente paciente) {
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
			String fase = scan.nextLine();
			paciente.setFaseclinica(fase);
			default:
				System.out.println("Opcao invalida");break;
		} 
		
	}
	public void notificarResponsavel(Responsavel responsavel) {
		String mensagem = scan.nextLine();
		while(!"".equals(mensagem)) {
		 responsavel.setNotificacoes(mensagem);
		}
	}
}
