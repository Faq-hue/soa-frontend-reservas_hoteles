package com.reservas.hoteles.business;

import java.util.List;

import com.reservas.hoteles.exception.BusinessException;
import com.reservas.hoteles.exception.ResourceNotFoundException;
import com.reservas.hoteles.model.Reserva;

public interface IReservaBusiness {
	public Reserva add(Reserva reserva) throws BusinessException;
	public List<Reserva> list() throws ResourceNotFoundException;
	public List<Reserva> listUsuario() throws ResourceNotFoundException;
	public Reserva update(Reserva reserva) throws BusinessException;
	public void delete(long id) throws BusinessException;
}
