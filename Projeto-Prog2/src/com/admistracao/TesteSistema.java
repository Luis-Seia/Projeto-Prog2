package com.admistracao;

import java.io.IOException;


import com.info.utilizadores.Paciente;
import com.info.utilizadores.Responsavel;
public class TesteSistema {
public static void main (String[] args) throws IOException {
	Enfermeiro a = new Enfermeiro("Luis","UYFGUYF","Mavalane","N");
	 Paciente p1 = new Paciente();
	 Responsavel r1 = new Responsavel();
	 	a.prencherFicha(p1);
	     a.prencherInfo(p1);
	     a.atualzarEstado(p1);
	     a.relatorio(p1);
	     a.notificarResponsavel(r1);
	     r1.cadastrar();
	     r1.operacoes(p1);
	
}
}
