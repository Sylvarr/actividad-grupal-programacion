package modelo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import modelo.entities.ProyectoConEmpleados;

public class EmpleadosEnProyectoDaoImplMy8Jpa implements EmpleadosEnProyectoDao{

	private EntityManager em = JpaUtil.getEntityManager();
	
	@Override
	public void crearProyectoConEmpleados(ProyectoConEmpleados proyectoConEmpleados) {
		try {
			em.getTransaction().begin();
			em.persist(proyectoConEmpleados);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error en crearProyectoConEmpleados: " + e.getMessage() );
		}
		
	}

	@Override
	public ProyectoConEmpleados buscarProyectoConEmpleados(int numeroOrden) {		// TODO Auto-generated method stub
		return em.find(ProyectoConEmpleados.class, numeroOrden);
	}

	@Override
	public void actualizarProyectoConEmpleados(ProyectoConEmpleados proyectoConEmpleados) {
		try {
			em.getTransaction().begin();
			em.merge(proyectoConEmpleados);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error con actualizarProyectoConEmpleados: " + e.getMessage());
		}
		
	}

	@Override
	public boolean eliminarProyectoConEmpleados(int numeroOrden) {
		ProyectoConEmpleados proyectoConEmpleados = em.find(ProyectoConEmpleados.class, numeroOrden);
		if(proyectoConEmpleados != null) {
			try {
				em.getTransaction().begin();
				em.remove(proyectoConEmpleados);
				em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				System.out.println("Error con eliminarProyectoConEmpleados: " + e.getMessage());
				return false;
			}
		}
		return false;
	}

	@Override
	public List<ProyectoConEmpleados> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> empleadosByProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleados> empleados) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double costeActualDeEmpleadosEnProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
