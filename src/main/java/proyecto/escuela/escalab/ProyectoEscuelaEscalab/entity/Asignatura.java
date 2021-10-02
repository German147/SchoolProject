package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "asignatura")
@ApiModel(description = "Información o propiedes de la entidad Asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Integer id;

    @Column(name = "nombre", length = 50)
    @ApiModelProperty(notes = "Se debe ingresar el nombre correspondiente a la entidad")
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @NotEmpty
    private String nombre;

    @Column(name = "jornada", length = 50)
    @ApiModelProperty(notes = "Se debe ingresar el momento del dia,por ejemplo mañana, tarde o noche")
    @Size(min = 4, max = 50, message = "Debes ingresar un tipo de Jornada válido")
    @NotEmpty
    private String jornada;

    @Column(name = "horario")
    @ApiModelProperty(notes = "Se debe ingresar el horario de la asignatura")
    @NotEmpty
    private String horario;

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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
