package modelo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import modelo.entities.Perfil;

public class PerfilDaoImplMy8Jpa implements PerfilDao {

	@Override
	public void crearPerfil(Perfil perfil) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(perfil);
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public Perfil buscarPerfil(int idPerfil) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			return em.find(Perfil.class, idPerfil);
		} finally {
			em.close();
		}
	}

	@Override
	public List<Perfil> findAll() {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			return em.createQuery("SELECT p FROM Perfil p", Perfil.class).getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public boolean eliminarPerfil(int idPerfil) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Perfil perfil = em.find(Perfil.class, idPerfil);
			if (perfil != null) {
				em.remove(perfil);
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
