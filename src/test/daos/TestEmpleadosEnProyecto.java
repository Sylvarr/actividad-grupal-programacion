package test.daos;

import modelo.dao.EmpleadosEnProyectoDao;
import modelo.dao.EmpleadosEnProyectoDaoImplMy8Jpa;

public class TestEmpleadosEnProyecto {

	private static EmpleadosEnProyectoDao epdao;
	
	static {
		epdao= new EmpleadosEnProyectoDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
		uno();
	}
	
	public static void uno() {
		System.out.println(epdao.buscarProyectoConEmpleados(1));
	}
}
