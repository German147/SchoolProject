package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;

import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;

import java.util.List;

public interface AlumnoService {

    List<Alumno> findAll();

    Alumno findById(Integer id);

    Alumno save(Alumno alumno);

    Alumno update(Alumno alumno, Integer id);

    void deleteById(Integer id);

}
