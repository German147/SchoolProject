package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.AlumnoRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.AlumnoService;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno findById(Integer id) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
        return alumnoOptional.orElseGet(Alumno::new);
    }

    @Override
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno update(Alumno alumno, Integer id) {
        Alumno alumnoUpdate = new Alumno();
        if (id != null && id > 0) {
            Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);
            if (optionalAlumno.isPresent()) {
                alumno.setId(id);
                alumnoUpdate = alumnoRepository.save(alumno);
            }
        } else {

        }
        return alumnoUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = alumnoRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El Alumno " + id + " no existe en nuestra base de datos");
        }
        alumnoRepository.deleteById(id);
    }
}
