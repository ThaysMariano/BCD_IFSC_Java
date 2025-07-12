package ads.bcd.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class Participacao {

    //Atributos
    @EmbeddedId
    @NonNull
    private ParticipacaoId idParticipacao;

    @NonNull
    private Date data;

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
