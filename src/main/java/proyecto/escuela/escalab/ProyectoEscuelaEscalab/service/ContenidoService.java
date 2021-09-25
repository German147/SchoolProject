package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;

import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Contenido;

import java.util.List;

public interface ContenidoService {

    List<Contenido> findAll();

    Contenido findById(Integer id);

    Contenido save(Contenido contenido);

    Contenido update(Contenido contenido, Integer id);

    void deleteById(Integer id);
}
