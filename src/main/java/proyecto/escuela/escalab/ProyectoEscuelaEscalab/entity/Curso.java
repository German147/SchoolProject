package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "curso")
@ApiModel(description = "Información o propiedes del curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer id;

    @ApiModelProperty(notes = "Nombre dene tener entre 4 y 50 caracteres")
    @Column(name = "nombre", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @NotEmpty
    private String nombre;

    @Column(name = "jornada", length = 50)
    @ApiModelProperty(notes = "Se debe ingresar el momento del dia,por ejemplo mañana, tarde o noche")
    @Size(min = 4, max = 50, message = "Debes ingresar un tipo de Jornada válido")
    @NotEmpty
    private String jornada;

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

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }
}
