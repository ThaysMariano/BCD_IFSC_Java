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
public class Participacao {

    //USA ESSA TABELA? - N PRA N COM MAIS COLUNAS

    //Atributos

    @Id
    @NonNull
    private Integer idParticipacao;

    //Construtor
    protected Participacao(){}

    //Relacoes CONFERIR

    @ManyToOne
    @JoinColumn(name = "idAtividade", nullable = false)
    @NonNull
    private Atividade atividade;

    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    @NonNull
    private Jovem jovem;





}
