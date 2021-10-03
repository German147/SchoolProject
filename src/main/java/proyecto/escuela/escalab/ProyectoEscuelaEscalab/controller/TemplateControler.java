package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateControler {

    @GetMapping("login")
    public String getLoginView(){
        return "login";
    }

    @GetMapping("school")
    public String getSchoolView(){
        return "school";
    }
}
