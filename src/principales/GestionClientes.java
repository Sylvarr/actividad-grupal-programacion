package principales;

import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entities.Cliente;

public class GestionClientes {

	private static Scanner sc = new Scanner(System.in);
	private static ClienteDao dao = new ClienteDaoImplMy8Jpa();

	public static void main(String[] args) {

		boolean activo = true;

		do {

			mostrarMenu();

			int opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
				case 1:
					registrarCliente();
					break;

				default:
					break;
			}

		} while (activo);

	}

	private static void mostrarMenu() {
		System.out.println("Por favor elige una opción: ");
		System.out.println("1. Crear cliente.");
		System.out.println("2. Buscar cliente.");
		System.out.println("3. Alistar todos los clientes.");
		System.out.println("4. Eliminar cliente.");
	}

	private static void registrarCliente() {
		System.out.println("Estás en el menú de registro de clientes.");
		System.out.println("Introduce el cif: ");
		String cif = sc.nextLine();
		System.out.println("Introduce el nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Introduce los apellidos: ");
		String apellidos = sc.nextLine();
		System.out.println("Introduce el domicilio: ");
		String domicilio = sc.nextLine();
		System.out.println("Introduce su facturación anual: ");
		double facturacion = sc.nextDouble();
		sc.nextLine();
		System.out.println("Introduce el número de empleados: ");
		int empleados = sc.nextInt();
		sc.nextLine();
		Cliente cliente = new Cliente(cif, nombre, apellidos, domicilio, facturacion, empleados);
		System.out.println("Cliente creado correctamente.");
		dao.crearCliente(cliente);
	}

}
