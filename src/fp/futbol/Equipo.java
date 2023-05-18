package fp.futbol;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public interface Equipo {

	List<Jugador> getJugadores();

	Liga getLiga();

	Boolean getUcl();

	Integer getPosicionLiga();

	String toString();

	int hashCode();

	boolean equals(Object obj);

	Boolean existeJugadorConEdad(Integer edad);

	Double mediaEdad();

	List<Jugador> filtraPieBueno(PieBueno pie);

	Jugador maxalturadeEquipo(String Equipo);

	List<Jugador> ordenaEquipo(String Equipo);

	Map<PieBueno, List<Jugador>> agrupaPieBueno();

	Map<String, List<String>> mapJuagdoresClubes();

	Map<String, Integer> edadMasAltaPorClub();

	SortedMap<PieBueno, List<Jugador>> masAltosSegunPierna(Integer n);

	String getEquipoConMenorSueldo();

	Integer getNumeroJugadores();

	Map<PieBueno,Integer> cuentaPieBueno();

}