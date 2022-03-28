package mito_perseo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Parser {
	
	private List<String> verbos;
	private List<String> bendiciones;
	
	public Parser() {
		this.verbos = new LinkedList<String>();
		Collections.addAll(verbos, "tiene", "apresa", "tener", "liberar");
		this.bendiciones = new LinkedList<String>();
		Collections.addAll(bendiciones, "favor", "enojo");
	}
	
	public List<String> leerFichero(String nombre) {
		int i = 0;
    	List<String> entrada = new LinkedList<String>();
    	
    	try {
    		File fichero = new File(nombre);
    		Scanner reader = new Scanner(fichero, "UTF-8");
    		
    		while (reader.hasNextLine()) {
    			String linea = reader.nextLine();
    			if (i != 1) entrada.add(linea);
    			i++;
    		}
    	    reader.close();
    	      
    	} catch (FileNotFoundException e) {
    	    System.out.println("El fichero no se encontró.");
    	    e.printStackTrace();
    	}
    	
    	return entrada;
    }
	 
	public Ser matchSer(Collection<? extends Object> collection, String nombre) {
    	 for (Object obj : collection) {
         	if (obj instanceof Ser && nombre.contains(((Ser) obj).getNombre())) {
         		return (Ser)obj;
         	}
         }
		return null;
    }
	
	public Objeto matchObjeto(Collection<? extends Object> collection, String nombre) {
   	 	for (Object obj : collection) {
        	if (obj instanceof Objeto && ((Objeto) obj).getNombre().equals(nombre)) {
        		return (Objeto)obj;
        	}
        }
		return null;
	}
	
	public Poder matchPoder(Collection<? extends Object> collection, String nombre) {
   	 	for (Object poder : collection) {
        	if ((poder instanceof Poder) && (nombre.contains(((Poder) poder).getNombre()))) {
        		return (Poder) poder;
        	}
        }
		return null;
	}

	public List<String> parseLinea(String linea) {
		List<String> palabras = new LinkedList<String>();

		for (String verbo : verbos) {
			if (linea.contains(verbo)) {
				palabras = new LinkedList<String>(Arrays.asList(linea.split(" " + verbo + " ")));
				palabras.set(1, palabras.get(1).replace(".", ""));
				palabras.add(verbo);
				return palabras;
			}
		}

		return null;
	}
	
	public String parserReceptor(String parsedLinea) {
		for (String bendicion : bendiciones) {
			if (parsedLinea.contains(bendicion))
				return bendicion;
		}
		return null;
	}

	public boolean isNegado(List<String> parsedLinea) {
		if (parsedLinea.get(0).contains(" no")) {
			parsedLinea.set(0, parsedLinea.get(0).replace(" no", ""));
			return true;
		}
		return false;
	}
}
