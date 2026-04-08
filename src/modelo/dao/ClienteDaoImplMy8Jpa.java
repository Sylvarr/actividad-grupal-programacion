package modelo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import modelo.entities.Cliente;

public class ClienteDaoImplMy8Jpa implements ClienteDao {

  @Override
  public void crearCliente(Cliente cliente) {

    EntityManager em = JpaUtil.getEntityManager();

    try {

      em.getTransaction().begin();
      em.persist(cliente);
      em.getTransaction().commit();

    } catch (Exception e) {

      if (em.getTransaction().isActive()) {

        em.getTransaction().rollback();

      }

      e.printStackTrace();

    } finally {

      em.close();

    }

  }

  @Override
  public Cliente buscarCliente(String cif) {
    EntityManager em = JpaUtil.getEntityManager();

    try {

      return em.find(Cliente.class, cif);

    } finally {

      em.close();

    }

  }

  @Override
  public List<Cliente> findAll() {

    EntityManager em = JpaUtil.getEntityManager();

    try {

      List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();

      return clientes;

    } finally {

      em.close();

    }

  }

  @Override
  public boolean eliminarCliente(String cif) {

    EntityManager em = JpaUtil.getEntityManager();

    try {

      em.getTransaction().begin();
      Cliente cliente = em.find(Cliente.class, cif);
      if (cliente == null) {
        em.getTransaction().rollback();
        return false;
      }
      em.remove(cliente);
      em.getTransaction().commit();
      return true;

    } catch (Exception e) {

      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }

      e.printStackTrace();
      return false;

    } finally {
      em.close();
    }

  }

}
