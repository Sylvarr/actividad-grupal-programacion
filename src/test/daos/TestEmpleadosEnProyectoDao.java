package test.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.EmpleadosEnProyectoDao;
import modelo.dao.EmpleadosEnProyectoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entities.Empleado;
import modelo.entities.ProyectoConEmpleados;


public class TestEmpleadosEnProyectoDao {

	private static EmpleadosEnProyectoDao epdao;
	private static EmpleadoDao edao;
	private static ProyectoDao pdao;
	
	static {
		epdao= new EmpleadosEnProyectoDaoImplMy8Jpa();
		edao= new EmpleadoDaoImplMy8Jpa();
		pdao= new ProyectoDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
		uno(); //buscarProyectoConEmpleados
		todos();//findAll
		alta();//crearProyectoConEmpleados
		modificar();//actualizarProyectoConEmpleados
		eliminar();//eliminarProyectoConEmpleados
		asignarEmpleados();//asignarEmpleadosAProyecto
		horasAsignadas();//horasAsignadasAProyecto
		empleadosPorProyecto();//empleadosbyProyecto
		costeDeLosEmpleadosActualmente();//costeActualDeEmpleadosEnProyecto
		
	}
	
	public static void uno() {
		System.out.println(epdao.buscarProyectoConEmpleados(1));
	}
	
	public static void todos() {
		for(ProyectoConEmpleados pce: epdao.findAll())
			System.out.println(pce);
	}
	
	public static void alta() {
		ProyectoConEmpleados pce = new ProyectoConEmpleados();
		pce.setEmpleado(edao.buscarEmpleado(119));
		pce.setProyecto(pdao.buscarProyecto("FOR2020001"));
		pce.setHorasAsignadas(58);
		pce.setFechaIncorporacion(LocalDate.of(2026, 04, 9));
		epdao.crearProyectoConEmpleados(pce);
		System.out.println("Empleado asignado a proyecto");
	
	}
	public static void modificar() {
		ProyectoConEmpleados pce = epdao.buscarProyectoConEmpleados(7);
		pce.setHorasAsignadas(95);
		epdao.actualizarProyectoConEmpleados(pce);
		System.out.println("Horas modificadas");
	}
	public static void eliminar() {
		boolean eliminado = epdao.eliminarProyectoConEmpleados(5);
		System.out.println(eliminado);
	}
	
	public static void asignarEmpleados(){
		List<ProyectoConEmpleados> lista= new ArrayList<>();
		
		ProyectoConEmpleados pce1 = new ProyectoConEmpleados();
		pce1.setEmpleado(edao.buscarEmpleado(119));
		pce1.setProyecto(pdao.buscarProyecto("FOR2020001"));
		pce1.setHorasAsignadas(25);
		pce1.setFechaIncorporacion(LocalDate.of(2026, 03, 28));
		
		ProyectoConEmpleados pce2 = new ProyectoConEmpleados();
		pce2.setEmpleado(edao.buscarEmpleado(120));
		pce2.setProyecto(pdao.buscarProyecto("FOR2021001"));
		pce2.setHorasAsignadas(79);
		pce2.setFechaIncorporacion(LocalDate.of(2026, 01, 8));
		
		lista.add(pce1);
		lista.add(pce2);
		
		System.out.println(epdao.asignarEmpleadosAProyecto(lista)); 
	}
	
	public static void horasAsignadas() {
		System.out.println(epdao.horasAsignadasAProyecto("FOR2021001"));
	}
	
	public static void empleadosPorProyecto() {
		List<Empleado> empleados = epdao.empleadosByProyecto("FOR2021001");
		for(Empleado emp : empleados) {
			System.out.println(emp);
		}
	}
	
	public static void costeDeLosEmpleadosActualmente() {
		System.out.println(epdao.costeActualDeEmpleadosEnProyecto("FOR2021001"));
	}
}
