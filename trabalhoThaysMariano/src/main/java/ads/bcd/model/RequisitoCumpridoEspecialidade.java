package ads.bcd.model;


import jakarta.persistence.*;
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

    protected RequisitoCumpridoEspecialidade(){}

    //N..1 com requisito
    @ManyToOne
    @JoinColumn(name = "idRequisitoEspecialidade", nullable = false)
    private RequisitoEspecialidade reqEspecialidade;

    //N..1 com Jovem
    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;



}
