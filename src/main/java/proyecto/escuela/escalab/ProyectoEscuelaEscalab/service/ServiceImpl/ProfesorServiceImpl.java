package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Profesor;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.ProfesorRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ProfesorService;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor findById(Integer id) {
        Optional<Profesor> profesorOptional = profesorRepository.findById(id);
        return profesorOptional.orElseGet(Profesor::new);
    }

    @Override
    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor update(Profesor profesor, Integer id) {
        Profesor profesorUpdate = new Profesor();
        if (id != null && id > 0) {
            Optional<Profesor> optionalProfesor = profesorRepository.findById(id);
            if (optionalProfesor.isPresent()) {
                profesor.setId(id);
                profesorUpdate = profesorRepository.save(profesor);
            }
        } else {

        }
        return profesorUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = profesorRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El Profesor " + id + " no existe en nuestra base de datos");
        }
        profesorRepository.deleteById(id);
    }
}
