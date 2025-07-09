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
public class Responsavel {

    //Atributos

    @Id
    @NonNull
    private Integer idResponsavel;

    @NonNull
    private String nome;

    @NonNull
    private String telefone;

    @NonNull
    private String email;

    //Construtor
    protected Responsavel(){}

    //Relacoes

    //N..1 com endereço
    @ManyToOne
    @JoinColumn(name = "idEndereco", nullable = false)
    @NonNull
    private Endereco endereco;

    @ManyToMany(mappedBy = "Responsavel")
    private Set<Jovem> jovens = new HashSet<>();


}
