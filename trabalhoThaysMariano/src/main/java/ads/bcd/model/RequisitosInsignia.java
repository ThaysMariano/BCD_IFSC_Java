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
public class RequisitosInsignia {

    @Id
    @NonNull
    private Integer idRequisitoInsignia;

    @NonNull
    private String descricao;

    protected RequisitosInsignia(){}

    // N .. 1 Insignia
    @ManyToOne
    @JoinColumn(name = "idInsignia", nullable = false)
    private Insignia insignia;

    // 1.. N req Cumprido
    @OneToMany(mappedBy = "RequisitosInsignia")
    private Set<RequisitoCumpridoInsignia> reqCumpridosInsignia = new HashSet<>();


}
