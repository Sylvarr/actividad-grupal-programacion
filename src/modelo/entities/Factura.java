package modelo.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "facturas")
public class Factura {

  @Id
  @Column(name = "id_factura")
  private String idFactura;
  
  private String descripcion;
  
  @Column(name = "fecha_factura")
  private LocalDate fechaFactura;
  
  @JoinColumn(name = "id_proyecto")
  @ManyToOne
  private Proyecto proyecto;

  public Factura() {
  }

  public Factura(String idFactura, String descripcion, LocalDate fechaFactura, Proyecto proyecto) {
    this.idFactura = idFactura;
    this.descripcion = descripcion;
    this.fechaFactura = fechaFactura;
    this.proyecto = proyecto;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public LocalDate getFechaFactura() {
    return fechaFactura;
  }

  public void setFechaFactura(LocalDate fechaFactura) {
    this.fechaFactura = fechaFactura;
  }

  public Proyecto getProyecto() {
    return proyecto;
  }

  public void setProyecto(Proyecto proyecto) {
    this.proyecto = proyecto;
  }

  public String getIdFactura() {
    return idFactura;
  }

  public void setIdFactura(String idFactura) {
    this.idFactura = idFactura;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((idFactura == null) ? 0 : idFactura.hashCode());
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
    Factura other = (Factura) obj;
    if (idFactura == null) {
      if (other.idFactura != null)
        return false;
    } else if (!idFactura.equals(other.idFactura))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Factura [idFactura=" + idFactura + ", descripcion=" + descripcion + ", fechaFactura=" + fechaFactura
        + ", proyecto=" + proyecto + "]";
  }

}
