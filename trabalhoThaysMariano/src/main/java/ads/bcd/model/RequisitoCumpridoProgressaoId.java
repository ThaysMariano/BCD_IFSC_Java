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
public class RequisitoCumpridoProgressaoId {

    private Integer idJovem;
    private Integer idRequisitoProgressao;
}
