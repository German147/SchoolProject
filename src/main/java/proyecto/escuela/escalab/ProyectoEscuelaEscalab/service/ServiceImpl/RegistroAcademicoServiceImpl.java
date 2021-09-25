package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.AlumnoDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.CursoDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.ProfesorDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.RegistroAcademicoDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.RegistroAcademico;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.exceptions.ModelNotFoundException;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.RegistroAcademicoRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.RegistroAcademicoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroAcademicoServiceImpl implements RegistroAcademicoService {

    @Autowired
    private RegistroAcademicoRepository registroAcademicoRepository;

    @Override
    public List<RegistroAcademico> findAll() {
        List<RegistroAcademico> registroAcademicoList = registroAcademicoRepository.findAll();
        if (registroAcademicoList.isEmpty())
            throw new ModelNotFoundException("No existen Registros Académicos en la base de datos");
        return registroAcademicoRepository.findAll();
    }

    @Override
    public RegistroAcademico findById(Integer id) {
        Optional<RegistroAcademico> registroAcademicoOptional = registroAcademicoRepository.findById(id);
        if (registroAcademicoOptional.isPresent()){
            return registroAcademicoOptional.get();
        }else {
            throw new ModelNotFoundException("El Registro Académico no existe o la búsqueda es nula");
        }
    }

    @Override
    public RegistroAcademico update(RegistroAcademico registroAcademico) {
        return null;
    }

    @Override
    public RegistroAcademico save(RegistroAcademico registroAcademico) {
        return null;
    }

    @Override
    public RegistroAcademico update(RegistroAcademico registroAcademico, Integer id) {
        RegistroAcademico registroAcademicoUpdate = new RegistroAcademico();
        if (id != null && id > 0) {
            Optional<RegistroAcademico> optionalRegistroAcademico = registroAcademicoRepository.findById(id);
            if (optionalRegistroAcademico.isPresent()) {
                registroAcademico.setId(id);
                registroAcademicoUpdate = registroAcademicoRepository.save(registroAcademico);
            }
        } else {
            throw new ModelNotFoundException("El Registro Académico que ingresaste no existe");
        }
        return registroAcademicoUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = registroAcademicoRepository.existsById(id);
        if (!exists) {
            throw new ModelNotFoundException("El Registro Académico que deseas eliminar no esta en la base de datos");
        }
        registroAcademicoRepository.deleteById(id);
    }

    @Override
    public List<RegistroAcademicoDTO> findAllRegistros() {

        List<RegistroAcademicoDTO> response = new ArrayList<>();
        List<RegistroAcademico> registroList = registroAcademicoRepository.findAll();
        //una expresion lambada es mucho mas rapido ya que trabaja en memoria, para hacer debug se debe poernel punto de interrupcion dentro de la expresion
        registroList.forEach(registroAcademico -> {

            RegistroAcademicoDTO registroDTO = new RegistroAcademicoDTO();
            registroDTO.setIdRegistroDTO(registroAcademico.getId());

            //en cada for each refrescamos el objeto para que JPA sepa que es un nuevo objeto y se reinicie
            AlumnoDTO alumnoDTO =  new AlumnoDTO();
            alumnoDTO.setNombres(registroAcademico.getAlumno().getNombres());
            alumnoDTO.setApellidos(registroAcademico.getAlumno().getApellidos());
            alumnoDTO.setFechaNacimiento(registroAcademico.getAlumno().getFechaNacimiento());
            alumnoDTO.setDni(registroAcademico.getAlumno().getDni());
            alumnoDTO.setDireccion(registroAcademico.getAlumno().getDireccion());
            alumnoDTO.setTelefono(registroAcademico.getAlumno().getTelefono());
            alumnoDTO.setEmail(registroAcademico.getAlumno().getEmail());
            alumnoDTO.setImagen(registroAcademico.getAlumno().getImagen());
            registroDTO.setAlumnoDTO(alumnoDTO);
            //refrescamos el objeto nuevamente
            ProfesorDTO profesorDTO = new ProfesorDTO();
            profesorDTO.setNombres(registroAcademico.getProfesor().getNombres());
            profesorDTO.setApellidos(registroAcademico.getProfesor().getApellidos());
            profesorDTO.setDni(registroAcademico.getProfesor().getDni());
            profesorDTO.setDireccion(registroAcademico.getProfesor().getDireccion());
            profesorDTO.setTelefono(registroAcademico.getProfesor().getTelefono());
            profesorDTO.setTelefono(registroAcademico.getProfesor().getTelefono());
            profesorDTO.setEmail(registroAcademico.getProfesor().getEmail());
            profesorDTO.setImagen(registroAcademico.getProfesor().getImagen());
            registroDTO.setProfesorDTO(profesorDTO);
            //refrescamos el objeto nuevamente
            CursoDTO cursoDTO = new CursoDTO();
            cursoDTO.setNombre(registroAcademico.getCurso().getNombre());
            registroDTO.setCursoDTO(cursoDTO);
            response.add(registroDTO);

        });
        return response;
    }
}
