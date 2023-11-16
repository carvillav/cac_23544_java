package ar.com.codoacodo.entity;

import java.time.LocalDate;

public class Orador {
	
	//Atributos
	private Long id;
	private String nombre;
	private String apellido;
	private String mail;
	private String tema;
	private LocalDate fechaAlta;
	
	//Constructor
	//Uso cuando envío un onjeto a la DB
	//Alt + Shift + s Para elegir generar constructor
	public Orador(String nombre, String apellido, String mail, String tema, LocalDate fechaAlta) {
		init(nombre, apellido, mail, tema, fechaAlta);
	}

	//Uso cuando recibo datos de la BD
	public Orador(Long id, String nombre, String apellido, String mail, String tema, LocalDate fechaAlta) {
		this.id = id;
		init(nombre, apellido, mail, tema, fechaAlta);
	}
		
	private void init(String nombre, String apellido, String mail, String tema, LocalDate fechaAlta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.tema = tema;
		this.fechaAlta = fechaAlta;
		//alt+shift+m para generar este init
	}

	//Cambiar el método toString de la clase Object
	@Override
	public String toString() {
		return "Orador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", tema="
				+ tema + ", fechaAlta=" + fechaAlta + "]";
	}

	//getters - setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	
}
