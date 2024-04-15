package com.reservas.hoteles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reservas.hoteles.model.Reserva;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Long>{
    @Query(value = "SELECT * FROM reservas WHERE reservas.id_usuario = ?", nativeQuery = true)
    public List<Reserva> findByIdUsuario(long id);
}
