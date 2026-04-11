package modelo.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empl")
	private int idEmpl;
	private String nombre;
	private String apellidos;
	private char genero;
	private String email;
	private String password;
	private double salario;
	@Column(name = "fecha_ingreso")
	private LocalDate fechaIngreso;
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;

	@ManyToOne
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;

	@ManyToOne
	@JoinColumn(name = "id_depar")
	private Departamento departamento;

	public Empleado() {
	}

	public Empleado(String nombre, String apellidos, char genero, String email, String password,
			double salario, LocalDate fechaIngreso, LocalDate fechaNacimiento, Perfil perfil,
			Departamento departamento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.email = email;
		this.password = password;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.perfil = perfil;
		this.departamento = departamento;
	}

	//MÉTODOS PROPIOS

	/**
	 * Calcula el salario mensual dividiendo el salario anual entre el número de
	 * meses.
	 */
	public double salarioMensual(int meses) {
		return salario / meses;
	}

	/**
	 * Devuelve "Hombre" si el género es H/h, "Mujer" si es M/m
	 */
	public String literalGenero() {
		return (genero == 'H' || genero == 'h') ? "Hombre" : "Mujer";
	}

	/**
	 * Devuelve el nombre completo: nombre + " " + apellidos
	 */
	public String nombreCompleto() {
		return nombre + " " + apellidos;
	}

	//GETTERS Y SETTERS

	public int getIdEmpl() {
		return idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmpl;
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
		Empleado other = (Empleado) obj;
		if (idEmpl != other.idEmpl)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpl=" + idEmpl + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero=" + genero
				+ ", email=" + email + ", salario=" + salario + ", fechaIngreso=" + fechaIngreso
				+ ", fechaNacimiento=" + fechaNacimiento + ", perfil=" + perfil + ", departamento=" + departamento + "]";
	}

}
