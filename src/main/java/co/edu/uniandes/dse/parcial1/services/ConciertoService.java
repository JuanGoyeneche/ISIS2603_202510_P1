package co.edu.uniandes.dse.parcial1.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcial1.repositories.ConciertoRepository;
import co.edu.uniandes.dse.parcial1.repositories.EstadioRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConciertoService {

    @Autowired
    ConciertoRepository conciertoRepository;

    @Transactional
    public ConciertoEntity crearConcierto(ConciertoEntity conciertoEntity) throws IllegalOperationException {
        log.info("Inicia proceso de creación de la editorial");
        if (conciertoEntity.getPresupuesto() < 1000) {
            throw new IllegalOperationException("error");
        }

        LocalDateTime var1 = LocalDateTime.now();
        if (conciertoEntity.getFechaConcierto() != var1) {
            throw new IllegalOperationException("Mal teimpo");
        }

        if (conciertoEntity.getCapacidad() < 10) {
            throw new IllegalOperationException("error");
        }

        log.info("Termina proceso de creación de la editorial");
        return conciertoRepository.save(conciertoEntity);

    }
}
