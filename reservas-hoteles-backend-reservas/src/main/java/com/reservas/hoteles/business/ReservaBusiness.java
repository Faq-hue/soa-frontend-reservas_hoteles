package com.reservas.hoteles.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservas.hoteles.exception.BusinessException;
import com.reservas.hoteles.model.Reserva;
import com.reservas.hoteles.repository.IReservaRepository;

@Service
public class ReservaBusiness implements IReservaBusiness {

    @Autowired
    private IReservaRepository reservaDAO;

    @Override
    public Reserva add(Reserva reserva) throws BusinessException {
        try {
            return reservaDAO.save(reserva);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public Optional<Reserva> load(long id) throws BusinessException {
        try {
            Optional<Reserva> r;
            r = reservaDAO.findById(id);
            return r;
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<Reserva> list() throws BusinessException {
        try {
            return reservaDAO.findAll();
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public List<Reserva> listUsuario(long id) throws BusinessException {
        try {
            return reservaDAO.findByIdUsuario(id);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public Reserva update(Reserva reserva) throws BusinessException {
        try {
            return reservaDAO.save(reserva);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }

    @Override
    public void delete(long id) throws BusinessException {
        try {
            reservaDAO.deleteById(id);
        } catch (Exception e) {
            throw new BusinessException(e);
        }
    }
}
