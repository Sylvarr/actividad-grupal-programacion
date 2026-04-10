package modelo.dao;

import java.util.List;

import modelo.entities.Empleado;
import modelo.entities.ProyectoConEmpleados;

public interface EmpleadosEnProyectoDao {
	
	void crearProyectoConEmpleados(ProyectoConEmpleados proyectoConEmpleados);
	
	ProyectoConEmpleados buscarProyectoConEmpleados(int numeroOrden);
	
	void actualizarProyectoConEmpleados(ProyectoConEmpleados proyectoConEmpleados);
	
	boolean eliminarProyectoConEmpleados(int numeroOrden);
	
	List<ProyectoConEmpleados> findAll();
	
	List<Empleado> empleadosByProyecto(String codigoProyecto);
	
	int asignarEmpleadosAProyecto(List<ProyectoConEmpleados>empleados);
	
	int horasAsignadasAProyecto(String codigoProyecto);
	
	double costeActualDeEmpleadosEnProyecto(String codigoProyecto);

}
