package test.daos;

import java.util.List;

import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.dao.DepartamentoDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.dao.PerfilDao;
import modelo.entities.Departamento;
import modelo.entities.Empleado;
import modelo.entities.Perfil;

public class TestEmpleadoDao {

	public static void main(String[] args) {

		EmpleadoDao empleadoDao = new EmpleadoDaoImplMy8Jpa();
		DepartamentoDao departamentoDao = new DepartamentoDaoImplMy8Jpa();
		PerfilDao perfilDao = new PerfilDaoImplMy8Jpa();

		// TEST DEPARTAMENTO
		System.out.println("TEST DEPARTAMENTO DAO");
		List<Departamento> departamentos = departamentoDao.findAll();
		departamentos.forEach(System.out::println);

		Departamento dep = departamentoDao.buscarDepartamento(20);
		System.out.println("Departamento 20: " + dep);
		System.out.println();

		// TEST PERFIL
		System.out.println("TEST PERFIL DAO");
		List<Perfil> perfiles = perfilDao.findAll();
		perfiles.forEach(System.out::println);
		System.out.println();

		// TEST EMPLEADO
		System.out.println("=== TEST EMPLEADO DAO - findAll ===");
		List<Empleado> todos = empleadoDao.findAll();
		todos.forEach(e -> System.out.println(e.nombreCompleto() + " - " + e.getDepartamento().getNombre()));
		System.out.println();

		// TEST empleadosByDepartamento
		System.out.println("empleadosByDepartamento(20) - Software");
		List<Empleado> empsDep20 = empleadoDao.empleadosByDepartamento(20);
		empsDep20.forEach(e -> System.out.println("  " + e.nombreCompleto()));
		System.out.println();

		// TEST empleadosByGenero
		System.out.println("empleadosByGenero('M') - Mujeres");
		List<Empleado> mujeres = empleadoDao.empleadosByGenero('M');
		mujeres.forEach(e -> System.out.println("  " + e.nombreCompleto() + " - " + e.literalGenero()));
		System.out.println();

		// TEST empleadosByApellido
		System.out.println("empleadosByApellido('ol')");
		List<Empleado> empsApellido = empleadoDao.empleadosByApellido("ol");
		empsApellido.forEach(e -> System.out.println("  " + e.nombreCompleto()));
		System.out.println();

		// TEST salarioTotal
		System.out.println("salarioTotal() - todos");
		double totalGeneral = empleadoDao.salarioTotal();
		System.out.println("Salario total de todos: " + totalGeneral);
		System.out.println();

		//  TEST salarioTotal por departamento 
		System.out.println(" salarioTotal(20) - Software");
		double totalDep20 = empleadoDao.salarioTotal(20);
		System.out.println("Salario total dep 20: " + totalDep20);
		System.out.println();

		System.out.println(" TODOS LOS TESTS OK ");
	}

}
