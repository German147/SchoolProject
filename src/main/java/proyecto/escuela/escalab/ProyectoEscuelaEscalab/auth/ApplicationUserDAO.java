package proyecto.escuela.escalab.ProyectoEscuelaEscalab.auth;


import java.util.Optional;

public interface ApplicationUserDAO {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
