package proyecto.escuela.escalab.ProyectoEscuelaEscalab.auth;

import java.util.Optional;
//this class would be like a repository...for the aplicationUserService
public interface AplicationUserDAO {
    Optional<ApplicationUser> selectAplicationUserByUsername(String username);
}
