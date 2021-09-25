package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public @ResponseBody
    List<Alumno> findAll() {
        return alumnoService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Alumno findById(@PathVariable("id") Integer id) {
        return alumnoService.findById(id);
    }

    @PostMapping("/save")
    public @ResponseBody
    Alumno save(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody
    Alumno update(@PathVariable("id") Integer id, @RequestBody Alumno alumno) {
        return alumnoService.update(alumno, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        alumnoService.deleteById(id);
    }
}
