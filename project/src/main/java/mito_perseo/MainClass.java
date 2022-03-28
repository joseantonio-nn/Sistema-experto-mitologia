package mito_perseo;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Collection;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class MainClass {

	private static Parser parser = new Parser();
	
    public static final void main(String[] args) throws FileNotFoundException {
    	
    	// Redirigimos la salida por consola a un fichero de respuesta
    	PrintStream fileStream = new PrintStream(args[0].substring(args[0].lastIndexOf("\\") + 1, args[0].lastIndexOf("."))
    											 + ".Respuesta.txt");
    	System.setOut(fileStream);
    	
    	// Parseamos la entrada y guardamos la pregunta
    	List<String> entrada = parser.leerFichero(args[0]);
    	String pregunta = entrada.remove(0);
    	
        try {
            // Carga de la base de conocimiento
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
                  
        	// Se declaran las instancias de las clases
        	inicializarKSession(kSession);
        	     	
            // Se lee la entrada y se modifica la sesi�n
            modificarKSession(kSession, entrada);
            
            establecerObjetivo(kSession, pregunta);
            
            kSession.fireUntilHalt();
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    
    private static void establecerObjetivo(KieSession kSession, String pregunta) {
    	 List<String> parsedPregunta = parser.parseLinea(pregunta); 
         String verbo = parsedPregunta.get(2);
         Ser sujeto = parser.matchSer(kSession.getObjects(), parsedPregunta.get(0));
         Objetivo objetivo = null;
    
         switch(verbo)
         {
            case "tener":
            	Objeto obj = parser.matchObjeto(kSession.getObjects(), parsedPregunta.get(1));
            	if (obj == null) {
            		Poder poder = parser.matchPoder(kSession.getObjects(), parsedPregunta.get(1));
            		objetivo = new ObjetivoCapacidad(poder, sujeto);
            	} else {
            		objetivo = new ObjetivoTener(obj, sujeto);
            	}	
            	break; 
            
            case "liberar":
            	Ser receptor = parser.matchSer(kSession.getObjects(), parsedPregunta.get(1));
            	objetivo = new ObjetivoLiberar(receptor, sujeto);
            	break; 
         
            default : 
            	break;
         }
         
         kSession.insert(objetivo);
         
	}


	private static void inicializarKSession(KieSession kSession) {
    	
    	DiosMayor atenea = new DiosMayor("Atenea");
    	ObjetoNormal escudoBronce = new ObjetoNormal("Escudo de Bronce");
    	Tiene ateneaEscudo = new Tiene(escudoBronce, atenea);
    	Libre ateneaLibre = new Libre(atenea);
    	
    	DiosMayor hades = new DiosMayor("Hades");
    	ObjetoDivino cascoHades = new ObjetoDivino("Casco del Hades");
    	Invisibilidad cascoInvi = new Invisibilidad(cascoHades);
    	Tiene hadesCasco = new Tiene(cascoHades, hades);
    	Libre hadesLibre = new Libre(hades);
    	
    	DiosMayor hermes = new DiosMayor("Hermes");
    	Arma hozAcero = new Arma("Hoz de Acero");
    	Tiene hermesHoz = new Tiene(hozAcero, hermes);
    	Libre hermesLibre = new Libre(hermes);
    	
    	DiosMayor hefesto = new DiosMayor("Hefesto");
    	Libre hefestoLibre = new Libre(hefesto);
    	
    	DiosMayor poseidon = new DiosMayor("Poseidón");
    	Libre poseidonLibre = new Libre(poseidon);
    	
    	DiosMayor zeus = new DiosMayor("Zeus");
    	Libre zeusLibre = new Libre(zeus);
    	
    	DiosMenor grayas = new DiosMenor("Las Grayas");
    	ObjetoNormal ojoDienteGrayas = new ObjetoNormal("Ojo/Diente de las Grayas");
    	Tiene grayasOjoDiente = new Tiene(ojoDienteGrayas, grayas);
    	Libre grayasLibres = new Libre(grayas);
    	
    	Criatura ceto = new Criatura("Ceto");
    	Preso cetoPreso = new Preso(ceto, poseidon);
    	
    	Criatura medusa = new Criatura("Medusa");
    	ObjetoDivino cabezaMedusa = new ObjetoDivino("Cabeza de Medusa");
    	Piedra cabezaMedusaPiedra = new Piedra(cabezaMedusa);
    	Tiene medusaCabeza = new Tiene(cabezaMedusa, medusa);
    	Libre medusaLibre = new Libre(medusa);
    	
    	Criatura nereidas = new Criatura("Nereidas");
    	Libre nereidasLibres = new Libre(nereidas);
    	
    	Criatura ninfas = new Criatura("Las Ninfas");
    	ObjetoDivino sandaliasAladas = new ObjetoDivino("Sandalias Aladas");
    	Vuelo vueloSandalias = new Vuelo(sandaliasAladas);
    	Tiene ninfasSandalias = new Tiene(sandaliasAladas, ninfas);
    	ObjetoNormal zurronMagico = new ObjetoNormal("Zurrón Mágico");
    	Tiene ninfasZurron = new Tiene(zurronMagico, ninfas);
    	Libre ninfasLibres = new Libre(ninfas);
    	
    	Humano andromeda = new Humano("Andrómeda");
    	Libre andromedaLibre = new Libre(andromeda);
    	
    	Humano danae = new Humano("Dánae");
    	Libre danaeLibre = new Libre(danae);
    	
    	Humano casiopea = new Humano("Casiopea");
    	Libre casiopeaLibre = new Libre(casiopea);
    	
    	Heroe perseo = new Heroe("Perseo",2); 
    	Libre perseoLibre = new Libre(perseo);
    	
    	ObjetoDivino anilloInvisibilidad = new ObjetoDivino("Anillo de Invisibilidad");
    	Invisibilidad anilloInvi = new Invisibilidad(anilloInvisibilidad);
    	
    	ObjetoDivino espejoMano = new ObjetoDivino("Espejo de Mano");
    	Espejo espejoPequeno = new Espejo(espejoMano);
    	
    	ObjetoDivino conjuroVuelo = new ObjetoDivino("Conjuro de Vuelo");
    	Vuelo vueloConjuro = new Vuelo(conjuroVuelo);
    	
    	//FASE 3 -----
    	Humano minos = new Humano("Minos");
    	Libre minosLibre = new Libre(minos);
    	Humano pasifae = new Humano("Pasifae");
    	Libre pasifaeLibre = new Libre(pasifae);
    	Heroe circe = new Heroe("Circe",3);
    	Libre circeLibre = new Libre(circe);
    	Heroe teseo = new Heroe("Teseo",1);
    	Libre teseoLibre = new Libre(teseo);
    	Heroe heracles = new Heroe("Heracles",4);
    	Libre heraclesLibre = new Libre(heracles);
    	Humano ariadna = new Humano("Ariadna");
    	Libre ariadnaLibre = new Libre(ariadna);
    	Criatura minotauro = new Criatura("Minotauro");
    	Preso minotauroPreso = new Preso(minotauro, minos);
    	Humano icaro = new Humano("Ícaro");
    	Libre icaroLibre = new Libre(icaro);
    	Humano dedalo = new Humano("Dédalo");
    	Libre dedaloLibre = new Libre(dedalo);
    	Encontrar icaroDedalo = new Encontrar(icaro, dedalo);
    	Encontrar dedaloIcaro = new Encontrar(dedalo, icaro);
    	DiosMayor afrodita = new DiosMayor("Afrodita");
    	Libre afroditaLibre = new Libre(afrodita);
    	
    	ObjetoDivino pegaso = new ObjetoDivino("Pegaso");
    	Vuelo vueloPegaso = new Vuelo(pegaso);
    	
    	Arma varitaCirce = new Arma("Varita de Circe");
    	Arma punosHeracles = new Arma("Puños de Heracles");
    	ObjetoNormal hiloAriadna = new ObjetoNormal("Hilo de Ariadna"); //De base puede no existir hasta que se enamore de un Heroe
    	Arma espadaTeseo = new Arma("Espada de Teseo");
    	Arma cuernoMinotauro = new Arma("Cuerno del Minotauro"); //Se puede hacer una subclase que sea arma
    	ObjetoNormal ceraPlumas = new ObjetoNormal("Cera y Plumas");

    	Tiene ariadnaHilo = new Tiene(hiloAriadna, ariadna);
    	Tiene circeVarita = new Tiene(varitaCirce, circe);
    	Tiene heraclesPunos = new Tiene(punosHeracles, heracles);
    	Tiene teseoEspada = new Tiene(espadaTeseo, teseo);
    	Tiene minotauroCuerno = new Tiene(cuernoMinotauro, minotauro);
    	Tiene zeusPegaso = new Tiene(pegaso, zeus);
    	
    	DiosMenor caronte = new DiosMenor("Caronte");
    	Libre caronteLibre = new Libre(caronte);
    	Humano sibilas = new Humano("Sibilas de Cumas");
    	Libre sibilasLibre = new Libre(sibilas);
    	Criatura cerbero = new Criatura("Cerbero");
    	Preso cerberoPreso = new Preso(cerbero, hades);
    	ObjetoNormal ramaOro = new ObjetoNormal("Rama de Oro");
    	Tiene sibilasRama = new Tiene(ramaOro, sibilas);
    	
        kSession.insert(atenea);
        kSession.insert(escudoBronce);
        kSession.insert(ateneaEscudo);
        kSession.insert(ateneaLibre);
        
        kSession.insert(hades);
        kSession.insert(cascoHades);
        kSession.insert(cascoInvi);
        kSession.insert(hadesCasco);
        kSession.insert(hadesLibre);
        
        kSession.insert(hermes);
        kSession.insert(hozAcero);
        kSession.insert(hermesHoz);
        kSession.insert(hermesLibre);
        
        kSession.insert(hefesto);
        kSession.insert(hefestoLibre);
        kSession.insert(poseidon);
        kSession.insert(poseidonLibre);
        kSession.insert(zeus);
        kSession.insert(zeusLibre);
        
        kSession.insert(grayas);
        kSession.insert(ojoDienteGrayas);
        kSession.insert(grayasOjoDiente);
        kSession.insert(grayasLibres);
        
        kSession.insert(ceto);
        kSession.insert(cetoPreso);
        
        kSession.insert(medusa);
        kSession.insert(cabezaMedusa);
        kSession.insert(cabezaMedusaPiedra);
        kSession.insert(medusaCabeza);
        kSession.insert(medusaLibre);
        
        kSession.insert(nereidas);
        kSession.insert(nereidasLibres);
        
        kSession.insert(ninfas);
        kSession.insert(zurronMagico);
        kSession.insert(sandaliasAladas);
        kSession.insert(vueloSandalias);
        kSession.insert(ninfasSandalias);
        kSession.insert(ninfasZurron);
        kSession.insert(ninfasLibres);
        
        kSession.insert(andromeda);
        kSession.insert(andromedaLibre);
        
        kSession.insert(danae);
        kSession.insert(danaeLibre);
        
        kSession.insert(casiopea);
        kSession.insert(casiopeaLibre);
        
        kSession.insert(perseo);
        kSession.insert(perseoLibre);
        
        kSession.insert(anilloInvisibilidad);
        kSession.insert(anilloInvi);
        kSession.insert(espejoMano);
        kSession.insert(espejoPequeno);
        kSession.insert(conjuroVuelo);
        kSession.insert(vueloConjuro);
        kSession.insert(pegaso);
        kSession.insert(vueloPegaso);
        
        kSession.insert(minos); 
        kSession.insert(pasifae);
        kSession.insert(circe);
        kSession.insert(teseo);
        kSession.insert(heracles);
        kSession.insert(ariadna);
        kSession.insert(minotauro);
        kSession.insert(icaro);
        kSession.insert(dedalo);
        kSession.insert(icaroDedalo);
        kSession.insert(dedaloIcaro);
        kSession.insert(afrodita);
        
        kSession.insert(minosLibre);
        kSession.insert(pasifaeLibre);
        kSession.insert(circeLibre);
    	kSession.insert(teseoLibre);
    	kSession.insert(heraclesLibre);
    	kSession.insert(ariadnaLibre);
    	kSession.insert(minotauroPreso);
    	kSession.insert(icaroLibre);
    	kSession.insert(dedaloLibre);
    	kSession.insert(afroditaLibre);
    	
        kSession.insert(hiloAriadna);
        kSession.insert(varitaCirce);
        kSession.insert(espadaTeseo);
        kSession.insert(punosHeracles);
        kSession.insert(cuernoMinotauro);
        
        kSession.insert(ariadnaHilo);
        kSession.insert(teseoEspada);
        kSession.insert(minotauroCuerno);
        kSession.insert(circeVarita);
        kSession.insert(heraclesPunos);
        kSession.insert(ceraPlumas);  
        kSession.insert(zeusPegaso);
        
        kSession.insert(caronte);
        kSession.insert(caronteLibre); 
        kSession.insert(sibilas);
        kSession.insert(sibilasLibre); 
        kSession.insert(cerbero); 
        kSession.insert(cerberoPreso);
        kSession.insert(ramaOro); 
        kSession.insert(sibilasRama); 
    }
    
    private static void modificarKSession(KieSession kSession, List<String> entrada) {
    	
        boolean negado;
        String parteDerecha;
        Ser sujeto;
        Ser receptor;
        Objeto obj;
        
        List<String> parsedLinea;
        Collection<? extends Object> collectionObjetos = kSession.getObjects();
        
        for (String linea : entrada) {
        	parsedLinea = parser.parseLinea(linea);
        	negado = parser.isNegado(parsedLinea);
        	sujeto = parser.matchSer(collectionObjetos, parsedLinea.get(0));
        	obj = parser.matchObjeto(collectionObjetos, parsedLinea.get(1));
        	
        	//En primer lugar vemos si la parte derecha tiene un objeto
        	if (obj != null) {
        		//Si hay un objeto, solo faltara ver si se tiene o no 
        		if (negado) {
        			Perder perder = new Perder(obj, sujeto);
        			kSession.insert(perder);
        		} else {
        			Obtener tiene = new Obtener(obj, sujeto);
        			kSession.insert(tiene);
        		}
        	}
        	//Si no lo tiene, contendr� un sujeto y quiz�s tenga favor/enojo
        	else {
        		receptor = parser.matchSer(collectionObjetos, parsedLinea.get(1));
        		parteDerecha = parser.parserReceptor(parsedLinea.get(1)); //Ser� null, si no hay ni enojo ni favor
            	
            	if (parteDerecha != null) {
            		if (!negado) {
            			if (parteDerecha.equals("favor")) {
            				Favorecido favor = new Favorecido(sujeto, receptor);
                			kSession.insert(favor);
                		}
            			//Enojo
                		else { 
                			Enfado enfado = new Enfado(sujeto, receptor);
                			kSession.insert(enfado);
                		}
            		}
            	} 
            	//Verbo: Apresa
            	else {
            		Apresar apresar = new Apresar(sujeto, receptor);
            		kSession.insert(apresar);
            	}	
        	}
        }
    }
}
