package com.reservas.hoteles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.hoteles.model.Hotel;
import com.reservas.hoteles.repository.IHotelRepository;

@RestController
@RequestMapping("/api/v1")
public class HotelController {
	@Autowired
	private IHotelRepository repository;
	
	@GetMapping("/hoteles")
	public List<Hotel> getHoteles(){
		return repository.findAll();
	}
}
