package modelo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  private String cif;
  private String nombre;
  private String apellidos;
  private String domicilio;
  @Column(name = "facturacion_anual")
  private double facturacionAnual;
  @Column(name = "numero_empleados")
  private int numeroEmpleados;

  public Cliente() {
  }

  public Cliente(String cif, String nombre, String apellidos, String domicilio, double facturacionAnual,
      int numeroEmpleados) {
    this.cif = cif;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.domicilio = domicilio;
    this.facturacionAnual = facturacionAnual;
    this.numeroEmpleados = numeroEmpleados;
  }

  public String getCif() {
    return cif;
  }

  public void setCif(String cif) {
    this.cif = cif;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getDomicilio() {
    return domicilio;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  public double getFacturacionAnual() {
    return facturacionAnual;
  }

  public void setFacturacionAnual(double facturacionAnual) {
    this.facturacionAnual = facturacionAnual;
  }

  public int getNumeroEmpleados() {
    return numeroEmpleados;
  }

  public void setNumeroEmpleados(int numeroEmpleados) {
    this.numeroEmpleados = numeroEmpleados;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cif == null) ? 0 : cif.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Cliente other = (Cliente) obj;
    if (cif == null) {
      if (other.cif != null)
        return false;
    } else if (!cif.equals(other.cif))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Cliente [cif=" + cif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", domicilio=" + domicilio
        + ", facturacionAnual=" + facturacionAnual + ", numeroEmpleados=" + numeroEmpleados + "]";
  }

}
