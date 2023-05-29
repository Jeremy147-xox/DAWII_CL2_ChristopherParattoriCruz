package cibertec.DAWII_CL2_ChristopherParattoriCruz.services;


import java.util.Arrays;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;


import cibertec.DAWII_CL2_ChristopherParattoriCruz.model.Rol;
import cibertec.DAWII_CL2_ChristopherParattoriCruz.model.Usuario;
import cibertec.DAWII_CL2_ChristopherParattoriCruz.repository.RolRepository;
import cibertec.DAWII_CL2_ChristopherParattoriCruz.repository.UsuarioRepository;

@Service
public class UsuarioService  {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder
            = new BCryptPasswordEncoder();

    public Usuario buscarUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
    public Usuario buscarUsuarioPorNomusuario(String nomUsuario){
        return usuarioRepository.findByNomusuario(nomUsuario);
    }
    public Usuario guardarUsuario(Usuario usuario){
        usuario.setPassword(bCryptPasswordEncoder
                .encode(usuario.getPassword()));
        usuario.setActivo(true);
        Rol rol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<Rol>(Arrays.asList(rol)));
        return usuarioRepository.save(usuario);
    }
}
