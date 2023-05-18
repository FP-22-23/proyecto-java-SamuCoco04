package fp.futbol;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.Club;

public class EquipoStreams implements Equipo {
		private List<Jugador> jugadores;
		private Liga liga;
		private Boolean ucl;
		private Integer posicionLiga;
		
		public EquipoStreams(Liga liga,Boolean ucl,Integer posicionLiga) {
			this.jugadores=new LinkedList<Jugador>();
			this.liga=liga;
			this.ucl=ucl;
			this.posicionLiga=posicionLiga;
		}
		public EquipoStreams(List<Jugador> jugador,Liga liga,Boolean ucl,Integer posicionLiga) {
			this.jugadores=jugador;
			this.liga=liga;
			this.ucl=ucl;
			this.posicionLiga=posicionLiga;
		}
		public EquipoStreams(List<Jugador> jugador) {
			this.jugadores=new LinkedList<Jugador>();
		}
		public EquipoStreams(Stream<Jugador> jugador,Liga liga,Boolean ucl,Integer posicionLiga) {
			this.jugadores=jugador.distinct().toList();
			this.liga=liga;
			this.ucl=ucl;
			this.posicionLiga=posicionLiga;
		}
		public EquipoStreams(Stream<Jugador> jugador) {
			this.jugadores=jugador.distinct().toList();
		}
		@Override
		public List<Jugador> getJugadores() {
			return jugadores;
		}
		@Override
		public Liga getLiga() {
			return liga;
		}
		@Override
		public Boolean getUcl() {
			return ucl;
		}
		@Override
		public Integer getPosicionLiga() {
			return posicionLiga;
		}
		@Override
		public String toString() {
			return "EquipoStreams [jugadores=" + jugadores + ", liga=" + liga + ", ucl=" + ucl + ", posicionLiga="
					+ posicionLiga + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(jugadores, liga, ucl);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EquipoStreams other = (EquipoStreams) obj;
			return Objects.equals(jugadores, other.jugadores) && liga == other.liga && Objects.equals(ucl, other.ucl);
		}
		@Override
		public Boolean existeJugadorConEdad(Integer edad) {
			return jugadores.stream().anyMatch(j->j.getEdad().equals(edad));
		}
		@Override
		public Double mediaEdad(){
			return jugadores.stream().mapToDouble(Jugador::getEdad).average().orElse(0.0);
		}
		@Override
		public List<Jugador> filtraPieBueno(PieBueno pie){
			return jugadores.stream().filter(j->j.getPieBueno().equals(pie)).collect(Collectors.toList());
		}
		@Override
		public Jugador maxalturadeEquipo(String Equipo) {
			return jugadores.stream().filter(j->j.getClub().getEquipo().equals(Equipo)).max(Comparator.comparing(Jugador::getAltura)).orElseThrow();
		}
		@Override
		public List<Jugador> ordenaEquipo (String Equipo) {
			return jugadores.stream().filter(j->j.getClub().getEquipo().equals(Equipo)).sorted(Comparator.comparing(Jugador::getAltura)).collect(Collectors.toList());
		}
		@Override
		public Map<PieBueno,List<Jugador>> agrupaPieBueno() {
			return jugadores.stream().collect(Collectors.groupingBy(Jugador::getPieBueno));
		}
		@Override
		public Map<String, List<String>> mapJuagdoresClubes(){ 
		return jugadores.stream().collect(Collectors.groupingBy(j->j.getClub().equipo(),Collectors.mapping(Jugador::getNombre,Collectors.toCollection(()->new LinkedList<String>()))));
		}
		@Override
		public Map<String, Integer> edadMasAltaPorClub(){
	        return jugadores.stream()
	                .collect(Collectors.groupingBy(
	                        j->j.getClub().getEquipo(),
	                        Collectors.collectingAndThen(
	                                Collectors.maxBy(
	                                        Comparator.comparingInt(e->e.getEdad())),
	                                e->e.get().getEdad())));
	    }
		@Override
		public SortedMap<PieBueno, List<Jugador>> masAltosSegunPierna(Integer n){
	        Comparator<Jugador> c = Comparator.comparing(e->e.getAltura());
	        return jugadores.stream()
	                .collect(Collectors.groupingBy(
	                        Jugador::getPieBueno,
	                        TreeMap::new,
	                        Collectors.toList()))
	                .entrySet()
	                .stream()
	                .collect(Collectors.toMap(
	                        Map.Entry::getKey,
	                        v->v.getValue()
	                        .stream()
	                        .sorted(c.reversed())
	                        .limit(n)
	                        .collect(Collectors.toList()),
	                        (a,b)->a,TreeMap::new));
	    }
		@Override
		public String getEquipoConMenorSueldo() {
	        Map<String, List<Double>> epp = jugadores.stream()
	                .collect(Collectors.groupingBy(
	                        j->j.getClub().getEquipo(),
	                        Collectors.mapping(Jugador::getSueldo, Collectors.toList())));
	        return epp.entrySet()
	                .stream()
	                .min(Comparator.comparing(v-> Collections.min(v.getValue())))
	                .map(Map.Entry::getKey)
	                .orElseThrow();
	    }
		@Override
		public Integer getNumeroJugadores() {
			// TODO Auto-generated method stub
			throw new NoSuchFieldError();
		}
		@Override
		public Map<PieBueno, Integer> cuentaPieBueno() {
			// TODO Auto-generated method stub
			throw new NoSuchFieldError();
		}



}