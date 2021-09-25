package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;

import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.RegistroAcademicoDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.RegistroAcademico;

import java.util.List;

public interface RegistroAcademicoService extends ICRUD<RegistroAcademico> {

    List<RegistroAcademico> findAll();

    RegistroAcademico findById(Integer id);

    RegistroAcademico save(RegistroAcademico registroAcademico);

    RegistroAcademico update(RegistroAcademico registroAcademico, Integer id);

    void deleteById(Integer id);

    List<RegistroAcademicoDTO> findAllRegistros();
}
