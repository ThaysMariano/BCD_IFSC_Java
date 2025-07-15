package ads.bcd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class RequisitoCumpridoInsignia {

    @Id
    @NonNull
    private RequistiosCumpridosInsigniaId idRequisitoCumpridoInsignia;

    @NonNull
    private Date data;

    protected RequisitoCumpridoInsignia(){}

    //N .. 1 com Req insignia
    @ManyToOne
    @JoinColumn(name = "idRequisitoInsignia", nullable = false)

    // N .. 1 com Jovem
    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)

}
