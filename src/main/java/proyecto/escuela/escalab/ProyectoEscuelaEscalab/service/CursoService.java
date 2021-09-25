package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;

import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;

import java.util.List;

public interface CursoService {

    List<Curso> findAll();

    Curso findById(Integer id);

    Curso findByNombreAndJornada(String nombre, String jornada);

    Curso save(Curso curso );

    Curso update(Curso curso, Integer id);

    void deleteById(Integer id);
}
