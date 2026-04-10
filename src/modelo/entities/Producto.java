package modelo.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

  @Column(name = "id_producto")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idProducto;

  private String descripcion;
  private double precio;

  @Column(name = "fecha_creacion")
  private LocalDate fechaCreacion;

  @JoinColumn(name = "id_familia")
  @ManyToOne
  private Familia familia;

  public Producto() {
  }

  public Producto(String descripcion, double precio, LocalDate fechaCreacion, Familia familia) {
    this.descripcion = descripcion;
    this.precio = precio;
    this.fechaCreacion = fechaCreacion;
    this.familia = familia;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public void setFechaCreacion(LocalDate fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public void setFamilia(Familia familia) {
    this.familia = familia;
  }

  public int getIdProducto() {
    return idProducto;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public double getPrecio() {
    return precio;
  }

  public LocalDate getFechaCreacion() {
    return fechaCreacion;
  }

  public Familia getFamilia() {
    return familia;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + idProducto;
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
    Producto other = (Producto) obj;
    if (idProducto != other.idProducto)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", precio=" + precio
        + ", fechaCreacion=" + fechaCreacion + ", familia=" + (familia != null ? familia.getIdFamilia() : "null")
        + "]";
  }

}
