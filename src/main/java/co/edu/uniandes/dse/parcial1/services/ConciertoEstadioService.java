package co.edu.uniandes.dse.parcial1.services;

import java.time.Duration;
import java.util.Optional;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;
import co.edu.uniandes.dse.parcial1.entities.EstadioEntity;
import co.edu.uniandes.dse.parcial1.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcial1.repositories.ConciertoRepository;
import co.edu.uniandes.dse.parcial1.repositories.EstadioRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConciertoEstadioService {

    @Autowired
    ConciertoRepository conciertoRepository;

    @Autowired
    EstadioRepository estadioRepository;

    @Transactional
    public ConciertoEntity addConcierto(Long conciertoId, Long estadioId)
            throws EntityNotFoundException, IllegalOperationException {
        log.info("Inicia proceso de asociar el autor con id = {0} al premio con id = " + estadioId, conciertoId);
        Optional<ConciertoEntity> conciertoEntity = conciertoRepository.findById(conciertoId);
        if (conciertoEntity.isEmpty())
            throw new EntityNotFoundException("ERROR");

        Optional<EstadioEntity> estadioEntity = estadioRepository.findById(estadioId);
        if (estadioEntity.isEmpty())
            throw new EntityNotFoundException("ERROR");

        if (estadioEntity.get().getCapacidad() < conciertoEntity.get().getCapacidad()) {
            throw new IllegalOperationException("ERROR");
        }

        if (estadioEntity.get().getPrecioAlquiler() > conciertoEntity.get().getPresupuesto()) {
            throw new IllegalOperationException("ERROR");
        }

        // Duration var1 = Duration.between(conciertoEntity.get().getConciertos(),
        // conciertoEntity.get().getConciertos());
        if (estadioEntity.get().getPrecioAlquiler() > conciertoEntity.get().getPresupuesto()) {
            throw new IllegalOperationException("ERROR");
        }

        estadioEntity.get().setConciertoEntity(conciertoEntity.get());
        log.info("Termina proceso de asociar el autor con id = {0} al premio con id = {1}", conciertoId, estadioId);
        return conciertoEntity.get();
    }

}
