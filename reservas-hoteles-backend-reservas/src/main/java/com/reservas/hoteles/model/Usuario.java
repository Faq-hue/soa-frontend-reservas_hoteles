package com.reservas.hoteles.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	private Long id;
	
	private String username;

	private String nombre;	

	private String apellido;
	
	private String pwd;

}
