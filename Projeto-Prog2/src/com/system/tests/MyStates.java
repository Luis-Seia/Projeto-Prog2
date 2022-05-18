package com.system.tests;

import java.util.ArrayList;
import java.util.Scanner;

import com.admistracao.Enfermeiro;
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
          public void operacoesEnfermeiro(Enfermeiro logado) {
        	  
          }
          public void cadastrarEnfermeiro() {
        	  Enfermeiro enfermiro = new Enfermeiro();
        	  enfermiro.cadastrar();
        	  enfermeiros.add(enfermiro);
          }
    	
    
    
    
}
