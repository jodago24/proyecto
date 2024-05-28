package com.registro.usuarios.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

	// Servicio de usuario para manejar la lógica de negocio relacionada con los usuarios
	private UsuarioServicio usuarioServicio;

	// Constructor para la inyección del servicio de usuario
	public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}

	// Método para añadir un nuevo UsuarioRegistroDTO al modelo de la vista
	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}

	// Maneja la solicitud GET para mostrar el formulario de registro
	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}

	// Maneja la solicitud POST para registrar un nuevo usuario
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
		// Guarda el nuevo usuario utilizando el servicio de usuario
		usuarioServicio.guardar(registroDTO);
		// Redirige a la misma página de registro con un parámetro de éxito
		return "redirect:/registro?exito";
	}
}
