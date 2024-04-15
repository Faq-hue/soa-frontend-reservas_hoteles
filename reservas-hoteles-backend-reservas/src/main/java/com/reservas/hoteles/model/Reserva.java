package com.reservas.hoteles.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReserva;
	
	@Column(nullable = false)
	private Long idHotel;
	
	@Column(nullable = false)
	private Long idUsuario;
	
	@Column(nullable = false)
    private String fechaInicio;
	
	@Column(nullable = false)
	private int habitaciones;
	
	@Column(nullable = false)
    private int pasajeros;
	
	@Column(nullable = false)
    private float precio;
	
}