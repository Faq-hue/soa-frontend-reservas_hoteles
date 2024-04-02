package com.reservas.hoteles.business;

import java.util.List;
import java.util.Optional;

import com.reservas.hoteles.exception.BusinessException;
import com.reservas.hoteles.exception.ResourceNotFoundException;
import com.reservas.hoteles.model.Usuario;

public interface IUsuarioBusiness {
	public Usuario add(Usuario usuario) throws BusinessException;
	public Optional<Usuario> load(long id) throws ResourceNotFoundException;
	public Optional<Usuario> loadByUsername(String username) throws ResourceNotFoundException;
	public List<Usuario> list() throws ResourceNotFoundException;
	public Usuario update(Usuario usuario) throws BusinessException;
	public void delete(long id) throws BusinessException;
}
