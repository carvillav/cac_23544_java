package ar.com.codoacodo;

import java.time.LocalDate;

public class Auto {
	/*Atributos*/
	String marca;
	String modelo;
	String color;
	Integer anio;
	Float velocidad;
	Float velocidadMaxima;
	Boolean encendido;
	String dominio;
	LocalDate fechaCreacion;
	
	/*Constructor*/
	Auto(
			String marca, 
			String modelo,
			String color,
			Integer anio,
			String dominio,
			Float velocidadMaxima
			) {
			velocidad = 0f;
			encendido = Boolean.FALSE;
			fechaCreacion = LocalDate.now();
			//this es un puntero que "apunta" a los atributos o metodos de un clase/objeto
			this.marca = marca;
			this.modelo = modelo;
			this.color = color;
			this.anio = anio;
			this.dominio= dominio;
			this.velocidadMaxima = velocidadMaxima;
		}
	
	/*Metodos*/
	void encender() {
		if(!this.encendido) {
			this.encendido = Boolean.TRUE;
		}else {
			System.out.println("Ya está encendido");
		}		
	}
	
	void apagado() {
		if(!this.encendido) {
			this.encendido = Boolean.FALSE;
		}else {
			System.out.println("Ya está apagado");
		}
	}
	
	void acelerar() {
		if(encendido) {
			if(velocidad < velocidadMaxima) {
				velocidad++;
			}else {
				System.out.println("Velocidad maxima: " + velocidad + " alcanzada");
			}
		}else {
			System.out.println("Primero debe encender el auto para acelerar");
		}
	}
	
	void frenar() {
		if(encendido) {
			if(velocidad > 0) {
				velocidad --;
			}else {
				System.out.println("La velocidad llego a 0");
			}
		}else {
			System.out.println("frenando con el auto apagado");
		}
	}
	
}
