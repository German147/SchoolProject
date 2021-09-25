package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Asignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.AsignaturaRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.AsignaturaService;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    public List<Asignatura> findAll() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Asignatura findById(Integer id) {
        Optional<Asignatura> asignaturaOptional = asignaturaRepository.findById(id);
        return asignaturaOptional.orElseGet(Asignatura::new);
    }

    @Override
    public Asignatura findByNombreAndJornada(String nombre, String jornada) {
        Asignatura asignatura = new Asignatura();
        if (nombre == null || nombre.equalsIgnoreCase("")) {
            if (jornada != null && !"".equalsIgnoreCase(nombre)) {
                asignatura = asignaturaRepository.findAsignaturaByJornada(jornada);
            }
        } else {
            if (jornada == null || "".equalsIgnoreCase(jornada)) {
                asignatura = asignaturaRepository.findAsignaturaByNombre(nombre);
            } else {
                asignatura = asignaturaRepository.findAsignaturaByNombreAndJornada(nombre, jornada);
            }
        }
        return asignatura;
    }

    @Override
    public Asignatura save(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Asignatura update(Asignatura asignatura, Integer id) {
        Asignatura asignaturaupdate = new Asignatura();
        if (id != null && id > 0) {
            Optional<Asignatura> optionalAsignatura = asignaturaRepository.findById(id);
            if (optionalAsignatura.isPresent()) {
                asignatura.setId(id);
                asignaturaupdate = asignaturaRepository.save(asignatura);
            }
        } else {

        }
        return asignaturaupdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = asignaturaRepository.existsById(id);

        if (!exists) {
            throw new IllegalStateException("La asignatura que intentas eliminar no existe en nuestra base de datos");
        }
        asignaturaRepository.deleteById(id);
    }
}
