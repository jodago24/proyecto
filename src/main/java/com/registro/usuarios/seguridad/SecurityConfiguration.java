package com.registro.usuarios.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.registro.usuarios.servicio.UsuarioServicio;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioServicio usuarioServicio;

	// Define un bean para el codificador de contraseñas BCrypt
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Define un bean para el proveedor de autenticación DAO
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioServicio);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	// Configura la autenticación, utilizando el proveedor de autenticación DAO
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	// Configura la seguridad HTTP
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
						"/registro**",
						"/js/**",
						"/css/**",
						"/img/**").permitAll() // Permite el acceso sin autenticación a estas URL
				.anyRequest().authenticated() // Todas las demás solicitudes requieren autenticación
				.and()
				.formLogin() // Configura el formulario de inicio de sesión
				.loginPage("/login") // Página de inicio de sesión personalizada
				.permitAll() // Permite el acceso a la página de inicio de sesión sin autenticación
				.and()
				.logout() // Configura el logout
				.invalidateHttpSession(true) // Invalida la sesión HTTP existente
				.clearAuthentication(true) // Borra la autenticación actual
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Define la URL de logout
				.logoutSuccessUrl("/login?logout") // Redirige a la página de inicio de sesión después del logout
				.permitAll(); // Permite el acceso a la URL de logout sin autenticación
	}
}






