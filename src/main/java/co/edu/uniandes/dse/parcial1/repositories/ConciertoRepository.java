package co.edu.uniandes.dse.parcial1.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;

@Repository
public interface ConciertoRepository extends JpaRepository<ConciertoEntity, Long> {

    List<ConciertoEntity> findByName(String name);

    List<ConciertoEntity> findByDate(Date date);

    List<ConciertoEntity> findByCapacidad(int capacidad);

    List<ConciertoEntity> findByPresupuesto(Long presu);

}
