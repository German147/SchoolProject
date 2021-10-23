package proyecto.escuela.escalab.ProyectoEscuelaEscalab.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static proyecto.escuela.escalab.ProyectoEscuelaEscalab.security.AplicationUserPermission.*;

public enum AplicationUserRole {
    ALUMNO(Sets.newHashSet(ASIGNATURA_READ, CONTENIDO_READ, PROFESOR_READ)),
    PROFESOR(Sets.newHashSet(ALUMNO_READ, CONTENIDO_READ, CONTENIDO_WRITE,
            ASIGNATURA_READ, CURSO_READ)),
    APODERADO(Sets.newHashSet(REGISTROACADEMICO_READ)),
    DIRECTOR(Sets.newHashSet(REGISTROACADEMICO_READ)),
    SECRETARIA(Sets.newHashSet(REGISTROACADEMICO_READ, REGISTROACADEMICO_WRITE,
            APODERADO_WRITE, APODERADO_READ,TOMAASIGNATURA_READ,TOMAASIGNATURA_WRITE)),
    PRECEPTOR(Sets.newHashSet(ALUMNO_READ, ALUMNO_WRITE, PROFESOR_READ, ASIGNATURA_READ,
            FICHAMEDICA_READ, CURSO_READ, CURSO_WRITE)),
    ADMIN(Sets.newHashSet(ALUMNO_READ, ALUMNO_WRITE, PROFESOR_READ,
            PROFESOR_WRITE, APODERADO_READ, APODERADO_WRITE,
            ASIGNATURA_READ, ASIGNAATURA_WRITE, CONTENIDO_READ, CONTENIDO_WRITE,
            CURSO_READ, CURSO_WRITE, FICHAMEDICA_READ,
            FICHAMEDICA_WRITE,REGISTROACADEMICO_READ, REGISTROACADEMICO_WRITE,
            TOMAASIGNATURA_READ, TOMAASIGNATURA_WRITE));

    private final Set<AplicationUserPermission> permissions;


    AplicationUserRole(Set<AplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AplicationUserPermission> getPermissions() {
        return permissions;
    }

    //the following method we set the authorities throw out the interface "GrantedAuthority"
    //and set the permissions with the collections list set
    public Set<SimpleGrantedAuthority> getGrantedAuthority() {
        Set<SimpleGrantedAuthority> permissions = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
