package ads.bcd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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


}
