package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Apoderado;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.ApoderadoRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ApoderadoService;

import java.util.List;
import java.util.Optional;

@Service
public class ApoderadoServiceImpl implements ApoderadoService {

    @Autowired
    private ApoderadoRepository apoderadoRepository;

    @Override
    public List<Apoderado> findAll() {
        return apoderadoRepository.findAll();
    }

    @Override
    public Apoderado findById(Integer id) {
        Optional<Apoderado> apoderadoOptional = apoderadoRepository.findById(id);
        return apoderadoOptional.orElseGet(Apoderado::new);
    }

    @Override
    public Apoderado save(Apoderado apoderado) {
        return apoderadoRepository.save(apoderado);
    }

    @Override
    public Apoderado update(Apoderado apoderado, Integer id) {
        Apoderado apoderadoUpdate = new Apoderado();
        if (id != null && id > 0) {
            Optional<Apoderado> optionalApoderado = apoderadoRepository.findById(id);
            if (optionalApoderado.isPresent()) {
                apoderado.setId(id);
                apoderadoUpdate = apoderadoRepository.save(apoderado);
            }
        } else {

        }
        return apoderadoUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = apoderadoRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El Apoderado " + id + " no existe en nuestra base de datos");
        }
        apoderadoRepository.deleteById(id);
    }
}
