package proyecto.escuela.escalab.ProyectoEscuelaEscalab.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static proyecto.escuela.escalab.ProyectoEscuelaEscalab.security.AplicationUserRole.*;

@Repository
public class FakeApplicationUserDaoService implements ApplicationUserDAO {

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    private final PasswordEncoder passwordEncoder;


    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUser()
                .stream().filter(applicationUser ->
                        username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    public List<ApplicationUser> getApplicationUser() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        "lucas",
                        passwordEncoder.encode("password"),
                        ALUMNO.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(
                        "evange",
                        passwordEncoder.encode("password"),
                        PROFESOR.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(
                        "carlos",
                        passwordEncoder.encode("password"),
                        APODERADO.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(
                        "claudia",
                        passwordEncoder.encode("password"),
                        DIRECTOR.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true)
        );
        return applicationUsers;
    }
}
