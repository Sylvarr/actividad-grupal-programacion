package modelo.dao;

import java.util.List;

import modelo.entities.Cliente;

public interface ClienteDao {

  void crearCliente(Cliente cliente);

  Cliente buscarCliente(String cif);

  List<Cliente> findAll();

  boolean eliminarCliente(String cif);

}
