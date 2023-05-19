package fp.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import fp.futbol.Equipo;
import fp.futbol.EquipoStreams;
import fp.futbol.FactoriaJugador;
import fp.futbol.Jugador;
import fp.futbol.Liga;
import fp.futbol.PieBueno;

public class TestEquipoStreams {
	public static void main(String[] args) throws IOException {
        Equipo e1= FactoriaJugador.leeJugadores("./data/players_22_V3 - PLAYERS.csv");
        System.out.println(e1.existeJugadorConEdad(33));
        System.out.println(e1.mediaEdad());
        System.out.println(e1.filtraPieBueno(PieBueno.Left));
        System.out.println(e1.maxalturadeEquipo("Real Madrid CF"));
        System.out.println(e1.ordenaEquipo("Real Madrid CF"));
        System.out.println(e1.agrupaPieBueno());
        System.out.println(e1.mapJuagdoresClubes());
        System.out.println(e1.edadMasAltaPorClub());
        System.out.println(e1.masAltosSegunPierna(3));
        System.out.println(e1.getEquipoConMenorSueldo());
        
        
}
}
	
