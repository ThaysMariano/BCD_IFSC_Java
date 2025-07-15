package ads.bcd.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class RequisitoCumpridoEspecialidade {

    @Id
    @NonNull
    private RequisitocCumpridoEspecialidadeId idRequisitoEspecialidade;

    @NonNull
    private Date data;
}
