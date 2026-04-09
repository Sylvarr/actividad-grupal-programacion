package modelo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamentos")
public class Departamento {

	@Id
	@Column(name = "id_depar")
	private int idDepar;
	private String nombre;
	private String direccion;

	public Departamento() {
	}

	public Departamento(int idDepar, String nombre, String direccion) {
		this.idDepar = idDepar;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public int getIdDepar() {
		return idDepar;
	}

	public void setIdDepar(int idDepar) {
		this.idDepar = idDepar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDepar;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (idDepar != other.idDepar)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Departamento [idDepar=" + idDepar + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

}
