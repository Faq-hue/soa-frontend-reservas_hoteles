package com.reservas.hoteles.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservas.hoteles.exception.BusinessException;
import com.reservas.hoteles.exception.ResourceNotFoundException;
import com.reservas.hoteles.model.Hotel;
import com.reservas.hoteles.repository.IHotelRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HotelBusiness implements IHotelBusiness{
	
	@Autowired
	private IHotelRepository hotelDAO;
	
	@Override
	public List<Hotel> loadBusqueda(String busqueda) {
		List<Hotel> hNombre = hotelDAO.findByNombre(busqueda);
		List<Hotel> hUbicacion = hotelDAO.findByUbicacion(busqueda);
		
		Set<Hotel> setCombined = new HashSet<>(hNombre);
		
		setCombined.addAll(hUbicacion);
		
		List<Hotel> listCombined = new ArrayList<>(setCombined);
		
		return listCombined;
	}

	@Override
	public Optional<Hotel> load(long id) throws ResourceNotFoundException {
		Optional<Hotel> r;
		
		r = hotelDAO.findById(id);
		
		return r;
	}

	@Override
	public List<Hotel> list() throws ResourceNotFoundException {
		return hotelDAO.findAll();
	}

	@Override
	public Hotel add(Hotel hotel) {
		return hotelDAO.save(hotel);
	}

	@Override
	public Hotel update(Hotel hotel) {
		return null;
	}

	@Override
	public void delete(long id) throws BusinessException{
		load(id);
		try {
			hotelDAO.deleteById(id);
		} catch (Exception e){
			throw e;
		}
	}

}
