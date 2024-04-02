package com.reservas.hoteles.business;

import java.util.List;

import com.reservas.hoteles.model.Reserva;

public interface IReservaBusiness {
	public Reserva add(Reserva reserva);
	public List<Reserva> list();
	public Reserva update(Reserva reserva);
	public void delete(long id);
}
