package proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.RegistroAcademico;

@Repository
public interface RegistroAcademicoRepository extends JpaRepository<RegistroAcademico, Integer> {
}
