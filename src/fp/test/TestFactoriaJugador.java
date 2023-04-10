package fp.test;

import java.util.List;

import fp.futbol.FactoriaJugador;
import fp.futbol.Jugador;

public class TestFactoriaJugador {
	public static void main(String[] args) {
        List<Jugador> jugadores= FactoriaJugador.leeJugadores("./data/players_22_V3 - PLAYERS.csv");
        System.out.println("Se han leido " + jugadores.size() + " jugadores");
        for (Jugador e : jugadores) {
            System.out.println(e);
        }
	}
}
