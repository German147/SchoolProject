package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.exceptions.ModelNotFoundException;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.CursoRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.CursoService;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        List<Curso> cursoList = cursoRepository.findAll();
        if (cursoList.isEmpty())
            throw new ModelNotFoundException("No existen Cursos en la base de datos");
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(Integer id) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isPresent()){
            return cursoOptional.get();
        }else {
            throw new ModelNotFoundException("El curso no existe o la búsqueda es nula");
        }
    }

    @Override
    public Curso findByNombreAndJornada(String nombre, String jornada) {
        Curso curso = new Curso();
        if (nombre == null || nombre.equalsIgnoreCase("")) {
            if (jornada != null && !"".equalsIgnoreCase(nombre)) {
                curso = cursoRepository.findCursoByJornada(jornada);
            }
        } else {
            if (jornada == null || "".equalsIgnoreCase(jornada)) {
                curso = cursoRepository.findCursoByNombre(nombre);
            } else {
                curso = cursoRepository.findCursoByNombreAndJornada(nombre, jornada);
            }
        }
        return curso;
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Curso curso, Integer id) {
        Curso cursoUpdate = new Curso();
        if (id != null && id > 0) {
            Optional<Curso> optionalCurso = cursoRepository.findById(id);
            if (optionalCurso.isPresent()) {
                curso.setId(id);
                cursoUpdate = cursoRepository.save(curso);
            }
        } else {
            throw new ModelNotFoundException("El curso que ingresaste no existe");
        }
        return cursoUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = cursoRepository.existsById(id);
        if (!exists) {
            throw new ModelNotFoundException("El curso que deseas eliminar no esta en la base de datos");
        }
        cursoRepository.deleteById(id);
    }
}
