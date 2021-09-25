package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;

import java.util.List;

public interface ICRUD <E>{
    List<E> findAll();

    E findById(Integer id);

    E update(E e);

    E save(E e);

    void deleteById(Integer id) throws Exception;
}
