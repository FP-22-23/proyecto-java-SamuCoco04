package fp.test;

import java.util.List;

import fp.futbol.Equipo;
import fp.futbol.FactoriaJugador;
import fp.futbol.Jugador;
import fp.futbol.Liga;
import fp.futbol.PieBueno;

public class TestContenedorEquipo {

	public static void main(String[] args) {
		List<Jugador> jugadores= FactoriaJugador.leeJugadores("./data/players_22_V3 - PLAYERS.csv");
		Equipo e1=new Equipo(Liga.SANTANDER,false,10);
		Equipo e2=new Equipo(jugadores,Liga.BUNDESLIGA,true,1);
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e2.getNumeroEstudiantes());
		System.out.println(e2.existeJugadorConEdad(40));
		System.out.println(e2.existeJugadorConEdad(25));
		System.out.println(e2.mediaEdad());
		System.out.println(e2.filtraPieBueno(PieBueno.Right));
		System.out.println(e2.agrupaPieBueno());
		System.out.println(e2.cuentaPieBueno());

	}

}
