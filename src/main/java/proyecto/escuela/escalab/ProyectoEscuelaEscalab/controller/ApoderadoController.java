package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Apoderado;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ApoderadoService;

import java.util.List;

@RestController
@RequestMapping("api/v1/apoderados")
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
    @PreAuthorize("hasAuthority('apoderado:write')")
    public @ResponseBody
    Apoderado save(@RequestBody Apoderado apoderado) {
        return apoderadoService.save(apoderado);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('apoderado:write')")
    public @ResponseBody
    Apoderado update(@PathVariable("id") Integer id, @RequestBody Apoderado apoderado) {
        return apoderadoService.update(apoderado, id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('apoderado:write')")
    public void deleteById(@PathVariable("id") Integer id) {
        apoderadoService.deleteById(id);
    }
}
