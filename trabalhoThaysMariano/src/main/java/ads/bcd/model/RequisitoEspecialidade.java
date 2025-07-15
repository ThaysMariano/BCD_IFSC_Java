package ads.bcd.model;


import jakarta.persistence.*;
import lombok.*;

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

    // 1..N com requisitosCumpridos
    @OneToMany(mappedBy = "RequisitoEspecialidade")
    private Set<RequisitoCumpridoEspecialidade> reqCumpridos = new HashSet<>();



}
