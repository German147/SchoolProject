package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.RegistroAcademicoDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.RegistroAcademico;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.RegistroAcademicoService;

import java.util.List;

@RestController
@RequestMapping("api/v1/registro_academico")
public class RegistroAcademicoController {

        @Autowired
        private RegistroAcademicoService registroAcademicoService;

        @ApiOperation(value = "Aqui obtenemos todos los RegistrosAcademicos",
                notes = "No necesita parámetros de entrada",
                response = List.class,
                responseContainer = "RegistroAcademico")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "OK, La lista de los Registros Academicos se obtiene correctamente.", response = RegistroAcademico.class, responseContainer = "List"),
                @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
                @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
                @ApiResponse(code = 405, message = "No se encontraron RegistrosAcademicos en la base de datos", response = ExceptionResponse.class)})
        @GetMapping
        public @ResponseBody
        List<RegistroAcademico> findAll() {
                return registroAcademicoService.findAll();
        }

        @ApiOperation(value = "Obtener un RegistroAcademico por su Id",
                notes = "Si requiere parámetros de entrada, su id",
                response = List.class,
                responseContainer = "RegistroAcademico")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = RegistroAcademico.class, responseContainer = "List"),
                @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
                @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
        @GetMapping("/{id}")
        public @ResponseBody
        RegistroAcademico findById(@PathVariable("id") Integer id) {
                return registroAcademicoService.findById(id);
        }

        @ApiOperation(value = "Gardar un RegistroAcademico nuevo",
                notes = "Si requiere parámetros de entrada",
                response = List.class,
                responseContainer = "RegistroAcademico")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "OK, el recurso se creo correctamente.", response = RegistroAcademico.class, responseContainer = "List"),
                @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
        @PostMapping("/save")
        @PreAuthorize("hasAuthority('registroacademico:write')")
        public @ResponseBody
        RegistroAcademico save(@RequestBody RegistroAcademico registroAcademico) {
            return registroAcademicoService.save(registroAcademico);
        }

        @ApiOperation(value = "Editar un RegistroAcademico ya existente",
                notes = "Si requiere necesita parámetros de entrada, su id",
                response = List.class,
                responseContainer = "RegistroAcademico")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "OK, el recurso se edito correctamente.", response = RegistroAcademico.class, responseContainer = "List"),
                @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class)})
        @PutMapping("/update/{id}")
        @PreAuthorize("hasAuthority('registroacademico:write')")
        public @ResponseBody
        RegistroAcademico update(@PathVariable("id") Integer id, @RequestBody RegistroAcademico registroAcademico) {
            return registroAcademicoService.update(registroAcademico, id);
        }

        @ApiOperation(value = "Eliminar un RegistroAcademico por su Id",
                notes = "Si requiere necesita parámetros de entrada, su id",
                response = List.class,
                responseContainer = "RegistroAcademico")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "OK, el recurso se elimino correctamente.", response = RegistroAcademico.class, responseContainer = "List"),
                @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
                @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
        @DeleteMapping("/delete/{id}")
        @PreAuthorize("hasAuthority('registroacademico:write')")
        public void deleteById(@PathVariable("id") Integer id) {
                registroAcademicoService.deleteById(id);
        }

        //se crea un dto para el acultamiento de datos importantes
        @ApiOperation(value = "Aqui obtenemos solamente algunos datos seleccionados de los RegistrosAcademicos",
                notes = "No necesita parámetros de entrada",
                response = List.class,
                responseContainer = "RegistroAcademicoDTO")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "OK, La lista de RegistroAcademicoDTO se obtiene correctamente.", response = RegistroAcademicoDTO.class, responseContainer = "List"),
                @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
                @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
                @ApiResponse(code = 405, message = "No se encontro RegistroDTO en la base de datos", response = ExceptionResponse.class)})
        @GetMapping("/registroDTO")
        public List<RegistroAcademicoDTO> findAllRegistros(){
              //  List<RegistroAcademicoDTO> response = new ArrayList<>();
             //  List<RegistroAcademico> registroList = registroAcademicoService.findAll();
               return registroAcademicoService.findAllRegistros();
        };


}
