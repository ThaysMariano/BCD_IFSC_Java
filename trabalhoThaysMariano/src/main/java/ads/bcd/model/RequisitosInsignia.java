package ads.bcd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class RequisitosInsignia {

    @Id
    @NonNull
    private Integer idRequisitoInsignia;

    @NonNull
    private String descricao;


}
