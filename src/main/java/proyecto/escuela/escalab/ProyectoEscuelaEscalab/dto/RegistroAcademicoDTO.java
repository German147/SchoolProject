package proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto;

import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

public class RegistroAcademicoDTO extends ResourceSupport implements Serializable {

    private Integer IdRegistroDTO;
    private AlumnoDTO alumnoDTO;
    private ProfesorDTO profesorDTO;
    private CursoDTO cursoDTO;

    public Integer getIdRegistroDTO() {
        return IdRegistroDTO;
    }

    public void setIdRegistroDTO(Integer idRegistroDTO) {
        IdRegistroDTO = idRegistroDTO;
    }

    public AlumnoDTO getAlumnoDTO() {
        return alumnoDTO;
    }

    public void setAlumnoDTO(AlumnoDTO alumnoDTO) {
        this.alumnoDTO = alumnoDTO;
    }

    public ProfesorDTO getProfesorDTO() {
        return profesorDTO;
    }

    public void setProfesorDTO(ProfesorDTO profesorDTO) {
        this.profesorDTO = profesorDTO;
    }

    public CursoDTO getCursoDTO() {
        return cursoDTO;
    }

    public void setCursoDTO(CursoDTO cursoDTO) {
        this.cursoDTO = cursoDTO;
    }
}
