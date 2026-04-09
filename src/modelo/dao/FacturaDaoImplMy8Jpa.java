package modelo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import modelo.entities.Factura;

public class FacturaDaoImplMy8Jpa implements FacturaDao {

  @Override
  public void crearFactura(Factura factura) {

    EntityManager em = JpaUtil.getEntityManager();

    try {

      em.getTransaction().begin();
      em.persist(factura);
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
  public Factura buscarFactura(String idFactura) {

    EntityManager em = JpaUtil.getEntityManager();

    try {

      return em.find(Factura.class, idFactura);

    } finally {
      em.close();
    }

  }

  @Override
  public List<Factura> findAll() {

    EntityManager em = JpaUtil.getEntityManager();

    try {

      List<Factura> facturas = em.createQuery("SELECT f FROM Factura f", Factura.class).getResultList();

      return facturas;

    } finally {
      em.close();
    }

  }

  @Override
  public boolean eliminarFactura(String idFactura) {

    EntityManager em = JpaUtil.getEntityManager();

    try {

      em.getTransaction().begin();
      Factura factura = em.find(Factura.class, idFactura);
      if (factura == null) {
        em.getTransaction().rollback();
        return false;
      }
      em.remove(factura);
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

  @Override
  public List<Factura> facturasByProyecto(String idProyecto) {

    EntityManager em = JpaUtil.getEntityManager();

    try {

      return em.createQuery(
          "SELECT f FROM Factura f WHERE f.proyecto.idProyecto = :id",
          Factura.class)
          .setParameter("id", idProyecto)
          .getResultList();

    } finally {
      em.close();
    }

  }

}
