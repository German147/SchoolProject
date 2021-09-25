package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.FichaMedica;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.FichaMedicaService;

import java.util.List;

@RestController
@RequestMapping("/ficha_medica")
public class FichaMedicaController {

    @Autowired
    private FichaMedicaService fichaMedicaService;

    @GetMapping
    public @ResponseBody
    List<FichaMedica> findAll() {
        return fichaMedicaService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    FichaMedica findById(@PathVariable("id") Integer id) {
        return fichaMedicaService.findById(id);
    }

    @PostMapping("/save")
    public @ResponseBody
    FichaMedica save(@RequestBody FichaMedica fichaMedica) {
        return fichaMedicaService.save(fichaMedica);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody
    FichaMedica update(@PathVariable("id") Integer id, @RequestBody FichaMedica fichaMedica) {
        return fichaMedicaService.update(fichaMedica, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        fichaMedicaService.deleteById(id);
    }

}
