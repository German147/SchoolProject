package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.FichaMedica;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.FichaMedicaRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.FichaMedicaService;

import java.util.List;
import java.util.Optional;

@Service
public class FichaMedicaServiceImpl implements FichaMedicaService {

    @Autowired
    private FichaMedicaRepository fichaMedicaRepository;

    @Override
    public List<FichaMedica> findAll() {
        return fichaMedicaRepository.findAll();
    }

    @Override
    public FichaMedica findById(Integer id) {
        Optional<FichaMedica> fichaMedicaOptional = fichaMedicaRepository.findById(id);
        return fichaMedicaOptional.orElseGet(FichaMedica::new);
    }

    @Override
    public FichaMedica save(FichaMedica fichaMedica) {
        return fichaMedicaRepository.save(fichaMedica);
    }

    @Override
    public FichaMedica update(FichaMedica fichaMedica, Integer id) {
        FichaMedica fichaMedicaUpdate = new FichaMedica();
        if (id != null && id > 0) {
            Optional<FichaMedica> optionalFichaMedica = fichaMedicaRepository.findById(id);
            if (optionalFichaMedica.isPresent()) {
                fichaMedica.setId(id);
                fichaMedicaUpdate = fichaMedicaRepository.save(fichaMedica);
            }
        } else {

        }
        return fichaMedicaUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = fichaMedicaRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("La Ficha Medica " + id + " no existe en nuestra base de datos");
        }
        fichaMedicaRepository.deleteById(id);
    }
}
