package ads.bcd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class ProgressoDaProgressao {

    @Id
    @NonNull
    private ProgressoDaProgressaoId idProgressao;

    @NonNull
    private Date data;

    // N .. 1 com Progressao
    @ManyToOne
    @JoinColumn(name = "idProgressao", nullable = false)
    private Progressao progressao;

    // N .. 1 com Jovem
    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

}
