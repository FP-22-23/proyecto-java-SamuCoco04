package fp.test;

import java.util.List;

import fp.futbol.Equipo;
import fp.futbol.EquipoBucles;
import fp.futbol.FactoriaJugador;
import fp.futbol.Implementacion;
import fp.futbol.Jugador;
import fp.futbol.Liga;
import fp.futbol.PieBueno;

public class TestContenedorEquipo {

	public static void main(String[] args) {
		FactoriaJugador.setImplementacion(Implementacion.BUCLES);
		Equipo e2= FactoriaJugador.leeEstudiantes("./data/players_22_V3 - PLAYERS.csv");
		System.out.println(e2.toString());
		System.out.println(e2.getNumeroJugadores());
		System.out.println(e2.existeJugadorConEdad(40));
		System.out.println(e2.existeJugadorConEdad(25));
		System.out.println(e2.mediaEdad());
		System.out.println(e2.filtraPieBueno(PieBueno.Right));
		System.out.println(e2.agrupaPieBueno());
		System.out.println(e2.cuentaPieBueno());

	}

}
