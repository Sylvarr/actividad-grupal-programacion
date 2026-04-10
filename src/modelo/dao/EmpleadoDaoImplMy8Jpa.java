package modelo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import modelo.entities.Empleado;

public class EmpleadoDaoImplMy8Jpa implements EmpleadoDao {

	@Override
	public void crearEmpleado(Empleado empleado) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(empleado);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public Empleado buscarEmpleado(int idEmpl) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			return em.find(Empleado.class, idEmpl);
		} finally {
			em.close();
		}
	}

	@Override
	public List<Empleado> findAll() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			return em.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public boolean eliminarEmpleado(int idEmpl) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Empleado emp = em.find(Empleado.class, idEmpl);
			if (emp != null) {
				em.remove(emp);
				tx.commit();
				return true;
			}
			tx.rollback();
			return false;
		} catch (Exception e) {
			if (tx.isActive()) tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			TypedQuery<Empleado> query = em.createQuery(
					"SELECT e FROM Empleado e WHERE e.departamento.idDepar = :idDepar", Empleado.class);
			query.setParameter("idDepar", idDepar);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Empleado> empleadosByGenero(char sexo) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			TypedQuery<Empleado> query = em.createQuery(
					"SELECT e FROM Empleado e WHERE e.genero = :sexo", Empleado.class);
			query.setParameter("sexo", sexo);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			TypedQuery<Empleado> query = em.createQuery(
					"SELECT e FROM Empleado e WHERE e.apellidos LIKE :subcadena", Empleado.class);
			query.setParameter("subcadena", "%" + subcadena + "%");
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public double salarioTotal() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Double total = em.createQuery("SELECT SUM(e.salario) FROM Empleado e", Double.class).getSingleResult();
			return total != null ? total : 0.0;
		} finally {
			em.close();
		}
	}

	@Override
	public double salarioTotal(int idDepar) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			TypedQuery<Double> query = em.createQuery(
					"SELECT SUM(e.salario) FROM Empleado e WHERE e.departamento.idDepar = :idDepar", Double.class);
			query.setParameter("idDepar", idDepar);
			Double total = query.getSingleResult();
			return total != null ? total : 0.0;
		} finally {
			em.close();
		}
	}

}
