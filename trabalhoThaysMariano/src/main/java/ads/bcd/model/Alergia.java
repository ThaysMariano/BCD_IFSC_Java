package ads.bcd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class Alergia {

    //atributos
    @Id
    @NonNull
    private Integer idAlergia;

    @NonNull
    private String nome;

    //construtor
    protected Alergia(){}

    //é n para n Jovem Alergia.
    // alergia 1----- 1..n JovemAlergia 1..n ------ 1 Jovem
    // jovem alergia é so os ids

    @ManyToMany(mappedBy = "Alergia")
    private Set<Jovem> jovens = new HashSet<>();




}
