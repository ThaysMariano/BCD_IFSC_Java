package ads.bcd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class ProgressaoDaProgressao {

    @Id
    @NonNull
    private ProgressoDaProgressaoId idProgressao;

    @NonNull
    private Date data;

}
