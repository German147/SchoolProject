package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Asignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @ApiOperation(value = "Obtener todos los cursos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Curso")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Curso.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "No existen Cursos en la base de datos", response = ExceptionResponse.class)})
    @GetMapping
    public @ResponseBody
    List<Curso> findAll() {
        return cursoService.findAll();
    }

    @ApiOperation(value = "Obtener un Curso por su Id",
            notes = "Si requiere parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Curso")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Curso.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    Curso findById(@PathVariable("id") Integer id) {
        return cursoService.findById(id);
    }

    @ApiOperation(value = "Obtener una Curso por su nombre o jornada",
            notes = "Si requiere parámetros de entrada, su nombre o jornada",
            response = List.class,
            responseContainer = "Curso")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Curso.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/nombre/{nombre}/jornada/{jornada}")
    public @ResponseBody
    Curso findByNombreAndJornada(@PathVariable("nombre") String nombre,
                                 @PathVariable("jornada") String jornada) {
        return cursoService.findByNombreAndJornada(nombre, jornada);
    }

    @GetMapping("/nombreAndJornada")
    public @ResponseBody
    Curso findByNombreAndJornada2(@RequestParam(value = "nombre", required = false) String nombre,
                                  @RequestParam(value = "jornada", required = false) String jornada) {
        return cursoService.findByNombreAndJornada(nombre, jornada);
    }

    @ApiOperation(value = "Gardar un Curso nuevo",
            notes = "Si requiere parámetros de entrada",
            response = List.class,
            responseContainer = "Curso")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se creo correctamente.", response = Curso.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('curso:write')")
    public @ResponseBody
    Curso save(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @ApiOperation(value = "Editar un Curso ya existente",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Curso")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se edito correctamente.", response = Curso.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('curso:write')")
    public @ResponseBody
    Curso update(@PathVariable("id") Integer id, @RequestBody Curso curso) {
        return cursoService.update(curso, id);
    }

    @ApiOperation(value = "Eliminar un Curso por su Id",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Curso")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimino correctamente.", response = Curso.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('curso:write')")
    public void deleteById(@PathVariable("id") Integer id) {
        cursoService.deleteById(id);
    }

}
