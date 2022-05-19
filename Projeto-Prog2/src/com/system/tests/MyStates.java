package com.system.tests;

import java.util.ArrayList;
import java.util.Scanner;
import com.admistracao.Enfermeiro;
import com.info.utilizadores.Paciente;
import com.info.utilizadores.Responsavel;





public class MyStates {
	Scanner scan = new Scanner(System.in);
	private ArrayList<Enfermeiro> enfermeiros;
    private ArrayList<Responsavel> responsaveis;
    {
    	enfermeiros = new ArrayList<>();
    	responsaveis = new ArrayList<>();
        this.menu();
    }
    
    public void menu() {
    	System.out.println("****My States****");
    	System.out.println("login: 1. Enfermeiro \n 2. Utlizador\\Responsavel ");
    	int opcao  = scan.nextInt();
    	switch(opcao) {
    	case 1: 
    		System.out.println(" 1. Fazer login \n 2. Cadastrar");
    		int op = scan.nextInt();
    			switch(op) {
    			case 1:
    				this.login_do_Enfermeiro();
    			case 2: 
    			this.cadastrarEnfermeiro();
    		}
    	case 2:
    		System.out.println(" 1. Fazer login \n 2. Cadastrar");
    		int opS = scan.nextInt();
			switch(opS) {
			case 1:
				this.login_do_Responsavel();
			case 2: 
			this.cadastrarResponsavel();
		}
    	}
    }
    
    
    public void login_do_Enfermeiro(){
        System.out.println("Username: ");
        String nome = scan.next();

        System.out.println("Password: ");
        String senha = scan.next();

        for(Enfermeiro enfermeiro: enfermeiros){
        	if(enfermeiro.efetuarLogin(nome,senha)==true){
            	Enfermeiro logado = enfermeiro;
   
                 this.operacoesEnfermeiro(logado);
            }else {
            	System.out.println("Verifique se o nome e a enha estao corretos");
            }
            
        }
    }
    public void login_do_Responsavel(){
        System.out.println("Nome: ");
        String nome = scan.next();

        System.out.println("Password: ");
        String senha = scan.next();

        for(Responsavel responsavel: responsaveis){
        	if(responsavel.efetuarLogin(nome,senha)==true){
            	Responsavel  logado = responsavel;
                 this.operacoesResponsavel(logado);
            }else {
            	System.out.println("Verifique se o nome e a enha estao corretos");
            }
            
        }
    }
          public void operacoesEnfermeiro(Enfermeiro logado) {
        	  int opcao;
        	  do {
        	  System.out.println("1. Registrar um novo pacienye \n 2. Operar paciente exitente \n 3. sair");
        	  opcao = scan.nextInt();
  			switch(opcao) {
  			case 1:
  				logado.prencherInfo();break;
  			case 2:
  				System.out.println("1. Prencher\\Atualizar Ficha Medica 2. Atualizar Estado Clinico  \n 3."
  	        	  		+ "Notificar responsavel \n 4. Relatar \n 5. Sair");
  				int ops = scan.nextInt();
  				do {
  				switch(ops) {
  				case 1:
  					Paciente paciente1 = logado.operarPaciente();
  					logado.prencherFicha(paciente1);break;
  				case 2:
  					Paciente paciente = logado.operarPaciente();
  					logado.atualzarEstado(paciente);break;
  				case 3:
  					Responsavel responsvel = this.selecionarResponsavel();
  					logado.notificarResponsavel(responsvel);break;
  				case 4:
  				responsvel = this.selecionarResponsavel();
  				logado.relatar(responsvel);break;
  				default:
  					System.out.println("Opcao invalida");
  					}
  				}while (ops != 5);
  			}
        	  }while (opcao != 3);
        	  
          }
          public void operacoesResponsavel(Responsavel responsavel ) {
        	  System.out.println();
          }
          public void cadastrarEnfermeiro() {
        	  Enfermeiro enfermiro = new Enfermeiro();
        	  enfermiro.cadastrar();
        	  enfermeiros.add(enfermiro);
          }
    	
          public void cadastrarResponsavel() {
        	  Responsavel responsavel = new Responsavel();
        	  responsavel.cadastrar();
        	  responsaveis.add(responsavel);
          }
          public Responsavel selecionarResponsavel(){
              this.allResponavel();
              System.out.println("Selecione o utilizador ");
              int n = scan.nextInt();
              return this.responsaveis.get(n-1);
          }
          public void allResponavel(){
      		 int n =1;
              for(Responsavel responsavel: responsaveis ){
             	 System.out.println(n + ": " + responsavel.toString());
              }
          }
    
}
