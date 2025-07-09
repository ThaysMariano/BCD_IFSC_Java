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
public class Endereco {

    //Atributos

    @Id
    @NonNull
    private Integer idEndereco;

    @NonNull
    private String rua;

    @NonNull
    private Integer numero;

    @NonNull
    private String cep;

    @NonNull
    private String cidade;

    @NonNull
    private String estado;

    //Construtor
    protected Endereco(){}

    //Relacoes

    // 1..N com Jovem
    @OneToMany(mappedBy = "Endereco")
    private Set<Jovem> jovens = new HashSet<>();





}
