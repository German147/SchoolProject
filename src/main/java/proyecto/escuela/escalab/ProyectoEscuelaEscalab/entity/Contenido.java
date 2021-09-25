package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contenido")
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contenido")
    private Integer id;

    @Column(name = "nombre", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @NotEmpty
    private String nombre;

    @Column(name = "detalle_Contenido", length = 200)
    @Size(max = 200, message = "El contenido debe tener máximo 200 caracteres")
    @NotEmpty
    private String detalleContenido;

    @ManyToOne
    @JoinColumn(name = "id_asignatura",nullable = false)
    @JsonIgnoreProperties("contenido")
    private Asignatura asignatura;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalleContenido() {
        return detalleContenido;
    }

    public void setDetalleContenido(String detalleContenido) {
        this.detalleContenido = detalleContenido;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}
