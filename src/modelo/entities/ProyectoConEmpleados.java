package modelo.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="proyecto_con_empleados")
public class ProyectoConEmpleados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numero_orden")
	private int numeroOrden;
	@Column(name="id_proyecto")
	private String idProyecto;
	@Column(name="id_empl")
	private int idEmpl;
	@Column(name="horas_asignadas")
	private int horasAsignadas;
	@Column(name="fecha_incorporacion")
	private LocalDate fechaIncorporacion;
	
	
	public ProyectoConEmpleados(){	
	}
	


	ProyectoConEmpleados(int numeroOrden, String idProyecto, int idEmpl, int horasAsignadas,
			LocalDate fechaIncorporacion) {
		super();
		this.numeroOrden = numeroOrden;
		this.idProyecto = idProyecto;
		this.idEmpl = idEmpl;
		this.horasAsignadas = horasAsignadas;
		this.fechaIncorporacion = fechaIncorporacion;
	}



	public int getNumeroOrden() {
		return numeroOrden;
	}


	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}


	public String getIdProyecto() {
		return idProyecto;
	}


	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}


	public int getIdEmpl() {
		return idEmpl;
	}


	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}


	public int getHorasAsignadas() {
		return horasAsignadas;
	}


	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}


	public LocalDate getFechaIncorporacion() {
		return fechaIncorporacion;
	}


	public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numeroOrden);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProyectoConEmpleados))
			return false;
		ProyectoConEmpleados other = (ProyectoConEmpleados) obj;
		return numeroOrden == other.numeroOrden;
	}


	@Override
	public String toString() {
		return "ProyectoConEmpleados [numeroOrden=" + numeroOrden + ", idProyecto=" + idProyecto + ", idEmpl=" + idEmpl
				+ ", horasAsignadas=" + horasAsignadas + ", fechaIncorporacion=" + fechaIncorporacion + "]";
	}
	
	public double costeHorasAsignadas() {
		return 0;
	}
}
