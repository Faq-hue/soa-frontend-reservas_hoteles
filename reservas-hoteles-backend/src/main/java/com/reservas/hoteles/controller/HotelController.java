package com.reservas.hoteles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.hoteles.business.IHotelBusiness;
import com.reservas.hoteles.exception.BusinessException;
import com.reservas.hoteles.exception.ResourceNotFoundException;
import com.reservas.hoteles.model.Hotel;
import com.reservas.hoteles.utils.IStandardResponseBusiness;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

	@Autowired
	private IHotelBusiness hotelBusiness;

	@Autowired
	private IStandardResponseBusiness responseBusiness;
	
	@GetMapping(value = "/hoteles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> list() {
		return hotelBusiness.list();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> load(@PathVariable("id") long id) {
		try {
			return new ResponseEntity<>(hotelBusiness.load(id), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.NOT_FOUND, e, e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/busqueda/{busqueda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> loadBusqueda(@PathVariable("busqueda") String busqueda) {
		try {
			return new ResponseEntity<>(hotelBusiness.loadBusqueda(busqueda), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.NOT_FOUND, e, e.getMessage()), HttpStatus.NOT_FOUND);
		}
	} 
	
	@PostMapping(value = "")
	public ResponseEntity<?> add(@RequestBody Hotel hotel) {
		try {
			Hotel response = hotelBusiness.add(hotel);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("id", ""+response.getIdHotel());
			return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);
		} catch (BusinessException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Hotel hotel) {
		try {
			Hotel response = hotelBusiness.update(hotel);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("id", ""+response.getIdHotel());
			return new ResponseEntity<>(responseHeaders, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.NOT_FOUND, e, e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		try {
			hotelBusiness.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
}
