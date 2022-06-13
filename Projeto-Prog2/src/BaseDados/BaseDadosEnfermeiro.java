package BaseDados;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.management.users.Enfermeiro;

public class BaseDadosEnfermeiro {
	public final static String path = "src\\BaseDados\\lista_Enfermeiro.txt";

	public static HashMap<String, Enfermeiro> map = new HashMap<String, Enfermeiro>();

	public static void salvarUtilizador(String senha, Enfermeiro enfermeiro) {
		BaseDadosEnfermeiro.map.put(senha, enfermeiro);
	}

	public static boolean salvarPermanentemente() {
		boolean salvo = false;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		// Escrita em ficheiros
		try {

			fos = new FileOutputStream(path, true);
			// O argumento true serve para indicar que nao sobrescrever o conteudo do
			// ficheiro
			bos = new BufferedOutputStream(fos);

			Set<Map.Entry<String, Enfermeiro>> set = map.entrySet();
			for (Map.Entry<String, Enfermeiro> resp : set) {

				String texto = "[" + resp.getKey() + "|" + resp.getValue() + " \n";

				byte[] textoByte = texto.getBytes(StandardCharsets.UTF_8);
				bos.write(textoByte);
			}

			bos.flush();
			bos.close();
			fos.close();
			salvo = true;

		} catch (Exception e) {
			salvo = false;
			System.out.print("ERRO AO SALVAR: ");
			e.printStackTrace();
		} finally {

		}
		return salvo;
	}

	public static boolean salvarPermanentemente(HashMap<String, Enfermeiro> novo_map) {

		boolean salvo = false;

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		// Escrita em ficheiros
		try {

			fos = new FileOutputStream(path);
	
			bos = new BufferedOutputStream(fos);

			Set<Map.Entry<String, Enfermeiro>> novo_set = novo_map.entrySet();
			for (Map.Entry<String, Enfermeiro> prod : novo_set) {

				String texto = "[" + prod.getKey() + "|" + prod.getValue() + " \n";

				byte[] textoByte = texto.getBytes(StandardCharsets.UTF_8);
				bos.write(textoByte);
			}

			bos.flush();
			bos.close();
			fos.close();
			salvo = true;

		} catch (Exception e) {
			salvo = false;
			System.out.print("ERRO AO SALVAR: ");
			e.printStackTrace();
		}

		return salvo;
	}
}
