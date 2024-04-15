package com.reservas.hoteles.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reservas.hoteles.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "SELECT * FROM usuarios WHERE usuarios.username = ?", nativeQuery = true)
    public Optional<Usuario> findByUsername(String nombre);
}
