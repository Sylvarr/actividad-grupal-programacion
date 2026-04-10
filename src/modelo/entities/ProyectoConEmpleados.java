package modelo.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="proyecto_con_empleados")
public class ProyectoConEmpleados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numero_orden")
	private int numeroOrden;
	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;
	@ManyToOne
	@JoinColumn(name="id_empl")
	private Empleado empleado;
	@Column(name="horas_asignadas")
	private int horasAsignadas;
	@Column(name="fecha_incorporacion")
	private LocalDate fechaIncorporacion;
	
	
	public ProyectoConEmpleados(){	
	}
	
	ProyectoConEmpleados(int numeroOrden, Proyecto proyecto, Empleado empleado, int horasAsignadas,
			LocalDate fechaIncorporacion) {
		super();
		this.numeroOrden = numeroOrden;
		this.proyecto = proyecto;
		this.empleado = empleado;
		this.horasAsignadas = horasAsignadas;
		this.fechaIncorporacion = fechaIncorporacion;
	}
	

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
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
		return "ProyectoConEmpleados [numeroOrden=" + numeroOrden + ", proyecto=" + proyecto + ", empleado=" + empleado
				+ ", horasAsignadas=" + horasAsignadas + ", fechaIncorporacion=" + fechaIncorporacion + "]";
	}

	public double costeHorasAsignadas() {
		return horasAsignadas * empleado.getPerfil().getTasaStandard();
	}
}
