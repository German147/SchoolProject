package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.AsignaturaDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.CursoDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.ProfesorDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.TomaAsignaturaDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.TomaAsignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.exceptions.ModelNotFoundException;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.TomaAsignaturaRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.TomaAsignaturaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TomaAsignaturaServiceImpl implements TomaAsignaturaService {

    @Autowired
    private TomaAsignaturaRepository tomaAsignaturaRepository;

    @Override
    public List<TomaAsignatura> findAll() {
        List<TomaAsignatura> tomaAsignaturaList = tomaAsignaturaRepository.findAll();
        if (tomaAsignaturaList.isEmpty())
            throw new ModelNotFoundException("No toma de asignaturas en la base de datos");
        return tomaAsignaturaRepository.findAll();
    }

    @Override
    public TomaAsignatura findById(Integer id) {
        Optional<TomaAsignatura> tomaAsignaturaOptionalOptional = tomaAsignaturaRepository.findById(id);
        if (tomaAsignaturaOptionalOptional.isPresent()) {
            return tomaAsignaturaOptionalOptional.get();
        } else {
            throw new ModelNotFoundException("Toma de asignatura no existe o la búsqueda es nula");
        }
    }

    @Override
    public TomaAsignatura update(TomaAsignatura tomaAsignatura) {
        return null;
    }

    @Override
    public TomaAsignatura save(TomaAsignatura tomaAsignatura) {
        return tomaAsignaturaRepository.save(tomaAsignatura);
    }

    @Override
    public TomaAsignatura update(TomaAsignatura tomaAsignatura, Integer id) {
        TomaAsignatura tomaAsignaturaUpdate = new TomaAsignatura();
        if (id != null && id > 0) {
            Optional<TomaAsignatura> tomaAsignaturaOptional = tomaAsignaturaRepository.findById(id);
            if (tomaAsignaturaOptional.isPresent()) {
                tomaAsignatura.setId(id);
                tomaAsignaturaUpdate = tomaAsignaturaRepository.save(tomaAsignatura);
            }
        } else {
            throw new ModelNotFoundException("La toma de asignatura que ingresaste no existe");
        }
        return tomaAsignaturaUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = tomaAsignaturaRepository.existsById(id);
        if (!exists) {
            throw new ModelNotFoundException("La toma de asignatura que deseas eliminar no esta en la base de datos");
        }
        tomaAsignaturaRepository.deleteById(id);
    }

    @Override
    public List<TomaAsignaturaDTO> findAllTomasAsignaturasDTO() {
        List<TomaAsignaturaDTO> response = new ArrayList<>();
        List<TomaAsignatura> tomaAsignaturaList = tomaAsignaturaRepository.findAll();

        tomaAsignaturaList.forEach(tomaAsignatura -> {
            TomaAsignaturaDTO tomaAsignaturaDTO = new TomaAsignaturaDTO();
            tomaAsignaturaDTO.setIdTomaAsignatura(tomaAsignatura.getId());

            CursoDTO cursoDTO = new CursoDTO();
            cursoDTO.setNombre(tomaAsignatura.getCurso().getNombre());
            tomaAsignaturaDTO.setCursoDTO(cursoDTO);

            AsignaturaDTO asignaturaDTO = new AsignaturaDTO();
            asignaturaDTO.setNombre(tomaAsignatura.getAsignatura().getNombre());
            asignaturaDTO.setJornada(tomaAsignatura.getAsignatura().getJornada());
            asignaturaDTO.setHorario(tomaAsignatura.getAsignatura().getHorario());
            tomaAsignaturaDTO.setAsignaturaDTO(asignaturaDTO);

            ProfesorDTO profesorDTO = new ProfesorDTO();
            profesorDTO.setNombres(tomaAsignatura.getProfesor().getNombres());
            profesorDTO.setApellidos(tomaAsignatura.getProfesor().getApellidos());
            profesorDTO.setDni(tomaAsignatura.getProfesor().getDni());
            profesorDTO.setDireccion(tomaAsignatura.getProfesor().getDireccion());
            profesorDTO.setTelefono(tomaAsignatura.getProfesor().getTelefono());
            profesorDTO.setEmail(tomaAsignatura.getProfesor().getEmail());
            profesorDTO.setImagen(tomaAsignatura.getProfesor().getImagen());
            tomaAsignaturaDTO.setProfesorDTO(profesorDTO);

            response.add(tomaAsignaturaDTO);

        });

        return response;
    }

}
