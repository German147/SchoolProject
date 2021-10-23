package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("api/v1/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    //we can use the following anotations to stablish the ROLES and AUTHORITIES in each service:
//hasRole('ROLE_...') or hasAnyRole('ROLE_...','ROLE_...') or hasAuthority('...:write') or
// hasAnyAuthority('...:READ','...:WRITE')
    @ApiOperation(value = "Obtener todos los Alumnos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de Alumnos se obtiene correctamente.", response = Alumno.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron Alumnos en la base de datos", response = ExceptionResponse.class)})
    @GetMapping
    public @ResponseBody
    List<Alumno> findAll() {
        return alumnoService.findAll();
    }

    @ApiOperation(value = "Obtener un Alumno por su Id",
            notes = "Si requiere parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Alumno.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    Alumno findById(@PathVariable("id") Integer id) {
        return alumnoService.findById(id);
    }

    @ApiOperation(value = "Gardar un alumno nuevo",
            notes = "Si requiere parámetros de entrada",
            response = List.class,
            responseContainer = "Alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se creo correctamente.", response = Alumno.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PostMapping("/save")
            @PreAuthorize("hasAuthority('alumno:write')")
            public@ResponseBody
            Alumno save(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }

    @ApiOperation(value = "Editar un alumno ya existente",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se edito correctamente.", response = Alumno.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('alumno:write')")
    public @ResponseBody
    Alumno update(@PathVariable("id") Integer id, @RequestBody Alumno alumno) {
        return alumnoService.update(alumno, id);
    }

    @ApiOperation(value = "Eliminar un Alumno por su Id",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimino correctamente.", response = Alumno.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('alumno:write')")
    public void deleteById(@PathVariable("id") Integer id) {
        alumnoService.deleteById(id);
    }
}
