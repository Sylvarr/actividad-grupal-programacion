package modelo.dao;

import java.util.List;

import modelo.entities.Proyecto;

public interface ProyectoDao {

  // CRUD
  void crearProyecto(Proyecto proyecto);

  Proyecto buscarProyecto(String idProyecto);

  boolean eliminarProyecto(String idProyecto);

  // findAll
  List<Proyecto> findAll();

  // Consultas específicas
  List<Proyecto> proyectosByEstado(String estado);

  List<Proyecto> proyectosByCliente(String cif);

  List<Proyecto> proyectosByJefeProyectoAndEstado(int jefeProyecto, String estado);

  double importesVentaProyectosTerminados();

  double margenBrutoProyectosTerminados();

  double porcentajeMargenBrutoProyectosTerminados();

  int diasATerminoProyectoActivo(String codigoProyecto);

}

