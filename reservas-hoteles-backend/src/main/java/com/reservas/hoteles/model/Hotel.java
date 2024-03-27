package com.reservas.hoteles.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hoteles")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHotel;
	@Column(name = "ubicacion")
    private String ubicacion;
	@Column(name = "cantHabitaciones")
    private int cantHabitaciones;
	@Column(name = "precio")
    private float precio;
	
	@Column(name = "nombre")
    private String nombre;
	public Hotel(String nombre, String ubicacion, int cantHabitaciones, float precio) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.cantHabitaciones = cantHabitaciones;
		this.precio = precio;
	}
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
	public int getCantHabitaciones() {
		return cantHabitaciones;
	}
	public void setCantHabitaciones(int cantHabitaciones) {
		this.cantHabitaciones = cantHabitaciones;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
