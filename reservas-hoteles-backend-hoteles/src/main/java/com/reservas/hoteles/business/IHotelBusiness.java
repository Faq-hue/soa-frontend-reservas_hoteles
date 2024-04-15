package com.reservas.hoteles.business;

import java.util.List;
import java.util.Optional;

import com.reservas.hoteles.exception.BusinessException;
import com.reservas.hoteles.model.Hotel;

public interface IHotelBusiness {
	public List<Hotel> loadBusqueda(String busqueda) throws BusinessException;
	public Optional<Hotel> load(long id) throws BusinessException;
	public List<Hotel> list() throws BusinessException;
	public Hotel add(Hotel hotel) throws BusinessException;
	public Hotel update(Hotel hotel) throws BusinessException;
	public void delete(long id) throws BusinessException;
}
