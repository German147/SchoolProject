package proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto;

import org.springframework.hateoas.ResourceSupport;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Profesor;

import java.io.Serializable;

public class TomaAsignaturaDTO extends ResourceSupport implements Serializable {

    private Integer IdTomaAsignatura;
    private CursoDTO cursoDTO;
    private AsignaturaDTO asignaturaDTO;
    private ProfesorDTO profesorDTO;

    public Integer getIdTomaAsignatura() {
        return IdTomaAsignatura;
    }

    public void setIdTomaAsignatura(Integer idTomaAsignatura) {
        IdTomaAsignatura = idTomaAsignatura;
    }

    public CursoDTO getCursoDTO() {
        return cursoDTO;
    }

    public void setCursoDTO(CursoDTO cursoDTO) {
        this.cursoDTO = cursoDTO;
    }

    public AsignaturaDTO getAsignaturaDTO() {
        return asignaturaDTO;
    }

    public void setAsignaturaDTO(AsignaturaDTO asignaturaDTO) {
        this.asignaturaDTO = asignaturaDTO;
    }

    public ProfesorDTO getProfesorDTO() {
        return profesorDTO;
    }

    public void setProfesorDTO(ProfesorDTO profesorDTO) {
        this.profesorDTO = profesorDTO;
    }
}
