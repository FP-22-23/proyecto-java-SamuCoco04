package fp.utiles;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ficheros {

	 private static final Charset DEFAULT_ENCODING = StandardCharsets.ISO_8859_1;
	/**
	 * @param path
	 *            Ruta del fichero a leer.
	 * @return Una lista de String en la que cada elemento se corresponde con una de las
	 *         lÃ­neas del fichero leido. El ordinal de la lÃ­nea, por tanto, estÃ¡
	 *         relacionado con la posiciÃ³n de la lÃ­nea en la lista.
	 */
	public static List<String> leeFichero(String errMsg, String path) {
		return leeFichero(errMsg, path, DEFAULT_ENCODING);
	}
	
	public static List<String> leeFichero(String errMsg, String path, Charset encoding) {
		List<String> res = null;
		try {
			res = Files.readAllLines(Paths.get(path),encoding);
		} catch (IOException e) {
			System.out.println(errMsg);
			e.printStackTrace();
			res = new ArrayList<String>();
		}
		return res;
	}
	/**
	 * @param errMsg
	 * @param path
	 * @return
	 */
	public static String leeFicheroTexto (String errMsg, String path) {
		
		return leeFicheroTexto(errMsg, path, DEFAULT_ENCODING);
	}

	/**
	 * @param errMsg
	 * @param path
	 * @return
	 */
	public static String leeFicheroTexto (String errMsg, String path, Charset encoding) {
		
		List<String> lineas = leeFichero(errMsg, path, encoding);
		return lineas.stream()
					 .collect(Collectors.joining());
	}

	/**
	 * @param path
	 * 		Ruta del fichero a leer.
	 * @param deString_a_T 
	 * 		FunciÃ³n que permite convertir una cadena a un objeto de tipo T. 
	 *      La cadena se corresponde con una de las lÃ­neas del fichero.
	 * @return Una lista de objetos tipo T creados con la informaciÃ³n incluida en cada una de las
	 *      lÃ­neas del fichero.
	 */
	public static <T> List<T> leeFichero(String errMsg, String path, Function<String, T> deString_a_T) {
		return leeFichero(errMsg, path, DEFAULT_ENCODING, deString_a_T);
	}

	public static <T> List<T> leeFichero(String errMsg, String path,Charset encoding,  Function<String, T> deString_a_T) {
		List<T> res = null;
		try {
			res = Files.lines(Paths.get(path),encoding)
					   .map(deString_a_T)
					   .collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println(errMsg);
			e.printStackTrace();
			res = new ArrayList<T>();
		}
		return res;
	}

	/**
	 * @param objetos Stream de objetos que se escriben en el fichero.
	 * @param funcion FunciÃ³n que transforma el objeto en una cadena para escribirla en el fichero.
	 * @param nombreFichero Nombre del fichero en el que se escribe el Stream de objetos
	 * Como efecto lateral se crea un fichero con el nombre dado y la transformaciÃ³n del objeto
	 * en cada linea.
	 */
	public static <T> void escribeFichero(String errMsg, Stream<T> objetos, Function<T, String> funcion, String nombreFichero) {
		escribeFichero(errMsg, objetos,  funcion, nombreFichero, DEFAULT_ENCODING);
	}

	public static <T> void escribeFichero(String errMsg, Stream<T> objetos, Function<T, String> funcion, String nombreFichero, Charset encoding) {
		List<String> cadenas = objetos
				.map(funcion)
				.collect(Collectors.toList());
		try {
			Files.write(Paths.get(nombreFichero), cadenas, encoding);
		} catch (IOException e) {
			System.err.println(errMsg);
		}
	}

	/**
	 * @param errMsg Mensaje de error que se muestra si hay problemas de escritura
	 * @param texto Cadena de texto a guardar en el fichero
	 * @param nombreFichero Nombre de fichero a guardar.
	 */
	public static <T> void escribeFicheroTexto(String errMsg, String texto, String nombreFichero) {
		try {
			Files.write(Paths.get(nombreFichero), 
					    texto.getBytes());
		} catch (IOException e) {
			System.err.println(errMsg);
		}
	}
	
	/**
	 * @param objeto Objeto que se quiere escribir en un fichero
	 * @param nombreFichero Nombre y ruta del fichero en el que se va a escribir el objeto.
	 * Como efecto lateral se crea un fichero con la representaciÃ³n como cadena del objeto.
	 */
	public static <T> void escribeFichero(String errMsg, T objeto, String nombreFichero) {
		escribeFichero(errMsg, objeto, nombreFichero, DEFAULT_ENCODING);
	}

	public static <T> void escribeFichero(String errMsg, T objeto, String nombreFichero, Charset encoding) {
		escribeFichero(errMsg, Stream.of(objeto), Object::toString, nombreFichero, encoding);
	}
	/**
	 * @param objetos ColecciÃ³n de objetos a guardar en el fichero
	 * @param nombreFichero Nombre y ruta del fichero en el que se va a escribir el objeto.
	 * Como efecto lateral se crea un fichero con la representaciÃ³n como cadena de los objetos
	 * de la colecciÃ³n. Cada objeto estÃ¡ asociado a una linea del fichero.
	 */
	public static <T> void escribeFichero(String errMsg, Collection<T> objetos, String nombreFichero) {
		escribeFichero(errMsg, objetos, nombreFichero, DEFAULT_ENCODING);
	}

	public static <T> void escribeFichero(String errMsg, Collection<T> objetos, String nombreFichero, Charset encoding) {
		escribeFichero(errMsg, objetos.stream(), Object::toString, nombreFichero, encoding);
	}

	/**
	 * @param m Map 
	 * @param nombreFichero Nombre y ruta del fichero en el que se van a escribir la entradas de
	 *     la aplicaciï¿½n m.
	 * Como efecto lateral se crea un fichero con la representaciÃ³n como cadena de la clave seguido de 
	 * una flecha y la representaciÃ³n como cadena del valor.
	 *     
	 */
	public static <K, V> void escribeFichero(String errMsg, Map<K, V> m, String nombreFichero) {
		escribeFichero(errMsg, m, nombreFichero, DEFAULT_ENCODING);
	}
	
	public static <K, V> void escribeFichero(String errMsg, Map<K, V> m, String nombreFichero, Charset encoding) {
		escribeFichero(errMsg, m.entrySet().stream(), 
				e -> e.getKey().toString() + "-> " + e.getValue().toString(),
				nombreFichero, encoding);
	}

}