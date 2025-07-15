package ads.bcd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class Progressao {

    @Id
    @NonNull
    private Integer idProgressao;

    @NonNull
    private String nome;

    @NonNull
    private Integer quantidadeRequisitos;

    protected Progressao(){};



}
