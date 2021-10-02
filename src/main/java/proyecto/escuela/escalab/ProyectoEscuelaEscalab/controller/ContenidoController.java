package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Contenido;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ContenidoService;

import java.util.List;

@RestController
@RequestMapping("api/v1/contenidos")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @ApiOperation(value = "Aqui obtenemos todos los contenidos cargados por el profesor en una lista",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Contenido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de Contenidos se obtiene correctamente.", response = Contenido.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron Alumnos en la base de datos", response = ExceptionResponse.class)})
    @GetMapping
    public @ResponseBody
    List<Contenido> findAll() {
        return contenidoService.findAll();
    }

    @ApiOperation(value = "Obtener un Contenido por su Id",
            notes = "Si requiere parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Contenido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Contenido.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    Contenido findById(@PathVariable("id") Integer id) {
        return contenidoService.findById(id);
    }

    @ApiOperation(value = "Aqui se puede guardar un contenido nuevo",
            notes = "Si requiere parámetros de entrada",
            response = List.class,
            responseContainer = "Contenido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se creo correctamente.", response = Contenido.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('contenido:write')")
    public @ResponseBody
    Contenido save(@RequestBody Contenido contenido) {
        return contenidoService.save(contenido);
    }

    @ApiOperation(value = "Aqui podemos editar un Contenido ya existente",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Contenido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se edito correctamente.", response = Contenido.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('contenido:write')")
    public @ResponseBody
    Contenido update(@PathVariable("id") Integer id, @RequestBody Contenido contenido) {
        return contenidoService.update(contenido, id);
    }


    @ApiOperation(value = "Eliminar un Contenido por su Id",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Contenido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimino correctamente.", response = Contenido.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('contenido:write')")
    public void deleteById(@PathVariable("id") Integer id) {
        contenidoService.deleteById(id);
    }

}
