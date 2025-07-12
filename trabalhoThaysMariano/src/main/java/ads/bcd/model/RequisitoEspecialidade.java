package ads.bcd.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "idEspecialidade", nullable = false)


}
