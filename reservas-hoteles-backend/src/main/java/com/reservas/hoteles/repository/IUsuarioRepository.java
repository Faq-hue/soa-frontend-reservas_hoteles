package com.reservas.hoteles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservas.hoteles.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

}
