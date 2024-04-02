package com.reservas.hoteles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservas.hoteles.model.Hotel;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel,Long>{
	public List<Hotel> findByNombre(String nombre);
	
	public List<Hotel> findByUbicacion(String ubicacion);
}
