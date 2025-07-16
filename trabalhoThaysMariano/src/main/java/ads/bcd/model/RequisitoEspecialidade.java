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
public class RequisitoEspecialidade {

    //atributos
    @Id
    @NonNull
    private Integer idRequisitoEspecialidade;

    @NonNull
    private String descricao;

    //construtor
    protected RequisitoEspecialidade() {
    }

    //relacoes

    //N..1 com especialidade
    @ManyToOne
    @JoinColumn(name = "idEspecialidade", nullable = false)
    private Especialidade especiadiade;

    // 1..N com requisitosCumpridos
    @OneToMany(mappedBy = "RequisitoEspecialidade")
    private Set<RequisitoCumpridoEspecialidade> reqCumpridos = new HashSet<>();



}
