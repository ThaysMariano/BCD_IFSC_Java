package ads.bcd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    // 1.. N com requisito
    @OneToMany(mappedBy = "Progresao")
    private Set<RequisitoProgressao> requisitos = new HashSet<>();

    // 1 .. N progresso
    @OneToMany(mappedBy = "Progresao")
    private Set<ProgressoDaProgressao> progressos = new HashSet<>();




}
