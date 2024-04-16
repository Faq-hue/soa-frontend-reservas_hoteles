package com.reservas.hoteles.controller;

import java.util.Optional;

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
import org.springframework.web.client.RestTemplate;

import com.reservas.hoteles.business.IReservaBusiness;
import com.reservas.hoteles.exception.BusinessException;
import com.reservas.hoteles.model.Hotel;
import com.reservas.hoteles.model.Reserva;
import com.reservas.hoteles.model.Usuario;
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
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "listUsuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listUsuario(@PathVariable("id") long id) {
		try {
			return new ResponseEntity<>(reservaBusiness.listUsuario(id), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> load(@PathVariable("id") long id) {
		try {
			Optional<Reserva> opR = reservaBusiness.load(id);

			Reserva r = opR.get();

			Hotel hotel = obtenerHotel(r.getIdHotel());

			Usuario usuario = obtenerUsuario(r.getIdUsuario());

            String jsonResponse = "{ \"idReserva\": " + r.getIdReserva() +
                                  ", \"fechaInicio\": \"" + r.getFechaInicio() +
                                  "\", \"habitaciones\": " + r.getHabitaciones() +
                                  ", \"pasajeros\": " + r.getPasajeros() +
                                  ", \"precio\": " + r.getPrecio() +
                                  ", \"nombreHotel\": \"" + hotel.getNombre() +
                                  "\", \"usernameUsuario\": \"" + usuario.getUsername() + "\" }";

			return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(responseBusiness.build(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
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

	private Hotel obtenerHotel(long idHotel) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8181/api/v1/hotel/" + idHotel, Hotel.class);
	}

	private Usuario obtenerUsuario(long idUsuario) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8182/api/v1/usuario/" + idUsuario, Usuario.class);
	}

}
