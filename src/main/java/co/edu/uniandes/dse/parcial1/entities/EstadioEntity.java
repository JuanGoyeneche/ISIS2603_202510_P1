package co.edu.uniandes.dse.parcial1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class EstadioEntity extends BaseEntity {

    private String ciudad;
    private int capacidad;
    private int precioAlquiler;

    @PodamExclude
    @ManyToOne
    private ConciertoEntity conciertoEntity;

}
