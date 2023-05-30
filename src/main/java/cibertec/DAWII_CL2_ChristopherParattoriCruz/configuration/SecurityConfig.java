package cibertec.DAWII_CL2_ChristopherParattoriCruz.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import cibertec.DAWII_CL2_ChristopherParattoriCruz.services.UsuarioDetalleService;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private final UsuarioDetalleService usuarioDetalleService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .requestMatchers(
                    "/auth/login",
                    "/auth/registrar",
                    "/auth/principal",
                    "/auth/guardarUsuario",
                    "/resources/**",
                    "/static/**",
                    "/js/**",
                    "/css/**"
                )
                .permitAll()
            .anyRequest()
                .authenticated()
            .and()
            .formLogin()
                .loginPage("/auth/login")
                .defaultSuccessUrl("/auth/principal")
                .usernameParameter("nomusuario")
                .passwordParameter("password")
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/auth/login?logout") // Redirige a la página de inicio de sesión después del logout exitoso
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .clearAuthentication(true) // Limpia la autenticación después del logout
            .permitAll()
            .and()
            .authenticationProvider(authenticationProvider());

        return http.build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider =
                new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(usuarioDetalleService);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationProvider;
    }

}
