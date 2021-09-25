package proyecto.escuela.escalab.ProyectoEscuelaEscalab.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static proyecto.escuela.escalab.ProyectoEscuelaEscalab.security.AplicationUserPermission.*;

public enum AplicationUserRole {
    STUDENT(Sets.newHashSet(ASIGNATURA_READ, CONTENIDO_READ, TEACHER_READ)),
    TEACHER(Sets.newHashSet(STUDENT_READ, CONTENIDO_READ, CONTENIDO_WRITE, ASIGNATURA_READ, CURSO_READ)),
    TUTOR(Sets.newHashSet(STUDENT_READ,CURSO_READ, TEACHER_READ, REGISTROACADEMICO_READ)),
    PRINCIPAL(Sets.newHashSet(TEACHER_READ, ASIGNATURA_READ, CONTENIDO_READ, TUTOR_READ, STUDENT_READ)),
    SECRETARY(Sets.newHashSet(STUDENT_READ, TUTOR_READ, ASIGNATURA_READ, FICHAMEDICA_READ, TEACHER_READ)),
    PRECEPTOR(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,TEACHER_READ,ASIGNATURA_READ,FICHAMEDICA_READ,CURSO_READ,CURSO_WRITE)),
    ADMIN(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,TEACHER_READ,TEACHER_WRITE,TUTOR_READ,TUTOR_WRITE,
            ASIGNATURA_READ,ASIGNAATURA_WRITE,CONTENIDO_READ,CONTENIDO_WRITE,CURSO_READ,CURSO_WRITE,FICHAMEDICA_READ,
            FICHAMEDICA_WRITE,REGISTROACADEMICO_READ,REGISTROACADEMICO_WRITE,TOMAASIGNATURA_READ,TOMAASIGNATURA_WRITE));

    private final Set<AplicationUserPermission> permissions;


    AplicationUserRole(Set<AplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AplicationUserPermission> getPermissions() {
        return permissions;
    }
}
