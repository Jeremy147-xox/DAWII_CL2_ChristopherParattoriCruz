package cibertec.DAWII_CL2_ChristopherParattoriCruz.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import cibertec.DAWII_CL2_ChristopherParattoriCruz.model.Usuario;
import cibertec.DAWII_CL2_ChristopherParattoriCruz.services.UsuarioService;
import jakarta.servlet.http.HttpSession;


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
    public String guardarUsuario(@ModelAttribute Usuario usuario, HttpSession session){
    	Usuario usuarioregistrado = usuarioService.guardarUsuario(usuario);
    	session.setAttribute("usuarioLogeado", usuarioregistrado);
    	return "/Auth/frmLogin";
    }
    

    @GetMapping("/principal")
    public String home(Model model, Principal principal) {
        
    	String username = principal.getName(); // Obtiene el nombre de usuario del Principal
        Usuario usuarioLogeado = usuarioService.buscarUsuarioPorNomusuario(username); // Obtén el usuario utilizando el nombre de usuario
        model.addAttribute("usuario", usuarioLogeado);
        return "Auth/principal";
    }

}
