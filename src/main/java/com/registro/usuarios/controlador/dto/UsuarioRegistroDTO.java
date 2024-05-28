package com.registro.usuarios.controlador.dto;

// Clase DTO (Data Transfer Object) para manejar los datos de registro de usuarios
public class UsuarioRegistroDTO {

	// Atributo para almacenar el ID del usuario
	private Long id;
	// Atributo para almacenar el nombre del usuario
	private String nombre;
	// Atributo para almacenar el apellido del usuario
	private String apellido;
	// Atributo para almacenar el email del usuario
	private String email;
	// Atributo para almacenar la contraseña del usuario
	private String password;

	// Método getter para el ID del usuario
	public Long getId() {
		return id;
	}

	// Método setter para el ID del usuario
	public void setId(Long id) {
		this.id = id;
	}

	// Método getter para el nombre del usuario
	public String getNombre() {
		return nombre;
	}

	// Método setter para el nombre del usuario
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Método getter para el apellido del usuario
	public String getApellido() {
		return apellido;
	}

	// Método setter para el apellido del usuario
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	// Método getter para el email del usuario
	public String getEmail() {
		return email;
	}

	// Método setter para el email del usuario
	public void setEmail(String email) {
		this.email = email;
	}

	// Método getter para la contraseña del usuario
	public String getPassword() {
		return password;
	}

	// Método setter para la contraseña del usuario
	public void setPassword(String password) {
		this.password = password;
	}

	// Constructor con parámetros para inicializar los atributos de la clase
	public UsuarioRegistroDTO(String nombre, String apellido, String email, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}

	// Constructor por defecto
	public UsuarioRegistroDTO() {

	}
}
