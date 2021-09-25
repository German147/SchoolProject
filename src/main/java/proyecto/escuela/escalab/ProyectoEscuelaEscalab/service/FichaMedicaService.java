package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;


import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.FichaMedica;

import java.util.List;

public interface FichaMedicaService{


    List<FichaMedica> findAll();

    FichaMedica findById(Integer id);

    FichaMedica save(FichaMedica fichaMedica);

    FichaMedica update(FichaMedica fichaMedica, Integer id);

    void deleteById(Integer id);
}
