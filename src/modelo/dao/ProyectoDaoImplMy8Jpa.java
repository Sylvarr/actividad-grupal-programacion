package modelo.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import jakarta.persistence.EntityManager;
import modelo.entities.Proyecto;

public class ProyectoDaoImplMy8Jpa implements ProyectoDao {

  @Override
  public void crearProyecto(Proyecto proyecto) {
    EntityManager em = JpaUtil.getEntityManager();
    try {
      em.getTransaction().begin();
      em.persist(proyecto);
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
  public Proyecto buscarProyecto(String idProyecto) {
    EntityManager em = JpaUtil.getEntityManager();
    try {
      return em.find(Proyecto.class, idProyecto);
    } finally {
      em.close();
    }
  }

  @Override
  public boolean eliminarProyecto(String idProyecto) {
    EntityManager em = JpaUtil.getEntityManager();
    try {
      em.getTransaction().begin();
      Proyecto proyecto = em.find(Proyecto.class, idProyecto);
      if (proyecto == null) {
        em.getTransaction().rollback();
        return false;
      }
      em.remove(proyecto);
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
  public List<Proyecto> findAll() {
    EntityManager em = JpaUtil.getEntityManager();
    try {
      return em.createQuery("SELECT p FROM Proyecto p", Proyecto.class).getResultList();
    } finally {
      em.close();
    }
  }

  @Override
  public List<Proyecto> proyectosByEstado(String estado) {
    EntityManager em = JpaUtil.getEntityManager();
    try {
      return em.createQuery("SELECT p FROM Proyecto p WHERE p.estado = :estado", Proyecto.class)
          .setParameter("estado", estado)
          .getResultList();
    } finally {
      em.close();
    }
  }

  @Override
  public List<Proyecto> proyectosByCliente(String cif) {
    EntityManager em = JpaUtil.getEntityManager();
    try {
      return em.createQuery("SELECT p FROM Proyecto p WHERE p.cliente.cif = :cif", Proyecto.class)
          .setParameter("cif", cif)
          .getResultList();
    } finally {
      em.close();
    }
  }

  @Override
  public List<Proyecto> proyectosByJefeProyectoAndEstado(int jefeProyecto, String estado) {
    EntityManager em = JpaUtil.getEntityManager();
    try {
      return em.createQuery(
          "SELECT p FROM Proyecto p WHERE p.jefeProyecto = :jefe AND p.estado = :estado", Proyecto.class)
          .setParameter("jefe", jefeProyecto)
          .setParameter("estado", estado)
          .getResultList();
    } finally {
      em.close();
    }
  }

  @Override
  public double importesVentaProyectosTerminados() {
    EntityManager em = JpaUtil.getEntityManager();
    try {
      Double result = em.createQuery(
          "SELECT COALESCE(SUM(p.ventaPrevisto), 0) FROM Proyecto p WHERE p.estado = 'TERMINADO'", Double.class)
          .getSingleResult();
      return result;
    } finally {
      em.close();
    }
  }

  @Override
  public double margenBrutoProyectosTerminados() {
    EntityManager em = JpaUtil.getEntityManager();
    try {
      return em.createQuery(
          "SELECT COALESCE(SUM(p.ventaPrevisto) - SUM(p.costeReal), 0) FROM Proyecto p WHERE p.estado = 'terminado'",
          Double.class)
          .getSingleResult();
    } finally {
      em.close();
    }
  }

  @Override
  public double porcentajeMargenBrutoProyectosTerminados() {
    double ventas = importesVentaProyectosTerminados();
    if (ventas == 0) {
      return 0;
    }
    return margenBrutoProyectosTerminados() / ventas * 100;
  }

  @Override
  public int diasATerminoProyectoActivo(String codigoProyecto) {
    EntityManager em = JpaUtil.getEntityManager();
    try {
      Proyecto p = em.find(Proyecto.class, codigoProyecto);
      if (p == null || p.getFechaFinPrevisto() == null) {
        return 0;
      }
      return (int) ChronoUnit.DAYS.between(LocalDate.now(), p.getFechaFinPrevisto());
    } finally {
      em.close();
    }
  }

}
