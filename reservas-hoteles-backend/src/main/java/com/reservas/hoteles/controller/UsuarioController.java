package com.reservas.hoteles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.hoteles.model.Usuario;
import com.reservas.hoteles.repository.IUsuarioRepository;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	@Autowired
	private IUsuarioRepository repository;
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios(){
		return repository.findAll();
	}

}
