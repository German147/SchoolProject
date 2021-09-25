package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.TomaAsignaturaDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.TomaAsignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.TomaAsignaturaService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/toma_asignatura")
public class TomaAsignaturaController {

    @Autowired
    private TomaAsignaturaService tomaAsignaturaService;

    @GetMapping
    public @ResponseBody
    List<TomaAsignatura> findAll() {
        return tomaAsignaturaService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    TomaAsignatura findById(@PathVariable("id") Integer id) {
        return tomaAsignaturaService.findById(id);
    }

    @PostMapping("/save")
    public @ResponseBody
    TomaAsignatura save(@RequestBody TomaAsignatura tomaAsignatura) {
        return tomaAsignaturaService.save(tomaAsignatura);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody
    TomaAsignatura update(@PathVariable("id") Integer id, @RequestBody TomaAsignatura tomaAsignatura) {
        return tomaAsignaturaService.update(tomaAsignatura, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        tomaAsignaturaService.deleteById(id);
    }

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
