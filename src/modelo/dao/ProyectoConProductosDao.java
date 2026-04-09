package modelo.dao;

import java.util.List;

import modelo.entities.ProyectoConProductos;

public interface ProyectoConProductosDao {

	List<ProyectoConProductos> productosByProyecto(String idProyecto);

}
