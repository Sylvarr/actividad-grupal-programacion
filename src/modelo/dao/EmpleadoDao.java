package modelo.dao;

import java.util.List;

import modelo.entities.Empleado;

public interface EmpleadoDao {

	void crearEmpleado(Empleado empleado);

	Empleado buscarEmpleado(int idEmpl);

	List<Empleado> findAll();

	boolean eliminarEmpleado(int idEmpl);

	// Métodos extra
	List<Empleado> empleadosByDepartamento(int idDepar);

	List<Empleado> empleadosByGenero(char sexo);

	List<Empleado> empleadosByApellido(String subcadena);

	double salarioTotal();

	double salarioTotal(int idDepar);

}
