package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "ficha_medica")
public class FichaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficha")
    private Integer id;

    @Column(name = "fecha")
    @NotNull
    private LocalDate fecha;

    @Column(name = "edad")
    @NotNull
    private Integer edad;

    @Column(name = "peso")
    @NotNull
    private Double peso;

    @Column(name = "estatura")
    @NotNull
    private Double estatura;

    @Column(name = "diabetico")
    @NotNull
    private Boolean diabetico;

    @Column(name = "problemasCorazon")
    @NotNull
    private Boolean problemasCorazon;

    @Column(name = "alergias")
    @NotNull
    private Boolean alergias;

    @Column(name = "discapacidad")
    @NotEmpty
    private String discapacidad;

    @Column(name = "imagen")
    @NotEmpty
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public Boolean getDiabetico() {
        return diabetico;
    }

    public void setDiabetico(Boolean diabetico) {
        this.diabetico = diabetico;
    }

    public Boolean getProblemasCorazon() {
        return problemasCorazon;
    }

    public void setProblemasCorazon(Boolean problemasCorazon) {
        this.problemasCorazon = problemasCorazon;
    }

    public Boolean getAlergias() {
        return alergias;
    }

    public void setAlergias(Boolean alergias) {
        this.alergias = alergias;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
