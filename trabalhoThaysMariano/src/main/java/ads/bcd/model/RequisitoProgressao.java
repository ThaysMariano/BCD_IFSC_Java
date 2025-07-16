package ads.bcd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    // N .. 1 com progressao
    @ManyToOne
    @JoinColumn(name = "idProgressao", nullable = false)
    private Progressao progressao;

    // 1 .. N com requisito Cumprido
    @OneToMany(mappedBy = "RequisitoProgresso")
    private Set<RequisitoCumpridoProgressao> reqCumpridos = new HashSet<>();




}
