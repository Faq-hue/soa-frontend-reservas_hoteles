package com.reservas.hoteles.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservas.hoteles.exception.BusinessException;
import com.reservas.hoteles.model.Usuario;
import com.reservas.hoteles.repository.IUsuarioRepository;

@Service
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
    public Optional<Usuario> load(long id) throws BusinessException {
        try {
            Optional<Usuario> r;
            r = usuarioDAO.findById(id);
            return r;
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public Optional<Usuario> loadByUsername(String username) throws BusinessException {
        try {
            Optional<Usuario> r;
            r = usuarioDAO.findByUsername(username);
            return r;
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<Usuario> list() throws BusinessException {
        try {
            return usuarioDAO.findAll();
        } catch (Exception e) {
            throw new BusinessException(e);
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
        try {
            usuarioDAO.deleteById(id);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }
}
