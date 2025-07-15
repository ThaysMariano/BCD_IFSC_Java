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
public class RequisitoCumpridoProgressao {
    @Id
    @NonNull
    private RequisitoCumpridoProgressaoId idRequisitoCumpridoProgressao;

    @NonNull
    private Date data;

    protected RequisitoCumpridoProgressao(){}

    // N .. 1  com RequisitoProgresso
    @ManyToOne
    @JoinColumn(name = "idRequisitoProgressao", nullable = false)
    private RequisitoProgressao reqProgressao;

    // N .. 1 com Jovem
    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;


}
