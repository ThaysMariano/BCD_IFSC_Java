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
    private Set<RequisitoProgressao> requisitosProgressao = new HashSet<>();





}
