package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;

import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.TomaAsignaturaDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.TomaAsignatura;

import java.util.List;

public interface TomaAsignaturaService  extends  ICRUD<TomaAsignatura>{

    List<TomaAsignatura> findAll();

    TomaAsignatura findById(Integer id);

    TomaAsignatura save(TomaAsignatura tomaAsignatura);

    TomaAsignatura update(TomaAsignatura tomaAsignatura, Integer id);

    void deleteById(Integer id);

    List<TomaAsignaturaDTO> findAllTomasAsignaturasDTO();
}
