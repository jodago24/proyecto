package com.registro.usuarios.modelo;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

// Indica que esta clase es una entidad JPA
@Entity
// Especifica la tabla en la base de datos que se mapeará a esta entidad y define una restricción única en el campo "email"
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

	// Especifica el campo 'id' como la clave primaria de la entidad
	@Id
	// Configura la generación automática del valor del ID usando la estrategia de identidad
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Columna para almacenar el nombre del usuario
	@Column(name = "nombre")
	private String nombre;

	// Columna para almacenar el apellido del usuario
	@Column(name = "apellido")
	private String apellido;

	// Columna para almacenar el email del usuario, con restricción única
	private String email;

	// Columna para almacenar la contraseña del usuario
	private String password;

	// Define una relación muchos a muchos con la entidad 'Rol'
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
	)
	private Collection<Rol> roles;

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

	// Método getter para la colección de roles del usuario
	public Collection<Rol> getRoles() {
		return roles;
	}

	// Método setter para la colección de roles del usuario
	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	// Constructor con parámetros para inicializar todos los atributos de la clase
	public Usuario(Long id, String nombre, String apellido, String email, String password, Collection<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	// Constructor con parámetros excepto el ID, útil para nuevos registros donde el ID aún no existe
	public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	// Constructor por defecto
	public Usuario() {

	}
}
