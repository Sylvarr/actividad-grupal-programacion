package test.entities;

import modelo.dao.EmpleadosEnProyectoDao;
import modelo.dao.EmpleadosEnProyectoDaoImplMy8Jpa;
import modelo.entities.ProyectoConEmpleados;

public class TestProyectoConEmpleados {
	
	
		
	private static EmpleadosEnProyectoDao epdao;		
		
	static {
			epdao= new EmpleadosEnProyectoDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
		costeHora();
	}
	public static void costeHora() {
		ProyectoConEmpleados pce = epdao.buscarProyectoConEmpleados(3);
		System.out.println(pce.costeHorasAsignadas());
	}
	

}
