package com.registro.usuarios.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Indica que esta clase es una entidad JPA (Java Persistence API)
@Entity
// Especifica la tabla en la base de datos que se mapeará a esta entidad
@Table(name = "rol")
public class Rol {

	// Especifica el campo 'id' como la clave primaria de la entidad
	@Id
	// Configura la generación automática del valor del ID usando la estrategia de identidad
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Campo para almacenar el nombre del rol
	private String nombre;

	// Método getter para el ID del rol
	public Long getId() {
		return id;
	}

	// Método setter para el ID del rol
	public void setId(Long id) {
		this.id = id;
	}

	// Método getter para el nombre del rol
	public String getNombre() {
		return nombre;
	}

	// Método setter para el nombre del rol
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Constructor con parámetros para inicializar todos los atributos de la clase
	public Rol(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// Constructor por defecto
	public Rol() {

	}

	// Constructor con un parámetro para inicializar solo el nombre del rol
	public Rol(String nombre) {
		super();
		this.nombre = nombre;
	}
}
