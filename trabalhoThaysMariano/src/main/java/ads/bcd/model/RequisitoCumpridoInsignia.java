package ads.bcd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
}
