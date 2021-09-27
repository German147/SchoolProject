package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.RegistroAcademicoDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.RegistroAcademico;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.RegistroAcademicoService;

import java.util.List;

@RestController
@RequestMapping("api/v1/registro_academico")
public class RegistroAcademicoController {

        @Autowired
        private RegistroAcademicoService registroAcademicoService;

        @GetMapping
        public @ResponseBody
        List<RegistroAcademico> findAll() {
                return registroAcademicoService.findAll();
        }

        @GetMapping("/{id}")
        public @ResponseBody
        RegistroAcademico findById(@PathVariable("id") Integer id) {
                return registroAcademicoService.findById(id);
        }

        @PostMapping("/save")
        @PreAuthorize("hasAuthority('registroacademico:write')")
        public @ResponseBody
        RegistroAcademico save(@RequestBody RegistroAcademico registroAcademico) {
            return registroAcademicoService.save(registroAcademico);
        }

        @PutMapping("/update/{id}")
        @PreAuthorize("hasAuthority('registroacademico:write')")
        public @ResponseBody
        RegistroAcademico update(@PathVariable("id") Integer id, @RequestBody RegistroAcademico registroAcademico) {
            return registroAcademicoService.update(registroAcademico, id);
        }

        @DeleteMapping("/delete/{id}")
        @PreAuthorize("hasAuthority('registroacademico:write')")
        public void deleteById(@PathVariable("id") Integer id) {
                registroAcademicoService.deleteById(id);
        }

        //se crea un dto para el acultamiento de datos importantes
        @GetMapping("/registroDTO")
        public List<RegistroAcademicoDTO> findAllRegistros(){
              //  List<RegistroAcademicoDTO> response = new ArrayList<>();
             //  List<RegistroAcademico> registroList = registroAcademicoService.findAll();
               return registroAcademicoService.findAllRegistros();
        };


}
