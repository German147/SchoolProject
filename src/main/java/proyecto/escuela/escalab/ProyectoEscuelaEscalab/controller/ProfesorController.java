package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Profesor;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ProfesorService;

import java.util.List;

@RestController
@RequestMapping("api/v1/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public @ResponseBody
    List<Profesor> findAll() {
        return profesorService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Profesor findById(@PathVariable("id") Integer id) {
        return profesorService.findById(id);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('profesor:write')")
    public @ResponseBody
    Profesor save(@RequestBody Profesor profesor) {
        return profesorService.save(profesor);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('profesor:write')")
    public @ResponseBody
    Profesor update(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
        return profesorService.update(profesor, id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('profesor:write')")
    public void deleteById(@PathVariable("id") Integer id) {
        profesorService.deleteById(id);
    }



}
