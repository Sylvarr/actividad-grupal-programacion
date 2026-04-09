package modelo.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyectos")
public class Proyecto {

  @Id
  @Column(name = "id_proyecto")
  private String idProyecto;

  private String descripcion;

  @Column(name = "fecha_inicio")
  private LocalDate fechaInicio;

  @Column(name = "fecha_fin_previsto")
  private LocalDate fechaFinPrevisto;

  @Column(name = "fecha_fin_real")
  private LocalDate fechaFinReal;

  @Column(name = "venta_previsto")
  private double ventaPrevisto;

  @Column(name = "costes_previsto")
  private double costesPrevisto;

  @Column(name = "coste_real")
  private double costeReal;

  private String estado;

  @Column(name = "jefe_proyecto")
  private Integer jefeProyecto;

  @ManyToOne
  @JoinColumn(name = "cif")
  private Cliente cliente;

  public Proyecto() {}

  public Proyecto(
          String idProyecto,
          String descripcion,
          LocalDate fechaInicio,
          LocalDate fechaFinPrevisto,
          LocalDate fechaFinReal,
          double ventaPrevisto,
          double costesPrevisto,
          double costeReal,
          String estado,
          Integer jefeProyecto) {
    this(idProyecto, descripcion, fechaInicio, fechaFinPrevisto, fechaFinReal, ventaPrevisto, costesPrevisto,
        costeReal, estado, jefeProyecto, null);
  }

  public Proyecto(
          String idProyecto,
          String descripcion,
          LocalDate fechaInicio,
          LocalDate fechaFinPrevisto,
          LocalDate fechaFinReal,
          double ventaPrevisto,
          double costesPrevisto,
          double costeReal,
          String estado,
          Integer jefeProyecto,
          Cliente cliente) {
    this.idProyecto = idProyecto;
    this.descripcion = descripcion;
    this.fechaInicio = fechaInicio;
    this.fechaFinPrevisto = fechaFinPrevisto;
    this.fechaFinReal = fechaFinReal;
    this.ventaPrevisto = ventaPrevisto;
    this.costesPrevisto = costesPrevisto;
    this.costeReal = costeReal;
    this.estado = estado;
    this.jefeProyecto = jefeProyecto;
    this.cliente = cliente;
  }

  public String getIdProyecto() {
    return idProyecto;
  }

  public void setIdProyecto(String idProyecto) {
    this.idProyecto = idProyecto;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public LocalDate getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(LocalDate fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public LocalDate getFechaFinPrevisto() {
    return fechaFinPrevisto;
  }

  public void setFechaFinPrevisto(LocalDate fechaFinPrevisto) {
    this.fechaFinPrevisto = fechaFinPrevisto;
  }

  public LocalDate getFechaFinReal() {
    return fechaFinReal;
  }

  public void setFechaFinReal(LocalDate fechaFinReal) {
    this.fechaFinReal = fechaFinReal;
  }

  public double getVentaPrevisto() {
    return ventaPrevisto;
  }

  public void setVentaPrevisto(double ventaPrevisto) {
    this.ventaPrevisto = ventaPrevisto;
  }

  public double getCostesPrevisto() {
    return costesPrevisto;
  }

  public void setCostesPrevisto(double costesPrevisto) {
    this.costesPrevisto = costesPrevisto;
  }

  public double getCosteReal() {
    return costeReal;
  }

  public void setCosteReal(double costeReal) {
    this.costeReal = costeReal;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Integer getJefeProyecto() {
    return jefeProyecto;
  }

  public void setJefeProyecto(Integer jefeProyecto) {
    this.jefeProyecto = jefeProyecto;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public double margenPrevisto() {
    return ventaPrevisto - costesPrevisto;
  }

  public double procentageMargenPrevisto() {
    if (ventaPrevisto == 0) {
      return 0;
    }
    return margenPrevisto() / ventaPrevisto * 100;
  }

  public double margenReal() {
    return ventaPrevisto - costeReal;
  }

  public double porcentajeMargenReal() {
    if (ventaPrevisto == 0) {
      return 0;
    }
    return margenReal() / ventaPrevisto * 100;
  }

  public double diferenciaGastos() {
    return costeReal - costesPrevisto;
  }

  public int diferenciaDiasFinPrevistoReal() {
    if (fechaFinPrevisto == null || fechaFinReal == null) {
      return 0;
    }
    return (int) ChronoUnit.DAYS.between(fechaFinPrevisto, fechaFinReal);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((idProyecto == null) ? 0 : idProyecto.hashCode());
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
    Proyecto other = (Proyecto) obj;
    if (idProyecto == null) {
      if (other.idProyecto != null)
        return false;
    } else if (!idProyecto.equals(other.idProyecto))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Proyecto [idProyecto=" + idProyecto + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio
        + ", fechaFinPrevisto=" + fechaFinPrevisto + ", fechaFinReal=" + fechaFinReal + ", ventaPrevisto="
        + ventaPrevisto + ", costesPrevisto=" + costesPrevisto + ", costeReal=" + costeReal + ", estado="
        + estado + ", jefeProyecto=" + jefeProyecto + ", cliente=" + (cliente != null ? cliente.getCif() : "null")
        + "]";
  }

}