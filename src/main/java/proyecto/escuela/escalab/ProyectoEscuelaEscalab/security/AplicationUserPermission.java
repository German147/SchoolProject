package proyecto.escuela.escalab.ProyectoEscuelaEscalab.security;

public enum AplicationUserPermission {
//in this class we create the permission to be set into the each role respectivily..
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    TEACHER_READ("teacher:read"),
    TEACHER_WRITE("teacher:write"),
    TUTOR_READ("tutor:read"),
    TUTOR_WRITE("tutor:write"),
    PRINCIPAL_READ("principal:read"),
    PRINCIPAL_WRITE("principal:write"),
    SECRETARY_READ("secretary:read"),
    SECRETARY_WRITE("secretary:write"),
    PRECEPTOR_READ("preceptor:read"),
    PRECEPTOR_WRITE("preceptor:write"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write"),
    ASIGNATURA_READ("asignatura:read"),
    ASIGNAATURA_WRITE("asignatura:write"),
    CONTENIDO_READ("contenido:read"),
    CONTENIDO_WRITE("contenido:write"),
    CURSO_READ("curso:read"),
    CURSO_WRITE("curso:write"),
    FICHAMEDICA_READ("fichamedica:read"),
    FICHAMEDICA_WRITE("fichamedica:write"),
    REGISTROACADEMICO_READ("registroacademico:read"),
    REGISTROACADEMICO_WRITE("registroacademico:write"),
    TOMAASIGNATURA_READ("tomaasignatura:read"),
    TOMAASIGNATURA_WRITE("tomaasignatura:write");

    private final String permission;

    AplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
