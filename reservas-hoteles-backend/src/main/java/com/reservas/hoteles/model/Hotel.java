package com.reservas.hoteles.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoteles")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "ubicacion")
    private String ubicacion;
	@Column(name = "habitaciones")
    private int habitaciones;
	@Column(name = "precio")
    private float precio;
	@Column(name = "imagenes")
    private String img;
	@Column(name = "nombre")
    private String nombre;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}    
}
