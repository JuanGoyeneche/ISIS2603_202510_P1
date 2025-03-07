package co.edu.uniandes.dse.parcial1.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class ConciertoEntity extends BaseEntity {

    private String name;
    @Temporal(TemporalType.DATE)
    private LocalDateTime fechaConcierto;
    private int capacidad;
    private Long presupuesto;

    @PodamExclude
    @OneToMany(mappedBy = "estadio", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<EstadioEntity> conciertos = new ArrayList<>();
}
