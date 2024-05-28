package com.registro.usuarios.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// Constructor para la inyección del repositorio de usuarios
	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	// Método para guardar un nuevo usuario a partir de un DTO de registro
	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		// Crea un nuevo usuario con los datos del DTO y asigna el rol "ROLE_USER"
		Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getEmail(),
				passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
		// Guarda el usuario en el repositorio
		return usuarioRepositorio.save(usuario);
	}

	// Método para cargar un usuario por su nombre de usuario (email)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Busca el usuario en el repositorio por su email
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		// Si el usuario no existe, lanza una excepción de usuario no encontrado
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		// Crea un UserDetails con el email, contraseña y roles del usuario
		return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	// Método privado para mapear los roles del usuario a objetos GrantedAuthority
	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}

	// Método para listar todos los usuarios
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}
}
