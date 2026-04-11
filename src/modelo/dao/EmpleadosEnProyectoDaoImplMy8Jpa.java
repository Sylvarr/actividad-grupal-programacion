package modelo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import modelo.entities.Empleado;
import modelo.entities.ProyectoConEmpleados;

public class EmpleadosEnProyectoDaoImplMy8Jpa implements EmpleadosEnProyectoDao {

	@Override
	public void crearProyectoConEmpleados(ProyectoConEmpleados proyectoConEmpleados) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(proyectoConEmpleados);
			em.getTransaction().commit();

		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println("Error en crearProyectoConEmpleados: " + e.getMessage());
		} finally {
			em.close();
		}
	}

	@Override
	public ProyectoConEmpleados buscarProyectoConEmpleados(int numeroOrden) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			return em.find(ProyectoConEmpleados.class, numeroOrden);
		} finally {
			em.close();
		}
	}

	@Override
	public void actualizarProyectoConEmpleados(ProyectoConEmpleados proyectoConEmpleados) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(proyectoConEmpleados);
			em.getTransaction().commit();

		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println("Error con actualizarProyectoConEmpleados: " + e.getMessage());
		} finally {
			em.close();
		}
	}

	@Override
	public boolean eliminarProyectoConEmpleados(int numeroOrden) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			ProyectoConEmpleados proyectoConEmpleados = em.find(ProyectoConEmpleados.class, numeroOrden);
			if (proyectoConEmpleados != null) {
				em.getTransaction().begin();
				em.remove(proyectoConEmpleados);
				em.getTransaction().commit();
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println("Error con eliminarProyectoConEmpleados: " + e.getMessage());
			return false;
		} finally {
			em.close();
		}
	}

	@Override
	public List<ProyectoConEmpleados> findAll() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			String jpql = "from ProyectoConEmpleados p";
			TypedQuery<ProyectoConEmpleados> query = em.createQuery(jpql, ProyectoConEmpleados.class);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Empleado> empleadosByProyecto(String codigoProyecto) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			String jpql = "SELECT p.empleado FROM ProyectoConEmpleados p WHERE p.proyecto.idProyecto = :codigoP";
			TypedQuery<Empleado> query = em.createQuery(jpql, Empleado.class);
			query.setParameter("codigoP", codigoProyecto);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleados> empleados) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			for (ProyectoConEmpleados proyecto : empleados) {
				em.persist(proyecto);
			}
			em.getTransaction().commit();
			return empleados.size();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			System.out.println("Error con asignarEmpleadosAProyecto: " + e.getMessage());
			return 0;
		} finally {
			em.close();
		}
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			String jpql = "Select SUM(p.horasAsignadas) from ProyectoConEmpleados p where p.proyecto.idProyecto = :codigoP";
			TypedQuery<Number> query = em.createQuery(jpql, Number.class);
			query.setParameter("codigoP", codigoProyecto);
			Number resultado = query.getSingleResult();
			if (resultado == null)
				return 0;
			return resultado.intValue();
		} finally {
			em.close();
		}
	}

	@Override
	public double costeActualDeEmpleadosEnProyecto(String codigoProyecto) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			String jpql = "Select SUM(p.horasAsignadas * p.empleado.perfil.tasaStandard) from ProyectoConEmpleados p where p.proyecto.idProyecto = :codigoP";
			TypedQuery<Number> query = em.createQuery(jpql, Number.class);
			query.setParameter("codigoP", codigoProyecto);
			Number resultado = query.getSingleResult();
			if (resultado == null)
				return 0;
			return resultado.doubleValue();
		} finally {
			em.close();
		}
	}

}
