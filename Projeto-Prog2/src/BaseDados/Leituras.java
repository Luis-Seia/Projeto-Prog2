package BaseDados;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.info.users.Responsavel;
import com.management.users.Enfermeiro;


public class Leituras {
	
	public static Responsavel getUtilizador(String senha){
        return BaseDadosUtilizador.map.get(senha);
    }

    public static HashMap<String, Responsavel> lerUtilizadorFicheiro(){
            
        StringBuilder sb = new StringBuilder();

        //Leitura de ficheiros
        try{
            File f = new File(BaseDadosUtilizador.path);

            BufferedReader br = new BufferedReader(new FileReader(f));

            int linha = 0;
            while((linha = br.read()) != -1){
                sb.append((char)linha);
            }
            br.close();
        }catch(Exception e){
            System.out.print("ERRO AO LER O FICHEIRO: ");
            e.printStackTrace();
        }


        StringTokenizer st = new StringTokenizer(sb.toString(), "\n");

        HashMap<String,Responsavel> map = new HashMap<String, Responsavel>();
        while(st.hasMoreTokens()){
            String produtoString = st.nextToken();
            // [luis|19|M|846428236|seiaa2gmail.com|zimpas|8888840|true]|seagate   
            String nome = produtoString.substring(1, produtoString.indexOf('|'));
            produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
            String idades = produtoString.substring(1, produtoString.indexOf('|'));
            int idade = Integer.parseInt(idades);
            produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
            String genero = produtoString.substring(1, produtoString.indexOf('|'));
            produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
            String contacto= produtoString.substring(1, produtoString.indexOf('|'));
            produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
            String email = produtoString.substring(1, produtoString.indexOf('|'));
            produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
            String endereco = produtoString.substring(1, produtoString.indexOf('|'));
            produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
            String numbi = produtoString.substring(1, produtoString.indexOf('|'));
            produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
            String senha = produtoString.substring(1, produtoString.indexOf(']'));
           
//String nome, String senha, int idade, char genero, String contacto, String email, String endereco,
			
            Responsavel responsa = new Responsavel(nome, senha, idade, genero, contacto,email,endereco,numbi);
            map.put(senha, responsa);

        }
        return map;
    }



public static HashMap<String, Enfermeiro> lerenfermeiroFicheiro(){
    
    StringBuilder sb = new StringBuilder();

    //Leitura de ficheiros
    try{
        File f = new File(BaseDadosUtilizador.path);

        BufferedReader br = new BufferedReader(new FileReader(f));

        int linha = 0;
        while((linha = br.read()) != -1){
            sb.append((char)linha);
        }
        br.close();
    }catch(Exception e){
        System.out.print("ERRO AO LER O FICHEIRO: ");
        e.printStackTrace();
    }


    StringTokenizer st = new StringTokenizer(sb.toString(), "\n");

    HashMap<String,Enfermeiro> map = new HashMap<String, Enfermeiro>();
    while(st.hasMoreTokens()){
        String produtoString = st.nextToken();
        // [luis|19|M|846428236|seiaa2gmail.com|zimpas|8888840|true]|seagate     Exemplo de como um produto esta representado no ficheito .txt
        String nome = produtoString.substring(1, produtoString.indexOf('|'));
        produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
        String idades = produtoString.substring(1, produtoString.indexOf('|'));
        int idade = Integer.parseInt(idades);
        produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
        String genero = produtoString.substring(1, produtoString.indexOf('|'));
        produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
        String contacto= produtoString.substring(1, produtoString.indexOf('|'));
        produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
        String email = produtoString.substring(1, produtoString.indexOf('|'));
        produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
        String endereco = produtoString.substring(1, produtoString.indexOf('|'));
        produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
        String numbi = produtoString.substring(1, produtoString.indexOf('|'));
        produtoString = produtoString.replace(produtoString.substring(1, produtoString.indexOf('|')+1), "");
        String senha = produtoString.substring(1, produtoString.indexOf(']'));
       
//String nome, String senha, int idade, char genero, String contacto, String email, String endereco,
		
        Enfermeiro enfemeiro = new Enfermeiro(nome, senha, idade, genero, contacto,email,endereco,numbi);
        map.put(senha, enfemeiro);

    }
    return map;
}
}
