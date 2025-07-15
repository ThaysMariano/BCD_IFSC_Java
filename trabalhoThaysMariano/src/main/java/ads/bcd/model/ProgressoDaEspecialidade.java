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
public class ProgressoDaEspecialidade {

    @Id
    @NonNull
    private ProgressoDaEspecialidadeId idProgressoDaEspecialidade;

    @NonNull
    private Integer nivel;

    protected ProgressoDaEspecialidade(){};

    // N.. 1 com Jovem
    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

    // N.. 1 com especialidade
    @ManyToOne
    @JoinColumn(name = "idEspecialidade", nullable = false)
    private Especialidade especialidade;






}
