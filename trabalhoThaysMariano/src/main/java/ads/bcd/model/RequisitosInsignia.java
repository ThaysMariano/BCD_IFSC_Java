package ads.bcd.model;

import jakarta.persistence.*;
import lombok.*;

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

    // N .. 1 Insignia
    @ManyToOne
    @JoinColumn(name = "idInsignia", nullable = false)

    // 1.. N req Cumprido
    @OneToMany(mappedBy = "RequisitosInsignia")
    private Set<RequisitoCumpridoInsignia> reqCumpridos = new HashSet<>();


}
