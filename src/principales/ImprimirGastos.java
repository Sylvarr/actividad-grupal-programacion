package principales;

import java.util.List;

import jakarta.persistence.EntityManager;
import modelo.dao.EmpleadosEnProyectoDao;
import modelo.dao.EmpleadosEnProyectoDaoImplMy8Jpa;
import modelo.dao.JpaUtil;
import modelo.dao.ProyectoConProductosDao;
import modelo.dao.ProyectoConProductosDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entities.Proyecto;
import modelo.entities.ProyectoConEmpleados;
import modelo.entities.ProyectoConProductos;

public class ImprimirGastos {
	
	private static ProyectoDaoImplMy8Jpa pdao;		
	private static EmpleadosEnProyectoDao epdao;
	private static ProyectoConProductosDao ppdao;

	static {
		pdao = new ProyectoDaoImplMy8Jpa();
		epdao=new EmpleadosEnProyectoDaoImplMy8Jpa();	
		ppdao=new ProyectoConProductosDaoImplMy8Jpa();	
	}

	public static void main(String[] args) {
		Proyecto proyecto=pdao.proyectosByEstado("Terminado").get(0);
		imprimirInforme(proyecto);

	}
	public static void actualizarCosteReal(Proyecto proyecto) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(proyecto);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println("Error con actualizarCosteReal:  " + e.getMessage());
		} finally {
			em.close();
		}
	}
	public static void imprimirInforme(Proyecto proyecto) {
		System.out.println("Datos del CLIENTE");
		System.out.println("Nombre : " + proyecto.getCliente().getNombre() + " Dirección : " + proyecto.getCliente().getDomicilio());
		System.out.println("Datos del PROYECTO");
		System.out.println("Código Proyecto : " + proyecto.getIdProyecto());
		System.out.println("Descripción Proyecto : " + proyecto.getDescripcion());
		System.out.println("Fecha Inicio : " + proyecto.getFechaInicio() + " Fecha Fin real : " + proyecto.getFechaFinReal());
	
		System.out.println("DETALLE DE RECURSOS EMPLEADOS:");
		System.out.println("LISTA EMPLEADOS");
		
		List<ProyectoConEmpleados> asignados = epdao.findAll();
		for (ProyectoConEmpleados pce : asignados) {
			if(pce.getProyecto().getIdProyecto().equals(proyecto.getIdProyecto())){
				System.out.println("Apellidos, nombre : " + pce.getEmpleado().getApellidos() + ", " + pce.getEmpleado().getNombre() + 
						" Horas(total) : " + pce.getHorasAsignadas() + " Importe repercutido : " + pce.costeHorasAsignadas());
			}
		}
		
		System.out.println("Total Horas : " + epdao.horasAsignadasAProyecto(proyecto.getIdProyecto()));	
		System.out.println("Total Precio : " + epdao.costeActualDeEmpleadosEnProyecto(proyecto.getIdProyecto()));
		
		List<ProyectoConProductos> productos = ppdao.productosByProyecto(proyecto.getIdProyecto());
		double totalImportes = 0; 
		for(ProyectoConProductos pcp: productos) {
			double total = pcp.getCantidad() * pcp.getPrecioAsignado();
			totalImportes = totalImportes + total;
			System.out.println("Descripción : " + pcp.getProducto().getDescripcion() + " Cantidad : " + pcp.getCantidad() +
					" Precio por uno : " + pcp.getPrecioAsignado() + " Total : " + total);
		}
		System.out.println("Total Importes: " + totalImportes);
	
		System.out.println("DETALLE DEL IMPORTE:");
		System.out.println("Importe Venta : " + proyecto.getVentaPrevisto());
		System.out.println("Total Gastado : " + (epdao.costeActualDeEmpleadosEnProyecto(proyecto.getIdProyecto())+ totalImportes));
	
		proyecto.setCosteReal(epdao.costeActualDeEmpleadosEnProyecto(proyecto.getIdProyecto())+ totalImportes);
		actualizarCosteReal(proyecto);
		System.out.println("Coste Real: " + proyecto.getCosteReal());
	}
}
