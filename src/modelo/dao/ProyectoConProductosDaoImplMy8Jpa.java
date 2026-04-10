package modelo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import modelo.entities.ProyectoConProductos;

public class ProyectoConProductosDaoImplMy8Jpa implements ProyectoConProductosDao {

  @Override
  public List<ProyectoConProductos> productosByProyecto(String idProyecto) {

    EntityManager em = JpaUtil.getEntityManager();

    try {
      return em.createQuery(
          "SELECT pp FROM ProyectoConProductos pp WHERE pp.proyecto.idProyecto = :id",
          ProyectoConProductos.class)
          .setParameter("id", idProyecto)
          .getResultList();
    } finally {
      em.close();
    }

  }

}
