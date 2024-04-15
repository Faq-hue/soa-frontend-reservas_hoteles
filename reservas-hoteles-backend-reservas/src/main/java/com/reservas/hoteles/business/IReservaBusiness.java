package com.reservas.hoteles.business;

import java.util.List;
import java.util.Optional;

import com.reservas.hoteles.exception.BusinessException;
import com.reservas.hoteles.model.Reserva;

public interface IReservaBusiness {
	public Reserva add(Reserva reserva) throws BusinessException;
	public Optional<Reserva> load(long id) throws BusinessException;
	public List<Reserva> list() throws BusinessException;
	public List<Reserva> listUsuario(long id) throws BusinessException;
	public Reserva update(Reserva reserva) throws BusinessException;
	public void delete(long id) throws BusinessException;
}
