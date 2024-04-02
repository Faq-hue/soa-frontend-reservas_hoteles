package com.reservas.hoteles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reservas.hoteles.model.Hotel;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel,Long>{
	@Query(value = "SELECT * FROM hoteles WHERE hoteles.nombre = ?", nativeQuery = true)
	public List<Hotel> findByNombre(String nombre);
	
	@Query(value = "SELECT * FROM hoteles WHERE hoteles.ubicacion = ?", nativeQuery = true)
	public List<Hotel> findByUbicacion(String ubicacion);
}
