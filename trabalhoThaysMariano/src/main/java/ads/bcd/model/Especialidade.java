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
public class Especialidade {

    //atributos
    @Id
    @NonNull
    private Integer idEspecialidade;

    @NonNull
    private String nome;

    //Area de conhecimento

    @NonNull
    private Integer numRequisitos;

    //construtor
    protected Especialidade(){}

    //relacoes

    // 1..N com requistos
    @OneToMany(mappedBy = "Especialidade")
    private Set<RequisitoEspecialidade> requisitos = new HashSet<>();






}
