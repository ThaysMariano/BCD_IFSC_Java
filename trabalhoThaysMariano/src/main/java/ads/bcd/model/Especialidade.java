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
public class Especialidade {

    //atributos
    @Id
    @NonNull
    private Integer idEspecialidade;

    @NonNull
    private String nome;


    @NonNull
    private Integer numRequisitos;

    //construtor
    protected Especialidade(){}

    //relacoes

    // 1..N com requistos
    @OneToMany(mappedBy = "Especialidade")
    private Set<RequisitoEspecialidade> requisitosEspecialidade = new HashSet<>();

    // N .. N com jovem
    @ManyToMany(mappedBy = "Especialidade")
    private Set<Jovem> jovens = new HashSet<>();

   // N .. 1 com areaConhecimento
    @ManyToOne
    @JoinColumn(name = "idAreaCohecimento", nullable = false)




}
