package com.reservas.hoteles.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.reservas.hoteles.exception.BusinessException;
import com.reservas.hoteles.exception.ResourceNotFoundException;
import com.reservas.hoteles.model.Usuario;
import com.reservas.hoteles.repository.IUsuarioRepository;

public class UsuarioBusiness implements IUsuarioBusiness {

    @Autowired
    private IUsuarioRepository usuarioDAO;

    @Override
    public Usuario add(Usuario usuario) throws BusinessException {
        try {
            return usuarioDAO.save(usuario);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public Optional<Usuario> load(long id) throws ResourceNotFoundException {
        try {
            Optional<Usuario> r;
            r = usuarioDAO.findById(id);
            return r;
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @Override
    public Optional<Usuario> loadByUsername(String username) throws ResourceNotFoundException {
        try {
            Optional<Usuario> r;
            r = usuarioDAO.findByUsername(username);
            return r;
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @Override
    public List<Usuario> list() throws ResourceNotFoundException {
        try {
            List<Usuario> users = usuarioDAO.findAll();
            return users;
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @Override
    public Usuario update(Usuario usuario) throws BusinessException {
        try {
            return usuarioDAO.save(usuario);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public void delete(long id) throws BusinessException {
        load(id);
        try {
            usuarioDAO.deleteById(id);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }
}
