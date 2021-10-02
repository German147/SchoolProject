package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.RegistroAcademicoDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.TomaAsignaturaDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.TomaAsignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.TomaAsignaturaService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("api/v1/toma_asignaturas")
public class TomaAsignaturaController {

    @Autowired
    private TomaAsignaturaService tomaAsignaturaService;

    @ApiOperation(value = "Aqui con este servicio logramos obtener todas las Tomas de Asignaturas que existan en la base d edatos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "TomaAsignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de TomaAsignatura se obtiene correctamente.", response = TomaAsignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron TomaAsignatura en la base de datos", response = ExceptionResponse.class)})
    @GetMapping
    public @ResponseBody
    List<TomaAsignatura> findAll() {
        return tomaAsignaturaService.findAll();
    }

    @ApiOperation(value = "Obtener un registro de TomaAsignatura por su Id",
            notes = "Si requiere parámetros de entrada, su id",
            response = List.class,
            responseContainer = "TomaAsignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = TomaAsignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    TomaAsignatura findById(@PathVariable("id") Integer id) {
        return tomaAsignaturaService.findById(id);
    }

    @ApiOperation(value = "Gardar un registro de TomaAsignatura nuevo",
            notes = "Si requiere parámetros de entrada",
            response = List.class,
            responseContainer = "TomaAsignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se creo correctamente.", response = TomaAsignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('tomaasignatura:write')")
    public @ResponseBody
    TomaAsignatura save(@RequestBody TomaAsignatura tomaAsignatura) {
        return tomaAsignaturaService.save(tomaAsignatura);
    }

    @ApiOperation(value = "Editar un registro de TomaAsignatura ya existente",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "TomaAsignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se edito correctamente.", response = TomaAsignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('tomaasignatura:write')")
    public @ResponseBody
    TomaAsignatura update(@PathVariable("id") Integer id, @RequestBody TomaAsignatura tomaAsignatura) {
        return tomaAsignaturaService.update(tomaAsignatura, id);
    }

    @ApiOperation(value = "Eliminar un registro de TomaAsignatura por su Id",
            notes = "Si requiere necesita parámetros de entrada, su id",
            response = List.class,
            responseContainer = "TomaAsignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimino correctamente.", response = TomaAsignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('tomaasignatura:write')")
    public void deleteById(@PathVariable("id") Integer id) {
        tomaAsignaturaService.deleteById(id);
    }

    @ApiOperation(value = "Aqui obtenemos solamente algunos datos seleccionados del registro de TomaAsignaturaDTO",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "TomaAsignaturaDTO")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de TomaAsignaturaDTO se obtiene correctamente.", response = TomaAsignaturaDTO.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontro TomaAsignaturaDTO en la base de datos", response = ExceptionResponse.class)})
    @GetMapping("/dto")
    public List<TomaAsignaturaDTO> findAllTomasAsignaturasDTO() {

        List<TomaAsignaturaDTO> response = new ArrayList<>();

        List<TomaAsignatura> tomaAsignaturas = tomaAsignaturaService.findAll();

        tomaAsignaturas.forEach(tomaAsignatura -> {

            TomaAsignaturaDTO d = new TomaAsignaturaDTO();

            //localhost:8080/paciente/39
            ControllerLinkBuilder linkTo1 =
                    linkTo(methodOn(CursoController.class).findById((tomaAsignatura.getCurso().getId())));
            d.add(linkTo1.withSelfRel());
            response.add(d);

            //localhost:8080/	medico/48
            ControllerLinkBuilder linkTo2 =
                    linkTo(methodOn(AsignaturaController.class).findById((tomaAsignatura.getAsignatura().getId())));
            d.add(linkTo2.withSelfRel());
            response.add(d);

            ControllerLinkBuilder linkTo =
                    linkTo(methodOn(ProfesorController.class).findById((tomaAsignatura.getProfesor().getId())));
            d.add(linkTo.withSelfRel());

            d.setIdTomaAsignatura(tomaAsignatura.getId());
            response.add(d);

        });

        return response;
    }
}
