package modelo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import modelo.entities.Departamento;

public class DepartamentoDaoImplMy8Jpa implements DepartamentoDao {

	@Override
	public void crearDepartamento(Departamento departamento) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(departamento);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public Departamento buscarDepartamento(int idDepar) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			return em.find(Departamento.class, idDepar);
		} finally {
			em.close();
		}
	}

	@Override
	public List<Departamento> findAll() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			return em.createQuery("SELECT d FROM Departamento d", Departamento.class).getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public boolean eliminarDepartamento(int idDepar) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Departamento dep = em.find(Departamento.class, idDepar);
			if (dep != null) {
				em.remove(dep);
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

}
