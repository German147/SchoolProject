package proyecto.escuela.escalab.ProyectoEscuelaEscalab.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AplicationUserService implements UserDetailsService {

    private final AplicationUserDAO aplicationUserDAO;

    public AplicationUserService(AplicationUserDAO aplicationUserDAO) {
        this.aplicationUserDAO = aplicationUserDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return aplicationUserDAO.selectAplicationUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String
                        .format("UserName " + username + "is not Found")));
    }
}
