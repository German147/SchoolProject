package proyecto.escuela.escalab.ProyectoEscuelaEscalab.security;

public enum AplicationUserPermission {
    //in this class we create the permission to be set into the each role respectivily..
    ALUMNO_READ("alumno:read"),
    ALUMNO_WRITE("alumno:write"),
    PROFESOR_READ("profesor:read"),
    PROFESOR_WRITE("profesor:write"),
    APODERADO_READ("apoderado:read"),
    APODERADO_WRITE("apoderado:write"),
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
