package fp.test;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import fp.common.Club;
import fp.futbol.Jugador;
import fp.futbol.FactoriaJugador;
public class TestJugador {

	public static void main(String[] args) {
		Jugador j1=new Jugador("Karim Benzema",null, 89,89,66000000.0,350000.0,33,LocalDate.of(1987,12,19),185,81,new Club("Real Madrid CF",91701,100),"France","Right","Yes");
		j1.incorporaPosiciones("CF");
		j1.incorporaPosiciones("ST");
		System.out.println(j1.toString());
		Jugador j2=new Jugador("Eden Hazard",null,85,85,52000000.,240000.0,30,LocalDate.of(1991, 1, 7),175,74,new Club("Real Madrid CF",91701,100),"Belgium","Right","Yes");
		j2.incorporaPosiciones("LW");
		Jugador j3=new Jugador("Wissam Ben Yedder",84,240000.0);
		System.out.println(j3);
		System.out.println(j2.toString());
		System.out.println(j1.IMC());
		System.out.println(j2.IMC());
		j3.setEdad(30);
		System.out.println(j3.equals(j2));
		System.out.println(j1.getClub().getCadenaFormato());
		System.out.println(j1.getClub().getCadenaFormato());
		System.out.println(j1.getClub().toString());
		System.out.println(j1.getClub().equals(j2.getClub()));
	}

}
