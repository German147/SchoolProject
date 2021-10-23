package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Profesor;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ProfesorService;

import java.util.List;

@RestController
@RequestMapping("api/v1/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @ApiOperation(value = "Aqui se obtienen todos lo profesores en una lista",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Profesor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de Prfesores se obtiene correctamente.", response = Profesor.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron Profesores en la base de datos", response = ExceptionResponse.class)})
    @GetMapping
    public @ResponseBody
    List<Profesor> findAll() {
        return profesorService.findAll();
    }

    @ApiOperation(value = "Obtener un Profesor por su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Profesor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Profesor.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    Profesor findById(@PathVariable("id") Integer id) {
        return profesorService.findById(id);
    }

    @ApiOperation(value = "Gardar un Profesor nuevo",
            notes = "Si requiere parámetros de entrada",
            response = List.class,
            responseContainer = "Profesor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se creo correctamente.", response = Profesor.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('profesor:write')")
    public @ResponseBody
    Profesor save(@RequestBody Profesor profesor) {
        return profesorService.save(profesor);
    }

    @ApiOperation(value = "Editar un profesor ya existente",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Profesor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se edito correctamente.", response = Profesor.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('profesor:write')")
    public @ResponseBody
    Profesor update(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
        return profesorService.update(profesor, id);
    }

    @ApiOperation(value = "Eliminar un Profesor por su Id",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Profesor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimino correctamente.", response = Profesor.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('profesor:write')")
    public void deleteById(@PathVariable("id") Integer id) {
        profesorService.deleteById(id);
    }



}
