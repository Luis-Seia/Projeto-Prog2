package Utilizador;
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
		System.out.println("nome: ");
		String nome = scan.nextLine();
		this.setNome(nome);
		System.out.println("idade: ");
		int idade = scan.nextInt();
		this.setIdade(idade);
		System.out.println("Genero ");
		char genero = scan.next().charAt(0);
		this.setGenero(genero);
		System.out.println("Numero BI ");
		String bi = scan.nextLine();
		this.setNumeroBI(bi);
		System.out.println("Endereco: ");
		String endereco = scan.nextLine();
		this.setEndereco(endereco);
		System.out.println("Contacto: ");
		String contacto = scan.nextLine();
		this.setContacto(contacto);
		System.out.println("E-mail");
		String email = scan.nextLine();
		this.setEmail(email);
	}
	
	// Metodo para acedar as informacoes do paciente associado
	int operacoes = scan.nextInt();
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
	
}
