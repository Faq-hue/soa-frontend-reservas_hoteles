package com.reservas.hoteles.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reservas")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReserva;
	@Column(name = "idHotel")
	private Long idHotel;
	@Column(name = "idUsuario")
	private Long idUsuario;
	
	@Column(name = "fechaInicio")
    private String fechaInicio;
	@Column(name = "cantHabitaciones")
	private int cantHabitaciones;
	@Column(name = "cantPasajeros")
    private int cantPasajeros;
	@Column(name = "precioReserva")
    private float precio;
	public Reserva(Long idHotel, Long idUsuario, String fechaInicio, int cantHabitaciones, int cantPasajeros,
			float precio) {
		super();
		this.idHotel = idHotel;
		this.idUsuario = idUsuario;
		this.fechaInicio = fechaInicio;
		this.cantHabitaciones = cantHabitaciones;
		this.cantPasajeros = cantPasajeros;
		this.precio = precio;
	}
	public Long getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}
	public Long getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public int getCantPasajeros() {
		return cantPasajeros;
	}
	public void setCantPasajeros(int cantPasajeros) {
		this.cantPasajeros = cantPasajeros;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}