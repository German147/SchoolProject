package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/curso")
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
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Curso")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "El curso no existe o la búsqueda es nula", response = ExceptionResponse.class),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionHandler.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron Cursos en la base de datos", response = ExceptionResponse.class),
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Curso.class, responseContainer = "List")})
    @GetMapping("/{id}")
    public @ResponseBody
    Curso findById(@PathVariable("id") Integer id) {
        return cursoService.findById(id);
    }

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

    @PostMapping("/save")
    public @ResponseBody
    Curso save(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody
    Curso update(@PathVariable("id") Integer id, @RequestBody Curso curso) {
        return cursoService.update(curso, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        cursoService.deleteById(id);
    }

}
