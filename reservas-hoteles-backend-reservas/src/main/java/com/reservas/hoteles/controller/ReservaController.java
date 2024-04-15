package com.reservas.hoteles.controller;

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

import com.reservas.hoteles.business.IReservaBusiness;
import com.reservas.hoteles.exception.BusinessException;
import com.reservas.hoteles.model.Reserva;
import com.reservas.hoteles.utils.IStandardResponseBusiness;

@RestController
@RequestMapping("/api/v1/reserva")
public class ReservaController {
    
    @Autowired
	private IReservaBusiness reservaBusiness;

	@Autowired
	private IStandardResponseBusiness responseBusiness;

    @GetMapping(value = "/reservas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> list() {
		try {
			return new ResponseEntity<>(reservaBusiness.list(), HttpStatus.OK);	
		} catch (BusinessException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	@GetMapping(value = "listUsuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listUsuario(@PathVariable("id") long id) {
		try{
			return new ResponseEntity<>(reservaBusiness.listUsuario(id), HttpStatus.OK);	
		} catch (BusinessException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> load(@PathVariable("id") long id) {
		try {
			return new ResponseEntity<>(reservaBusiness.load(id), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "")
	public ResponseEntity<?> add(@RequestBody Reserva reserva) {
		try {
			Reserva response = reservaBusiness.add(reserva);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("id", "" + response.getIdReserva());
			return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);
		} catch (BusinessException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Reserva reserva) {
		try {
			Reserva response = reservaBusiness.update(reserva);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("id", "" + response.getIdReserva());
			return new ResponseEntity<>(responseHeaders, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		try {
			reservaBusiness.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	

}
