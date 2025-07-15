package ads.bcd.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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


}
