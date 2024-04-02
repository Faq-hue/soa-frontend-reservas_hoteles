package com.reservas.hoteles.business;

import java.util.List;

import com.reservas.hoteles.exception.ResourceNotFoundException;
import com.reservas.hoteles.model.Usuario;

public interface IUsuarioBusiness {
	public Usuario loadByUsername(String username) throws ResourceNotFoundException;
	public Usuario add(Usuario usuario);
	public List<Usuario> list();
	public Usuario update(Usuario usuario);
	public void delete(long id);
}
