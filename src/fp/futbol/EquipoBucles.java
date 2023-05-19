package fp.futbol;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EquipoBucles implements Equipo {
	private List<Jugador> jugadores;
	private Liga liga;
	private Boolean ucl;
	private Integer posicionLiga;
	
	public EquipoBucles(Liga liga,Boolean ucl,Integer posicionLiga) {
		this.jugadores=new LinkedList<Jugador>();
		this.liga=liga;
		this.ucl=ucl;
		this.posicionLiga=posicionLiga;
	}
	public EquipoBucles(List<Jugador> jugador,Liga liga,Boolean ucl,Integer posicionLiga) {
		this.jugadores=jugador;
		this.liga=liga;
		this.ucl=ucl;
		this.posicionLiga=posicionLiga;
	}
	public EquipoBucles(List<Jugador> jugador) {
		this.jugadores=new LinkedList<Jugador>();
	}
	public EquipoBucles(Stream<Jugador> jugador,Liga liga,Boolean ucl,Integer posicionLiga) {
		this.jugadores=jugador.collect(Collectors.toList());
		this.liga=liga;
		this.ucl=ucl;
		this.posicionLiga=posicionLiga;
	}
	public EquipoBucles(Stream<Jugador> jugador) {
		this.jugadores=jugador.collect(Collectors.toList());
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public Liga getLiga() {
		return liga;
	}
	public Boolean getUcl() {
		return ucl;
	}
	public Integer getPosicionLiga() {
		return posicionLiga;
	}
	@Override
	public String toString() {
		return "Equipo [jugador=" + jugadores + ", liga=" + liga + ", ucl=" + ucl + ", posicionLiga=" + posicionLiga
				+ "]";
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
		EquipoBucles other = (EquipoBucles) obj;
		return Objects.equals(jugadores, other.jugadores) && liga == other.liga && Objects.equals(ucl, other.ucl);
	}
	
	public Integer getNumeroJugadores() {
		return jugadores.size();
	}
	public void incorporaElemento(Jugador jugador) {
		if (!jugadores.contains(jugador))
			jugadores.add(jugador);
	}
	public void incorpora(List<Jugador> nuevosJugadores) {
        for (Jugador e: nuevosJugadores) {
            jugadores.add(e);
        }
	}
        public void quitaElemento(Jugador jugador) {
    		if (jugadores.contains(jugador))
    			jugadores.remove(jugador);
      
    }
        public Boolean existeJugadorConEdad(Integer edad) {
        	Boolean res=false;
        	for (Jugador e: jugadores) {
        		if (e.getEdad().equals(edad))
        			res=true;
        	}
        	return res;
        }
        public Double mediaEdad(){
        	Double res=0.0;
        	for (Jugador e: jugadores) {
        		res=res+e.getEdad();
  }
        	return res/jugadores.size();
        }
        public List<Jugador> filtraPieBueno(PieBueno pie){
        	List<Jugador> res=new LinkedList<Jugador>();
        	for (Jugador e: jugadores) {
        		if (e.getPieBueno().equals(pie))
        			res.add(e);
        	
        }
        	return res;
}
        public Map<PieBueno,List<Jugador>> agrupaPieBueno() {
        	Map<PieBueno,List<Jugador>> res=new HashMap<PieBueno,List<Jugador>>();
        	for (Jugador e:jugadores) {
        		if (!res.containsKey(e.getPieBueno()))
        			res.put(e.getPieBueno(), filtraPieBueno(e.getPieBueno()));
        	}
        	return res;
        }
        public Map<PieBueno,Integer> cuentaPieBueno() {
        	Map<PieBueno,Integer> res=new HashMap<PieBueno,Integer>();
        	for (Jugador e:jugadores) {
        		if (!res.containsKey(e.getPieBueno()))
        			res.put(e.getPieBueno(), filtraPieBueno(e.getPieBueno()).size());
}
        	return res;
        }
		@Override
		public Jugador maxalturadeEquipo(String Equipo) {
			throw new NoSuchFieldError();
		}
		@Override
		public List<Jugador> ordenaEquipo(String Equipo) {
			throw new NoSuchFieldError();
		}
		@Override
		public Map<String, List<String>> mapJuagdoresClubes() {
			throw new NoSuchFieldError();
		}
		@Override
		public Map<String, Integer> edadMasAltaPorClub() {
			throw new NoSuchFieldError();
		}
		@Override
		public SortedMap<PieBueno, List<Jugador>> masAltosSegunPierna(Integer n) {
			throw new NoSuchFieldError();
		}
		@Override
		public String getEquipoConMenorSueldo() {
			throw new NoSuchFieldError();
		}
}
