package com.reservas.hoteles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.hoteles.model.Hotel;
import com.reservas.hoteles.repository.IHotelRepository;

@RestController
@RequestMapping("/api/v1")
public class HotelController {
	@Autowired
	private IHotelRepository repository;
	
	@GetMapping(value = "/hoteles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> list(){
		return repository.findAll();
	}
	
	@PostMapping(value = "")
	public void addHotel(Hotel hotel) {
		repository.save(hotel);
	}
	
}
