
package cibertec.DAWII_CL2_ChristopherParattoriCruz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.DAWII_CL2_ChristopherParattoriCruz.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	 Rol findByNomrol(String nomrol);
}
