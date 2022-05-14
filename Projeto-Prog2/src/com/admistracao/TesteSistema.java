package com.admistracao;

import com.info.utilizadores.Paciente;
import com.info.utilizadores.Responsavel;
import com.info.utilizadores.TesteUtilizador;
public class TesteSistema {
public static void main (String[] args) {
	Enfermeiro a = new Enfermeiro("Luis","UYFGUYF","Mavalane","N");
	
	 Paciente p1 = new Paciente();
	 Responsavel r1 = new Responsavel();
	//a.prencherFicha(p1);
	//r1.cadastrar();
	
	//System.out.println("sim");
	
//	a.prencherInfo(p1, r1);
	//a.atualzarEstado(p1);
	//a.relatorio(p1);
	a.notificarResponsavel(r1);
	//r1.operacoes(p1);
	
}
}
