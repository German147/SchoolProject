package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;

import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Apoderado;

import java.util.List;

public interface ApoderadoService {


    List<Apoderado> findAll();

    Apoderado findById(Integer id);

    Apoderado save(Apoderado apoderado);

    Apoderado update(Apoderado apoderado, Integer id);

    void deleteById(Integer id);
}
