package com.registro.usuarios.controlador;

import com.registro.usuarios.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.registro.usuarios.servicio.UsuarioServicio;

/**
 * Controlador que maneja las operaciones relacionadas con el registro y gestión de usuarios.
 */
@Controller
public class RegistroControlador {

	// Inyección de la dependencia del servicio de usuario
	@Autowired
	private UsuarioServicio servicio;

	// Inyección de la dependencia del codificador de contraseñas
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/**
	 * Maneja la solicitud GET para la página de inicio de sesión.
	 *
	 * @return Nombre de la vista "login".
	 */
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}

	/**
	 * Maneja la solicitud GET para la página de inicio.
	 *
	 * @param modelo Modelo para agregar atributos a la vista.
	 * @return Nombre de la vista "Inicio".
	 */
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		return "index";
	}

	/**
	 * Maneja la solicitud GET para la página de alimentación.
	 *
	 * @param modelo Modelo para agregar atributos a la vista.
	 * @return Nombre de la vista "alimentacion".
	 */
	@GetMapping("/alimentacion")
	public String verPaginaDealimentacion(Model modelo) {
		return "alimentacion";
	}

	/**
	 * Maneja la solicitud GET para la página de ejercicio.
	 *
	 * @param modelo Modelo para agregar atributos a la vista.
	 * @return Nombre de la vista "ejercicio".
	 */
	@GetMapping("ejercicio")
	public String verPaginaDeejercicio(Model modelo) {
		return "ejercicio";
	}

	/**
	 * Maneja la solicitud GET para la página de inicio (alias "Inicio").
	 *
	 * @param modelo Modelo para agregar atributos a la vista.
	 * @return Nombre de la vista "index".
	 */
	@GetMapping("Inicio")
	public String verPaginaDeindex(Model modelo) {
		return "index";
	}

	@GetMapping("English")
	public String verPaginaDeEnalimentacion(Model modelo) {
		return "alimentacionEn";
	}

	@GetMapping("EnglisH")
	public String verPaginaDeEnejercicio(Model modelo) {
		return "ejercicioEn";
	}
}






