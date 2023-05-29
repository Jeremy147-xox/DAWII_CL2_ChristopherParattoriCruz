package cibertec.DAWII_CL2_ChristopherParattoriCruz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.DAWII_CL2_ChristopherParattoriCruz.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);
    Usuario findByNomusuario(String nomusuario);
}
