package fp.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import fp.common.Club;
import fp.futbol.Equipo;
import fp.futbol.EquipoStreams;
import fp.futbol.FactoriaJugador;
import fp.futbol.Jugador;
import fp.futbol.PieBueno;
import fp.utiles.Checkers;

public class TestFactoriaJugador {
	public static void main(String[] args) throws IOException {
        List<Jugador> jugadores= FactoriaJugador.leeJugadores("./data/players_22_V3 - PLAYERS.csv").getJugadores();
        System.out.println("Se han leido " + jugadores.size() + " jugadores");
        for (Jugador e : jugadores) {
            System.out.println(e);
        }
	}
}