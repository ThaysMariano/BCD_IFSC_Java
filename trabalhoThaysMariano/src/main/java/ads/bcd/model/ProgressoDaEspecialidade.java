package ads.bcd.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class ProgressoDaEspecialidade {

    @Id
    @NonNull
    private ProgressoDaEspecialidadeId idProgressoDaEspecialidade;

    @NonNull
    private Integer nivel;

    protected ProgressoDaEspecialidade(){};


}
