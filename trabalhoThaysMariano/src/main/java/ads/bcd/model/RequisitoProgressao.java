package ads.bcd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class RequisitoProgressao {

    @Id
    @NonNull
    private Integer idRequisitoProgressao;

    @NonNull
    private String descricao;

    protected RequisitoProgressao(){};



}
