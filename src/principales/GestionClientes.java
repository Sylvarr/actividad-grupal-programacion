package principales;

import java.util.List;
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
				case 2:
					encontrarCliente();
					break;
				case 3:
					encontrarTodos();
					break;
				case 4:
					borrarCliente();
					break;
				case 5:
					System.out.println("Saliendo...");
					activo = false;
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
		System.out.println("3. Listar todos los clientes.");
		System.out.println("4. Eliminar cliente.");
		System.out.println("5. Salir");
	}

	private static void registrarCliente() {
		System.out.println("Menú de registro de clientes.");
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

	private static void encontrarCliente() {

		System.out.println("Buscar cliente. Por favor escribe su cif: ");
		String cif = sc.nextLine();

		Cliente clienteEncontrado = dao.buscarCliente(cif);

		if (clienteEncontrado != null) {
			mostrarDatos(clienteEncontrado);
		} else {
			System.out.println("Cliente no encontrado");
		}

	}

	private static void encontrarTodos() {

		System.out.println("Encontrar todos: ");

		List<Cliente> clientesEncontrados = dao.findAll();

		for (Cliente clienteEncontrado : clientesEncontrados) {
			mostrarDatos(clienteEncontrado);
		}

	}

	private static void borrarCliente() {
		System.out.println("Por favor introduce el cif del cliente que vas a borrar: ");
		String cif = sc.nextLine();
		Cliente clienteEncontrado = dao.buscarCliente(cif);

		if (clienteEncontrado != null) {
			mostrarDatos(clienteEncontrado);
			System.out.println("Quieres borrar este cliente ?");
			System.out.println("1. Si.");
			System.out.println("2. No.");
			int opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
				case 1:
					dao.eliminarCliente(cif);
					System.out.println("Cliente eliminado con éxito.");
					break;
				case 2:
					System.out.println("Cliente no eliminado.");
					break;
				default:
					break;
			}
		} else {
			System.out.println("Cliente no encontrado.");
		}

	}

	public static void mostrarDatos(Cliente cliente) {
		System.out.println("==========================================");
		System.out.println("Datos del cliente encontrado: ");
		System.out.println("Nombre: " + cliente.getNombre());
		System.out.println("Apellidos: " + cliente.getApellidos());
		System.out.println("Domicilio: " + cliente.getDomicilio());
		System.out.println("Facturación anual: " + cliente.getFacturacionAnual());
		System.out.println("Número de empleados: " + cliente.getNumeroEmpleados());
		System.out.println("==========================================");
	}

}
