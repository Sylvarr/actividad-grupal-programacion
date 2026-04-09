package modelo.dao;

import java.util.List;

import modelo.entities.Perfil;

public interface PerfilDao {

	void crearPerfil(Perfil perfil);

	Perfil buscarPerfil(int idPerfil);

	List<Perfil> findAll();

	boolean eliminarPerfil(int idPerfil);

}
