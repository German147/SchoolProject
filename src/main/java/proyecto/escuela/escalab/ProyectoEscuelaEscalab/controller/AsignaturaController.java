package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Asignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.AsignaturaService;

import java.util.List;

@RestController
@RequestMapping("api/v1/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @ApiOperation(value = "Aqui se logra obtener todas las Asignaturas en una lista",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Asignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de Asignaturas se obtiene correctamente.", response = Asignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron Asignaturas en la base de datos", response = ExceptionResponse.class)})
    @GetMapping
    public @ResponseBody
    List<Asignatura> findAll() {
        return asignaturaService.findAll();
    }

    @ApiOperation(value = "Obtener un Asiganturas por su Id",
            notes = "Si requiere parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Asignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Asignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    Asignatura findById(@PathVariable("id") Integer id) {
        return asignaturaService.findById(id);
    }

    @ApiOperation(value = "Obtener una Asignatura por su nombre o jornada",
            notes = "Si requiere parámetros de entrada, su nombre o jornada",
            response = List.class,
            responseContainer = "Asignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Asignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/nombre/{nombre}/jornada/{jornada}")
    public @ResponseBody
    Asignatura findByNombreAndJornada(@PathVariable("nombre") String nombre,
                                 @PathVariable("jornada") String jornada) {
        return asignaturaService.findByNombreAndJornada(nombre, jornada);
    }


    @GetMapping("/nombreAndJornada")
    public @ResponseBody
    Asignatura findByNombreAndJornada2(@RequestParam(value = "nombre", required = false) String nombre,
                                  @RequestParam(value = "jornada", required = false) String jornada) {
        return asignaturaService.findByNombreAndJornada(nombre, jornada);
    }

    @ApiOperation(value = "Gardar un Asignatura nueva",
            notes = "Si requiere parámetros de entrada, todos sus parametros",
            response = List.class,
            responseContainer = "Asignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se creo correctamente.", response = Asignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('asignatura:write')")
    public @ResponseBody
    Asignatura save(@RequestBody Asignatura asignatura) {
        return asignaturaService.save(asignatura);
    }

    @ApiOperation(value = "Editar una Asignatura ya existente",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Asignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se edito correctamente.", response = Asignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('asignatura:write')")
    public @ResponseBody
    Asignatura update(@PathVariable("id") Integer id, @RequestBody Asignatura asignatura) {
        return asignaturaService.update(asignatura, id);
    }

    @ApiOperation(value = "Eliminar una Asignatura por su Id",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimino correctamente.", response = Asignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('asignatura:write')")
    public void deleteById(@PathVariable("id") Integer id) {
        asignaturaService.deleteById(id);
    }


}
