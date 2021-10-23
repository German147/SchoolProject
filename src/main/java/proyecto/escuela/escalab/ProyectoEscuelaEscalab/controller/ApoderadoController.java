package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Apoderado;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ApoderadoService;

import java.util.List;

@RestController
@RequestMapping("api/v1/apoderados")
public class ApoderadoController {

    @Autowired
    private ApoderadoService apoderadoService;

    @ApiOperation(value = "Obtener todos los Apoderados de los alumnos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Apoderados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de Apoderados se obtiene correctamente.", response = Apoderado.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron Apoderados en la base de datos", response = ExceptionResponse.class)})
    @GetMapping
    public @ResponseBody
    List<Apoderado> findAll() {
        return apoderadoService.findAll();
    }

    @ApiOperation(value = "Obtener un Apoderado por su Id",
            notes = "Si requiere parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Apoderado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Apoderado.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    Apoderado findById(@PathVariable("id") Integer id) {
        return apoderadoService.findById(id);
    }

    @ApiOperation(value = "Gardar un Apoderado nuevo",
            notes = "Si requiere parámetros de entrada, todos sus campos",
            response = List.class,
            responseContainer = "Apoderado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se creo correctamente.", response = Apoderado.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('apoderado:write')")
    public @ResponseBody
    Apoderado save(@RequestBody Apoderado apoderado) {
        return apoderadoService.save(apoderado);
    }

    @ApiOperation(value = "Editar un Apoderado ya existente",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Apoderado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se edito correctamente.", response = Apoderado.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('apoderado:write')")
    public @ResponseBody
    Apoderado update(@PathVariable("id") Integer id, @RequestBody Apoderado apoderado) {
        return apoderadoService.update(apoderado, id);
    }

    @ApiOperation(value = "Eliminar un Apoderado por su Id",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "Apoderado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimino correctamente.", response = Apoderado.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('apoderado:write')")
    public void deleteById(@PathVariable("id") Integer id) {
        apoderadoService.deleteById(id);
    }
}
