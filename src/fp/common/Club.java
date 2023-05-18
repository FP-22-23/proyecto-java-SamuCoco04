package fp.common;

import java.util.Objects;

public record Club(String equipo,Integer titulos,Integer socios) {
	public String getCadenaFormato() {
		return "El club es el"+equipo+"con"+titulos+"titulos ganados y"+socios+"socios";
	}
	public String toString() {
		return "Club[getEquipo()="+equipo+",getTitulos()="+titulos()+",getSocios()="+socios()+"]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(equipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Club other = (Club) obj;
		return Objects.equals(equipo, other.equipo);
	}
	public String getEquipo() {
		return equipo;
	}
	public Integer getTitulos() {
		return titulos;
	}
	public Integer getSocios() {
		return socios;
	}
	

}
