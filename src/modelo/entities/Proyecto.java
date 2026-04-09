package modelo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @Column(name = "id_proyecto")
    private String idProyecto;

}