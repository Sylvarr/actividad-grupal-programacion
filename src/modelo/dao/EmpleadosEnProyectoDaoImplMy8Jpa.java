package modelo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import modelo.entities.ProyectoConEmpleados;

public class EmpleadosEnProyectoDaoImplMy8Jpa implements EmpleadosEnProyectoDao{

	private EntityManager em = JpaUtil.getEntityManager();
	private String jpql;
	private Query query; 
	
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
		String jpql = "from ProyectoConEmpleados p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Empleado> empleadosByProyecto(String codigoProyecto) {
		String jpql= "Select e from Empleado e inner join ProyectoConEmpleados p on e.idEmpl = p.idEmpl where p.idProyecto = :codigoP";
		query = em.createQuery(jpql);
		query.setParameter("codigoP", codigoProyecto);
		return query.getResultList();
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleados> empleados) {
		try {
			em.getTransaction().begin();
			for(ProyectoConEmpleados proyecto : empleados)
			em.persist(proyecto);
			em.getTransaction().commit();
			return empleados.size();
		} catch (Exception e) {
			System.out.println("Error con asignarEmpleadosAProyecto: " + e.getMessage());
			return 0;
		}
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		String jpql= "Select SUM(p.horasAsignadas) from ProyectoConEmpleados p where p.idProyecto = :codigoP";
		query = em.createQuery(jpql);
		query.setParameter("codigoP", codigoProyecto);
		return 0;		
	}

	@Override
	public double costeActualDeEmpleadosEnProyecto(String codigoProyecto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
