package ads.bcd.model;


import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class RequistiosCumpridosInsigniaId {

    private Integer idJovem;
    private Integer idRequisito;

}
