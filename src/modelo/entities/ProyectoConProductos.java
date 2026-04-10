package modelo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyecto_con_productos")
public class ProyectoConProductos {

  @Id
  @Column(name = "num_orden")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int numOrden;

  @JoinColumn(name = "id_proyecto")
  @ManyToOne
  private Proyecto proyecto;

  @JoinColumn(name = "id_producto")
  @ManyToOne
  private Producto producto;

  @Column(name = "precio_asignado")
  private int precioAsignado;

  private int cantidad;

  public ProyectoConProductos() {
  }

  public ProyectoConProductos(Proyecto proyecto, Producto producto, int precioAsignado, int cantidad) {
    this.proyecto = proyecto;
    this.producto = producto;
    this.precioAsignado = precioAsignado;
    this.cantidad = cantidad;
  }

  public Proyecto getProyecto() {
    return proyecto;
  }

  public void setProyecto(Proyecto proyecto) {
    this.proyecto = proyecto;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public int getPrecioAsignado() {
    return precioAsignado;
  }

  public void setPrecioAsignado(int precioAsignado) {
    this.precioAsignado = precioAsignado;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public int getNumOrden() {
    return numOrden;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + numOrden;
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
    ProyectoConProductos other = (ProyectoConProductos) obj;
    if (numOrden != other.numOrden)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "ProyectoConProductos [numOrden=" + numOrden + ", proyecto=" + proyecto + ", producto=" + producto
        + ", precioAsignado=" + precioAsignado + ", cantidad=" + cantidad + "]";
  }

}
