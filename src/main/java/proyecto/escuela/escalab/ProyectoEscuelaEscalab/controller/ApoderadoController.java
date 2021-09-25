package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Apoderado;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ApoderadoService;

import java.util.List;

@RestController
@RequestMapping("/apoderado")
public class ApoderadoController {

    @Autowired
    private ApoderadoService apoderadoService;

    @GetMapping
    public @ResponseBody
    List<Apoderado> findAll() {
        return apoderadoService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Apoderado findById(@PathVariable("id") Integer id) {
        return apoderadoService.findById(id);
    }

    @PostMapping("/save")
    public @ResponseBody
    Apoderado save(@RequestBody Apoderado apoderado) {
        return apoderadoService.save(apoderado);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody
    Apoderado update(@PathVariable("id") Integer id, @RequestBody Apoderado apoderado) {
        return apoderadoService.update(apoderado, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        apoderadoService.deleteById(id);
    }
}
