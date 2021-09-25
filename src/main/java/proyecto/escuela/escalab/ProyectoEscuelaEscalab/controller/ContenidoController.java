package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Contenido;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ContenidoService;

import java.util.List;

@RestController
@RequestMapping("/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public @ResponseBody
    List<Contenido> findAll() {
        return contenidoService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Contenido findById(@PathVariable("id") Integer id) {
        return contenidoService.findById(id);
    }

    @PostMapping("/save")
    public @ResponseBody
    Contenido save(@RequestBody Contenido contenido) {
        return contenidoService.save(contenido);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody
    Contenido update(@PathVariable("id") Integer id, @RequestBody Contenido contenido) {
        return contenidoService.update(contenido, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        contenidoService.deleteById(id);
    }

}
