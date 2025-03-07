package co.edu.uniandes.dse.parcial1.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;
import co.edu.uniandes.dse.parcial1.entities.EstadioEntity;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcial1.repositories.ConciertoRepository;
import co.edu.uniandes.dse.parcial1.repositories.EstadioRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EstadioService {

    @Autowired
    EstadioRepository estadioRepository;

    @Transactional
    public EstadioEntity crearEstadio(EstadioEntity estadioEntity) throws IllegalOperationException {
        log.info("Inicia proceso de creación de la editorial");
        if (estadioEntity.getCiudad().length() < 3) {
            throw new IllegalOperationException("error");
        }

        if (estadioEntity.getPrecioAlquiler() < 100000) {
            throw new IllegalOperationException("Mal teimpo");
        }

        if (estadioEntity.getCapacidad() < 1000) {
            throw new IllegalOperationException("error");
        }

        log.info("Termina proceso de creación de la editorial");
        return estadioRepository.save(estadioEntity);

    }
}
