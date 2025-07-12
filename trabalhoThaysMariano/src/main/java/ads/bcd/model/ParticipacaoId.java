package ads.bcd.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class ParticipacaoId implements Serializable {

    private Integer idJovem;
    private Integer idAtividade;

}
