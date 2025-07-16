package ads.bcd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class AreaDeConhecimento {

    @Id
    @NonNull
    private Integer idAreaConhecimento;

    @NonNull
    private String nome;

    protected AreaDeConhecimento(){}

    // 1 .. N com Especialidade
    @OneToMany(mappedBy = "AreaDeConhecimento")
    private Set<Especialidade> especialidades = new HashSet<>();


}
