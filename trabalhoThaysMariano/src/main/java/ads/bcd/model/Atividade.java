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
public class Atividade {

    //Atributos

    @Id
    @NonNull
    private Integer idAtividade;

    @NonNull
    private String nome;

    //Construtor
    protected Atividade(){}

    //Relações CONFERIR
//    @ManyToMany(mappedBy = "Jovem")
//    private Set<Jovem> jovens = new HashSet<>();







}
