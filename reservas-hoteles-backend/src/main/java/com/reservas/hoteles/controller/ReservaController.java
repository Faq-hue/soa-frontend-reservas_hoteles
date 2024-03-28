package com.reservas.hoteles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.hoteles.model.Reserva;
import com.reservas.hoteles.repository.IReservaRepository;

///TODO hacer metodo add reserva

@RestController
@RequestMapping("/api/v1")
public class ReservaController {
	@Autowired
	private IReservaRepository repository;
	
	@GetMapping("/reservas")
	public List<Reserva> getReservas(){
		return repository.findAll();
	}
}
