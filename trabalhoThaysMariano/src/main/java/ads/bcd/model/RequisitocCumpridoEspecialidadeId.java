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
public class RequisitocCumpridoEspecialidadeId implements Serializable {

    private Integer idJovem;
    private Integer idRequisito;



}
