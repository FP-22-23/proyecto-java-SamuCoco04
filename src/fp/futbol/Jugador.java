package fp.futbol;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import fp.common.Club;
import fp.utiles.Checkers;

public class Jugador implements Comparable<Jugador> {
	@Override
	public int compareTo(Jugador o) {
		int res=this.getEdad().compareTo(o.getEdad());
		return res;
	}

	private String nombre;
	private List<String>posiciones;
	private Integer valoracion;
	private Integer potencial;
	private Double valor;
	private Double sueldo;
	private Integer edad;
	private LocalDate dob;
	private Integer altura;
	private Integer peso;
	private String nacionalidad;
	private PieBueno pieBueno;
	private Boolean cara;
	private Club club;
	
	public Jugador(String nombre,LinkedList<String> posiciones, Integer valoracion, Integer potencial, Double valor,
			Double sueldo, Integer edad, LocalDate dob, Integer altura, Integer peso,Club club, 
			String nacionalidad, String pieBueno, String cara) {
		super();
		this.nombre = nombre;
		this.posiciones=new LinkedList<String>();
		this.valoracion = valoracion;
		Checkers.check("El potencial no puede ser menor que la valoración", valoracion<potencial || valoracion.equals(potencial));
		this.potencial = potencial;
		this.valor = valor;
		this.sueldo = sueldo;
		this.edad = edad;
		Checkers.check("No puede haber nacido despues de la fecha actual", dob.isBefore(LocalDate.now()));
		this.dob = dob;
		this.altura = altura;
		this.peso = peso;
		this.nacionalidad = nacionalidad;
		this.pieBueno = formateaPie(pieBueno);
		this.cara = formateaCara(cara);
		this.club=club;

		
	}
	public void incorporaPosiciones(String posicion) {
		Checkers.check("La posicion ya está", !posiciones.contains(posicion));
		posiciones.add(posicion);
	}
	public Jugador(String nombre, Integer valoracion, Double sueldo) {
		super();
		this.nombre = nombre;
		this.valoracion = valoracion;
		this.sueldo = sueldo;
	}
	public Jugador(String nombre2, List<String> posiciones2, Integer valoracion2, Integer potencial2,
			Double valor2, Double sueldo2, Integer edad2, LocalDate dob2, Integer altura2, Integer peso2, Club club2,String nacionalidad2,
			PieBueno pie, Boolean cara2) {
		super();
		this.nombre = nombre2;
		this.posiciones=posiciones2;
		this.valoracion = valoracion2;
		this.potencial = potencial2;
		Checkers.check("El potencial no puede ser menor que la valoración", valoracion<potencial || valoracion==(potencial));
		this.valor = valor2;
		this.sueldo = sueldo2;
		this.edad = edad2;
		this.dob = dob2;
		Checkers.check("No puede haber nacido despues de la fecha actual", dob.isBefore(LocalDate.now()));
		this.altura = altura2;
		this.peso = peso2;
		this.nacionalidad = nacionalidad2;
		this.pieBueno = (pie);
		this.cara = (cara2);
		this.club=club2;
	}
	public Double IMC() {
		Double alt=(double) altura/100;
		Double pe=(double) peso;
		Double IMC=(pe/(alt*alt));
		return IMC;
	}
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", posiciones=" + posiciones + ", valoracion=" + valoracion
				+ ", potencial=" + potencial + ", valor=" + valor + ", sueldo=" + sueldo + ", edad=" + edad + ", dob="
				+ dob + ", altura=" + altura + ", peso=" + peso + ", nacionalidad=" + nacionalidad + ", pieBueno="
				+ pieBueno + ", cara=" + cara + ", club=" + club + "]";
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(edad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(edad, other.edad);
	}
	
	public Boolean formateaCara(String cara) {
		Boolean res=true;
		switch(cara) {
		case "No":
			res=false;
			break;
		}
		return res;
			
	}
	public PieBueno formateaPie(String pieBueno) {
		PieBueno res=PieBueno.Left;
		switch(pieBueno) {
		case "Right":
		res=PieBueno.Right;
		break;
		}
		return res;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(LinkedList<String> posiciones) {
		this.posiciones = posiciones;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public Integer getPotencial() {
		return potencial;
	}

	public void setPotencial(Integer potencial) {
		this.potencial = potencial;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public LocalDate getDob() {
		return dob;
	}

	public Integer getAltura() {
		return altura;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public PieBueno getPieBueno() {
		return pieBueno;
	}

	public Boolean getCara() {
		return cara;
	}

	public void setCara(Boolean cara) {
		this.cara = cara;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
}
