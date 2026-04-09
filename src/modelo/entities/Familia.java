package modelo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "familias")
public class Familia {

  @Column(name = "id_familia")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idFamilia;
  private String descripcion;

  public Familia() {
  }

  public Familia(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getIdFamilia() {
    return idFamilia;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + idFamilia;
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
    Familia other = (Familia) obj;
    if (idFamilia != other.idFamilia)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Familia [idFamilia=" + idFamilia + ", descripcion=" + descripcion + "]";
  }

}
