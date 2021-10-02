package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.FichaMedica;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.FichaMedicaService;

import java.util.List;

@RestController
@RequestMapping("api/v1/ficha_medica")
public class FichaMedicaController {

    @Autowired
    private FichaMedicaService fichaMedicaService;

    @ApiOperation(value = "Con este servicio obtenemos todas las fichas medicas de los Alumnos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "FichaMedica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de FichasMedicas se obtienen correctamente.", response = FichaMedica.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron FichasMedicas en la base de datos", response = ExceptionResponse.class)})
    @GetMapping
    public @ResponseBody
    List<FichaMedica> findAll() {
        return fichaMedicaService.findAll();
    }

    @ApiOperation(value = "Obtener una Ficha Medica por su Id",
            notes = "Si requiere parámetros de entrada, su id",
            response = List.class,
            responseContainer = "FichaMedica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = FichaMedica.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    FichaMedica findById(@PathVariable("id") Integer id) {
        return fichaMedicaService.findById(id);
    }

    @ApiOperation(value = "Gardar una FichaMedica nueva",
            notes = "Si requiere parámetros de entrada",
            response = List.class,
            responseContainer = "FichaMedica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se creo correctamente.", response = FichaMedica.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('fichamedica:write')")
    public @ResponseBody
    FichaMedica save(@RequestBody FichaMedica fichaMedica) {
        return fichaMedicaService.save(fichaMedica);
    }

    @ApiOperation(value = "Editar un FichaMedica ya existente",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "FichaMedica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se edito correctamente.", response = FichaMedica.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('fichamedica:write')")
    public @ResponseBody
    FichaMedica update(@PathVariable("id") Integer id, @RequestBody FichaMedica fichaMedica) {
        return fichaMedicaService.update(fichaMedica, id);
    }

    @ApiOperation(value = "Eliminar una FichaMedica por su Id",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "FichaMedica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimino correctamente.", response = FichaMedica.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('fichamedica:write')")
    public void deleteById(@PathVariable("id") Integer id) {
        fichaMedicaService.deleteById(id);
    }

}
