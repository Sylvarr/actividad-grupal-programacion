package modelo.dao;

import java.util.List;

import modelo.entities.Factura;

public interface FacturaDao {

	void crearFactura(Factura factura);

	Factura buscarFactura(String idFactura);
	
	List<Factura> findAll();
	
	boolean eliminarFactura(String idFactura);
	
	List<Factura> facturasByProyecto(String idProyecto);

}
