package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Asignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.AsignaturaService;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping
    public @ResponseBody
    List<Asignatura> findAll() {
        return asignaturaService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Asignatura findById(@PathVariable("id") Integer id) {
        return asignaturaService.findById(id);
    }

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

    @PostMapping("/save")
    public @ResponseBody
    Asignatura save(@RequestBody Asignatura asignatura) {
        return asignaturaService.save(asignatura);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody
    Asignatura update(@PathVariable("id") Integer id, @RequestBody Asignatura asignatura) {
        return asignaturaService.update(asignatura, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        asignaturaService.deleteById(id);
    }


}
