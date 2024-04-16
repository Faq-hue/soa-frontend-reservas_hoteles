package com.reservas.hoteles.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

	private long idHotel;

    private String ubicacion;

    private int habitaciones;

    private float precio;

    private String nombre;
	
}
