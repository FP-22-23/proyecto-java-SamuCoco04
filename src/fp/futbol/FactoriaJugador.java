package fp.futbol;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fp.common.Club;
import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaJugador {
	public static List<Jugador> leeJugadores(String fichero){
        List<Jugador> res = new ArrayList<>();
        Checkers.checkNoNull(fichero);
        List<String> lineas = Ficheros.leeFichero("Error lectura", fichero);
        lineas.remove(0);
        for(String linea:lineas) {
            Jugador c= parseaJugador(linea);
            res.add(c);
        }
        return res;
    }

    private static Jugador parseaJugador(String s) {
        Checkers.checkNoNull(s);
        String [] trozos = s.split(",");
        Checkers.check("Formato no válido", trozos.length==16);
        String nombre=trozos[0].trim();
        List<String> posiciones= parsLista(trozos[1].trim());
        Integer valoracion=parsInt(trozos[2].trim());
        Integer potencial=parsInt(trozos[3].trim());
        Double valor=parsDoubl(trozos[4].trim());
        Double sueldo=parsDoubl(trozos[5].trim());
        Integer edad=parsInt(trozos[6].trim());
        LocalDate dob=parseaFecha(trozos[7].trim());
        Integer altura=parsInt(trozos[8].trim());
        Integer peso=parsInt(trozos[9].trim());
        String nacionalidad=trozos[11].trim();
        String nClub=trozos[10].trim();
        PieBueno pie=parsEnum(trozos[12].trim());
        Boolean cara=formateaCara(trozos[13].trim());
        Integer socios=parsInt(trozos[14].trim());
        Integer titulos=parsInt(trozos[15].trim());
        Jugador res=new Jugador(nombre,posiciones,valoracion,potencial,valor,sueldo,edad,dob,altura,peso,new Club(nClub,titulos,socios),nacionalidad,pie,cara);
        return res;
    }

	public static Boolean formateaCara(String cara) {
		Boolean res=true;
		switch(cara) {
		case "No":
			res=false;
			break;
		}
		return res;
	}

	private static PieBueno parsEnum(String s) {
    	PieBueno res = null;
        if (s!=null && !s.isEmpty()) {
            res = PieBueno.valueOf(s);
        }
        return res;
    };
	

	private static Double parsDoubl(String s) {
        Double res = null;
        if (s!=null && !s.isEmpty()) {
            res = Double.parseDouble(s);
        }
        return res;
    }
	

	private static Integer parsInt(String s) {
        Integer res = null;
        if (s!=null && !s.isEmpty()) {
            res = Integer.parseInt(s);
        }
        return res;
    }

	private static List<String> parsLista(String s) {
        Checkers.checkNoNull(s);
        Checkers.check("",!s.isEmpty());
    	String[] trozos = s.split(";");
    	List<String> posiciones= new LinkedList<>();
    	for (String trozo:trozos) {
    		posiciones.add(trozo);
    		}
    	return posiciones;
	}

	private static LocalDate parseaFecha(String s) {
        Checkers.checkNoNull(s);
        Checkers.check("",!s.isEmpty());
        LocalDate res = LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Checkers.check("Fecha incorrecta", res.isBefore(LocalDate.now()));
        return res;
    }

}
