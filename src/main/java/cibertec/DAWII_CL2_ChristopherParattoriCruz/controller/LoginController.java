package cibertec.DAWII_CL2_ChristopherParattoriCruz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cibertec.DAWII_CL2_ChristopherParattoriCruz.model.Usuario;
import cibertec.DAWII_CL2_ChristopherParattoriCruz.services.UsuarioService;


@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/login")
    public String login(){
        return "Auth/frmLogin";
    }
    @GetMapping("/registrar")
    public String registrar(){
        return "Auth/frmRegistroUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return "Auth/principal";
    }
    
    @GetMapping("/principal")
    public String home(Model model){
    	return "Auth/principal";
    }

}
