package BaseDados;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.info.users.Paciente;


public class BaseDadosPaciente {
	public final static String path = "src\\BaseDados\\lista_Paciente.txt";

	public static HashMap<String, Paciente> map = new HashMap<String, Paciente>();

	public static void salvarUtilizador(String credencial, Paciente paciente) {
		BaseDadosPaciente.map.put(credencial, paciente);
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

			Set<Map.Entry<String, Paciente>> set = map.entrySet();
			for (Map.Entry<String, Paciente> resp : set) {

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

	public static boolean salvarPermanentemente(HashMap<String, Paciente> novo_map) {

		boolean salvo = false;

		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		// Escrita em ficheiros
		try {

			fos = new FileOutputStream(path);
	
			bos = new BufferedOutputStream(fos);

			Set<Map.Entry<String, Paciente>> novo_set = novo_map.entrySet();
			for (Map.Entry<String, Paciente> prod : novo_set) {

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
