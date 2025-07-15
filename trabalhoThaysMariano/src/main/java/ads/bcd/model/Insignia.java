package ads.bcd.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.boot.model.relational.InitCommand;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class Insignia {

    @Id
    @NonNull
    private Integer insigniaId;

    @NonNull
    private String nome;

    @NonNull
    private Integer quantidadeRequisitos;

    protected Insignia(){};

    // 1 .. N com Requisito
    @OneToMany(mappedBy = "Insignia")
    private Set<RequisitoEspecialidade> requisitos = new HashSet<>();

    // N .. N com jovem
    @ManyToMany(mappedBy = "Insignia")
    private Set<Jovem> jovens = new HashSet<>();


}
