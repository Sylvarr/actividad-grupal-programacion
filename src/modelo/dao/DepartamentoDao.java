package modelo.dao;

import java.util.List;

import modelo.entities.Departamento;

public interface DepartamentoDao {

	void crearDepartamento(Departamento departamento);

	Departamento buscarDepartamento(int idDepar);

	List<Departamento> findAll();

	boolean eliminarDepartamento(int idDepar);

}
