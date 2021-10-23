package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "registro_academico")
@ApiModel(description = "Información o propiedes de la entidad RegistroAcademico")
public class RegistroAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_academico")
    private Integer id;

    @Column(name = "fecha_registro")
    @ApiModelProperty(notes = "Se debe ingresar la fecha del momento de cuando se hace el RegistroAcademico")
    @NotNull
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
